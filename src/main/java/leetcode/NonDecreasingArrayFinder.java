package leetcode;

import java.util.Arrays;

public class NonDecreasingArrayFinder {
    public static void main(String[] args){
        int[] nums = new int[]{3,4,2,3};
        boolean isNonDecreasing = new NonDecreasingArrayFinderSolution().checkPossibility(nums);
        System.out.println("Is "+Arrays.toString(nums)+" non-decreasing with at most one modification: "+isNonDecreasing);
    }
}
class NonDecreasingArrayFinderSolution{
    public boolean checkPossibility(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                int[] modNums1 = Arrays.copyOf(nums,nums.length);
                modNums1[i] = nums[i+1];
                int[] modNums2 = Arrays.copyOf(nums,nums.length);
                modNums2[i+1] = nums[i];
                if(isNonDecreasing(modNums1) || isNonDecreasing(modNums2)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    boolean isNonDecreasing(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
