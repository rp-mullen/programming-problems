/*
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
*/

class rearrange_elems_by_sign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.print("input: { ");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.print("}\n");
        
        int[] sol = Solution.rearrangeArray(nums);
    
        System.out.print("output: { ");
        for (int i : sol) {
            System.out.print(i + " ");
        }
        System.out.print("}\n");
        
    }
}

class Solution {
    public static int[] rearrangeArray(int[] nums) {
        int[] negs = new int[nums.length/2];
        int[] pos = new int[nums.length/2];
        
        int[] res = new int[nums.length];
        
        int negs_idx = 0;
        int pos_idx = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negs[negs_idx] = nums[i];
                negs_idx++;
            }
            else {
                pos[pos_idx] = nums[i];
                pos_idx++;
            }
        }
        
        negs_idx = 0;
        pos_idx = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                res[i] = negs[negs_idx];
                negs_idx++;
            } else {
                res[i] = pos[pos_idx];
                pos_idx++;
            }
        }
        
        return res;
    }
}
