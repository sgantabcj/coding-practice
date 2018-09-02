package leetcode;

import java.util.Arrays;

public class MaxSumSubArrayFinder {
    public static void main(String[] args){
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        MaxSumSubArrayFinderSolution sol = new MaxSumSubArrayFinderSolution();
        System.out.printf("The max sum of contiguous sub array elements for the array: %s is: %d\n",Arrays.toString(input),sol.maxSumSubArray1(input));
        System.out.printf("The max sum of contiguous sub array elements using optimal solution is: %d\n",sol.maxSumSubArray2(input));

        //for all negative array elements case
        input = new int[]{-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.printf("The max sum of contiguous sub array elements for the array: %s is: %d\n",Arrays.toString(input),sol.maxSumSubArray1(input));
        System.out.printf("The max sum of contiguous sub array elements using optimal solution is: %d",sol.maxSumSubArray2(input));
    }
}
class MaxSumSubArrayFinderSolution {
    //Kadane's algorithm
    public int maxSumSubArray1(int[] nums) {
        int max_sum_so_far = 0;
        int curr_max_sum = 0;
        for(int i=0;i<nums.length;i++){
            curr_max_sum += nums[i];
            if(curr_max_sum < 0){
                curr_max_sum = 0;
            }else if(max_sum_so_far < curr_max_sum){
                max_sum_so_far = curr_max_sum;
            }
        }
        return max_sum_so_far;
    }

    //works for case where all array elements are negative
    public int maxSumSubArray2(int[] nums){
        int max_sum_so_far = nums[0];
        int curr_max_sum = nums[0];
        for(int i=1;i<nums.length;i++){
            curr_max_sum = Math.max(nums[i],curr_max_sum+nums[i]);
            max_sum_so_far = Math.max(curr_max_sum,max_sum_so_far);
        }
        return max_sum_so_far;
    }
}