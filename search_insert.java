/* 
problem: Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity. 
*/
public class search_insert {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        
        System.out.print("input: {");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length-1) {
                System.out.print(nums[i] + ", ");
            } else {
                System.out.print(nums[i] + "}\n");
            }
        }
        Solution.test(nums,5);
        Solution.test(nums,2);
        Solution.test(nums,3);
    }
    
}

class Solution {
    public static int searchInsert(int[] nums, int target) {
        int res = -1;
        boolean exactFound = false;
        boolean answerFound = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = i;
                answerFound = true;
                exactFound = true;
                break;
                
                
            } else if (nums[i] > target && !exactFound) {
                res = i;
                answerFound = true;
                break;
            }
        }
        
        if(!answerFound) {
            res = nums.length; 
        }
        
        return res;
    }
    
    public static void test(int[] arr,int x) {
        int res = Solution.searchInsert(arr,x);
        System.out.println("input: " + x + "\tresult: " + res);
    }
}
