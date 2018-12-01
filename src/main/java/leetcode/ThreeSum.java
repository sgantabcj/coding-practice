package leetcode;

import utilities.MyUtility;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args){
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        MyUtility.printMultiList(threeSum(input));
    }

    //Currently better than only 5% of the submitted solutions
    //to do - improve further on time complexity
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i <=len - 3; i++) {
            int j=i+1;
            int k=len-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j++],nums[k--])));
                }else if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
