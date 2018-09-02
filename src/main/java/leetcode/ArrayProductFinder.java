package leetcode;

import java.util.Arrays;

public class ArrayProductFinder {
    public static void main(String[] args){
        int[] input = {3,2,4,0};
        System.out.print("Product array for the input array: "+Arrays.toString(input)+" is: "+ Arrays.toString(new ArrayProductFinderSolution().otherElementsProduct(input)));
    }
}
class ArrayProductFinderSolution{
    public int[] otherElementsProduct(int[] inputArr){
        int inputArrLength = inputArr.length;

        if(inputArrLength == 0 || inputArrLength==1){
            return inputArr;
        }

        int[] retVal = new int[inputArrLength];
        int[] frontProductArr = Arrays.copyOf(inputArr,inputArrLength),backProductArr = Arrays.copyOf(inputArr,inputArrLength);

        for(int i=1;i<inputArrLength;i++){
            frontProductArr[i] = frontProductArr[i-1] * inputArr[i];
        }

        System.out.println("Front product array: "+Arrays.toString(frontProductArr));

        for(int i=inputArrLength-2;i>=0;i--){
            backProductArr[i] = backProductArr[i+1] * inputArr[i];
        }
        System.out.println("Back product array: "+Arrays.toString(backProductArr));

        for(int i=0;i<inputArrLength;i++){
            if(i==0){
                retVal[i] = backProductArr[i+1];
            }else if(i==inputArrLength-1){
                retVal[i] = frontProductArr[i-1];
            }else{
                retVal[i] = frontProductArr[i-1] * backProductArr[i+1];
            }
        }

        return retVal;
    }
}
