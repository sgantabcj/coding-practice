package leetcode;

import java.util.Arrays;

public class SortedArrayDedup {
    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int uniqueNums = new SortedArrayDedupSolution().removeDuplicates(nums);
        System.out.println("Array after deduping: "+ Arrays.toString(nums)+" & number of unique ints: "+uniqueNums);
    }
}
class SortedArrayDedupSolution{
    public int removeDuplicates(int[] nums) {
        int uniqueNums = 0;
        if(nums == null || nums.length == 0){
            return uniqueNums;
        }
        int currentNum = nums[0];
        uniqueNums=1;
        for(int i : nums){
            if(currentNum != i){
                currentNum = i;
                nums[uniqueNums] = i;
                uniqueNums++;
            }
        }
        return uniqueNums;
    }
}