// problem: given an array of integers sorted in non-decreasing order,
// remove duplicate elements in-place and return the number of unique
// elements remaining in the array.

import java.util.*;

public class remove_duplicates {

  public static void main(String[] args) {
    int[] test = {1, 1, 2, 3, 4, 4, 5, 6, 7, 7, 7};
    System.out.println("Output: " + removeDuplicates(test));
  }

  public static int removeDuplicates(int[] nums) {
    for (int i = 0; i < nums.length-1; i++) {
      if (nums[i+1] == nums[i]) {
        nums[i] = 101;    // set to value limit to avoid collision
      }
    }
    Arrays.sort(nums);
    int res = 0;
    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != 101) {
          res++;
        }
    }

    return res;

    }
}
