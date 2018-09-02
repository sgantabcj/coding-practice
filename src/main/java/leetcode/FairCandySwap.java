package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public static void main(String[] args) {
        FairCandySwapSolution sol = new FairCandySwapSolution();
        int[] A = {2, 36, 17, 22, 38, 15, 15, 47, 40, 42};
        int[] B = {75, 96, 76, 75, 30};
        int[] res = sol.fairCandySwap(A, B);
        if (res != null) System.out.println("The elements at indices to be swapped are: " + Arrays.toString(res));
        else System.out.println("not found/error");
    }
}

class FairCandySwapSolution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sA=0;
        int sB=0;
        for(int a:A) sA += a;
        for(int b:B) sB += b;
        int delta = (sB-sA)/2;

        Set<Integer> setB = new HashSet<>();
        for(int y:B) setB.add(y);

        for(int x:A){
            if(setB.contains(delta+x)){
                return new int[]{x,delta+x};
            }
        }
        return null;
    }

    int getArrSum(int[] A) {
        int retVal = 0;
        for (int a : A) {
            retVal += a;
        }
        return retVal;
    }
}