package leetcode;

import java.util.Arrays;

public class MaxSizeContainer {
    public static void main(String[] args) {
        //for test case {1,8,6,2,5,4,8,3,7} maxArea is 49
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxSizeContainer = maxArea(input);
        System.out.println("maxArea for the given input: " + Arrays.toString(input) + " is: " + maxSizeContainer);
    }

    static int maxArea(int[] height) {
        int maxSize = 0;
        int r = height.length - 1, l = 0;
        while (l < r) {
            int currSize = Math.min(height[l],height[r]) * (r - l);
            maxSize = Math.max(currSize, maxSize);
            //the trick here is max area is always limited by the smallest height, so increment the smallest height pointer
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxSize;
    }
}
