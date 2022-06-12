/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.
*/

import java.util.*;

public class maximum_deletion_score {
    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        Solution S = new Solution();
        S.maximumUniqueSubarray(nums);
    }
}

class Solution {
    HashMap<Integer,Integer> seen = new HashMap<Integer,Integer>();
    int max = 0;
    int s = 0;
    
    public int maximumUniqueSubarray(int[] nums) {
        
        System.out.println("Size: " + Integer.toString(nums.length)+"\n");
        
        int idx = 0; 
        while (idx != nums.length) {
            //System.out.println("idx: " + Integer.toString(idx));
            
            if (!seen.containsKey(nums[idx])) {
                seen.put(nums[idx],1);
                idx++;
            }
            else {
                idx--;
                s = getSum();
                if (s > max) {
                    max = s;
                    System.out.println("idx: " + Integer.toString(idx));
                    System.out.println("max: " + Integer.toString(max));
                    
                }
            }
            
            if (idx == nums.length) {
                s = getSum();
                if (s > max) {
                    max = s;
                    System.out.println("idx: " + Integer.toString(idx));
                    System.out.println("max: " + Integer.toString(max));
                }
            }
            
        }
        
        return max;
    }
    
    
    public void incrementValueFromKey(Integer key){
        seen.computeIfPresent(key, (k, v) -> v + 1);
    }
    
    public int getSum() {
        s = 0;
        seen.forEach((k,v) -> {
            s += k;
        });
        
        seen = new HashMap<Integer,Integer>();
        return s;
    }
}


