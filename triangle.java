// problem: given a triangular array of integers, determine the shortest-sum path of integers from top to bottom
import java.util.*;

public class triangle {
    public static void main(String[] args) {
        
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
        
        for (int i = 0; i < triangle.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j != triangle.get(i).size()-1) {
                System.out.print(Integer.toString(triangle.get(i).get(j)) + ", ");
                }
                else {
                    System.out.print(Integer.toString(triangle.get(i).get(j)));    
                }        
            }
            System.out.print("] \n");
        }
        
        Solution S = new Solution();
        System.out.println("Solution: " + Integer.toString(S.minimumTotal(triangle)));
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = triangle.get(0).get(0);
        int idx = 0;
        int val;
        
        List<Integer> v;
        
        for (int i = 1; i < triangle.size(); i++) {
            v = leastSum(triangle.get(i),idx);
            
            idx = v.get(0);
            val = v.get(1);
            

            res += val;
        }
        
        return res;
    }
    
    public List<Integer> leastSum(List<Integer> v, int idx) {
        List<Integer> res = new ArrayList<Integer>();
        int min = v.get(idx);
        if (v.get(idx+1) < min) {
            min = v.get(idx+1);
            idx++;
        }
        
        res.add(idx);
        res.add(min);
        
        return res;
    }
}
