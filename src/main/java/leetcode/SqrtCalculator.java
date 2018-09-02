package leetcode;

public class SqrtCalculator {
    public static void main(String[] args){
        int input = 1064;
        SqrtCalculatorSolution sol = new SqrtCalculatorSolution();
        System.out.printf("The sqrt of: %d is: %d",input,sol.mySqrt(input));
    }
}

class SqrtCalculatorSolution{
    //Using binary search
    int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int lo = 1;
        int hi = x;
        int mid;
        int ans = 0;
        while(lo<=hi){
            mid = lo+(hi-lo)/2;
            if(mid <= x/mid){
                lo = mid+1;
                ans = mid;
            }else hi = mid-1;
        }

        return ans;
    }
}
