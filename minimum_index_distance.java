import java.util.*;

// given an array of integers (nums), an integer (start), and an integer (target), find an index
// (i) of nums such that nums[i] == target, and abs(i - start) is minimized.

public class minimum_index_distance {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 5;
        int start = 3;
        
        System.out.print("Input Array: [");    
        for (int i = 0; i < nums.length; i++ ) {    
            if (i == nums.length) {    
                System.out.print(nums[i] + "]\n");
                }
            else {
                System.out.print(nums[i] + ", ");
            }
        }
    
        System.out.println("Target: " + target);
        System.out.println("Start: " + start);
        System.out.println("minimum distance: " + getMinDistance(nums,target,start));
    }
    
    public static int getMinDistance(int[] nums, int target, int start) {
        // minimize abs(i - start) where i is the index for target
        
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int minimum;
        
        // (1) get indices of instances of target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indices.add(i);
            }
        }
        // (2) sort through indices to find minimum
        minimum = Math.abs(indices.get(0) - start);
        for (int j = 0; j < indices.size(); j++) {
            if (Math.abs(indices.get(j) - start) < minimum) {
                minimum = Math.abs(indices.get(j) - start);
            }
        }
        return minimum;
    }
}
