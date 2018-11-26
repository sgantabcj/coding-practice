package leetcode;

import utilities.MyUtility;

import java.util.*;

public class KSum {
    public static void main(String[] args){
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        int size = 3;
        MyUtility.printMultiList(kSum(input,size));
    }

    private static List<List<Integer>> kSum(List<List<Integer>> retVal, Deque<Integer> stack, int[] input, int k, int nextIndex){
        if(stack.size() == k){
            Iterator<Integer> stackItr = stack.iterator();
            int sum = 0;
            while(stackItr.hasNext()){
                sum+=stackItr.next();
            }
            if(sum==0){
                retVal.add(new ArrayList<>(stack));
            }
        }
        if(stack.size() < k){
            int pos = stack.size();
            for(int i=nextIndex;i<=((input.length-1)-(k-pos));i++){
                stack.push(input[i]);
                kSum(retVal,stack,input,k,i+1);
                stack.pop();
            }
        }
        return retVal;
    }

    private static List<List<Integer>> kSum(int[] input, int k){
        List<List<Integer>> retVal = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        return kSum(retVal,stack,input,k,0);
    }
}
