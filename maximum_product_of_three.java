// problem: given an array of integers, find the three numbers whose product is the maximum in the set, and return the product.
import java.util.*;

public class maximum_product_of_three {
    public static void main(String[] args) {
        int[] nums = {-9, -19, -28, 1, 3, 4, 5, 8, 9, 7, 16, 32, 20, 25};
        System.out.println(maximumProduct(nums));
    }
    
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        
        int multOne = nums[0]*nums[1]*nums[nums.length-1];
        int multTwo = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
            
        if (multOne > multTwo) {
            System.out.println("Numbers: " + nums[0] + ", " + nums[1] + ", " + nums[nums.length-1]);
            return multOne;
        }
        else {
            System.out.println("Numbers: " + nums[nums.length-1] + ", " + nums[nums.length-2] + ", " + nums[nums.length-3]);
            return multTwo;
        }
    }
}
