// problem: determine how many steps it takes to fully water an array of plants given a bucket of
// a set capacity. if you don't have exactly the amount of water required for a plant, you must step back
// to the begininning of the array (water source is at x = -1).


public class watering_plants {
    public static void main(String[] args) {
        int[] plants = {2,2,3,3};
        int capacity = 5;
        
        Solution S = new Solution();
        
        System.out.print("Inputs: [");
        for (int i = 0; i < plants.length; i++) {
            if (i != plants.length-1) {
                System.out.print(Integer.toString(plants[i]) + ", ");
            }
            else {
                System.out.print(Integer.toString(plants[i]) + "]\n");
            }
        }
        
        S.wateringPlants(plants,capacity);
    }
}

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int water = capacity;
        int steps = 0;
        for (int i = 0; i < plants.length; i++) {
            if (water >= plants[i]) {
                System.out.println("watering plant " + Integer.toString(i+1));
                water -= plants[i];
            }
            else {
                System.out.println("out of water on step " + Integer.toString(steps));
                i--;
                steps += i*2 + 1;
                water = capacity;
                
            }
            steps++;
        }
        
        return steps;
    }
}
