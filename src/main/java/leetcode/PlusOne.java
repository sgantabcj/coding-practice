package leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] input = new int[3];
        PlusOneSolution sol = new PlusOneSolution();
        System.out.printf("Adding one to the array representation of the integer: %s is: %s",Arrays.toString(input),Arrays.toString(sol.plusOne(input)));
    }
}

class PlusOneSolution {
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        int sum = digits[len - 1] + 1;
        int carryOver = 1;

        int index = len - 1;

        do {
            sum = digits[index] + carryOver;
            if (sum > 9) {
                digits[index] = sum % 10;
                carryOver = sum / 10;
            } else {
                digits[index] = sum;
                carryOver = 0;
            }
            index--;
        } while (carryOver > 0 && index >= 0);

        if (carryOver > 0) {
            int[] retVal = new int[digits.length + 1];
            retVal[0] = 1;
            return retVal;
        }
        return digits;
    }
}
