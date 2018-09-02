package leetcode;

public class ClimbingSteps {
    public static void main(String[] args){
        int input = 4;
        ClimbingStepsSolution sol = new ClimbingStepsSolution();
        System.out.printf("The number of ways %d steps can be climbed in 1 and 2 step combination is: %d",input,sol.climbStairs(input));
    }
}

class ClimbingStepsSolution{
    //Using memoization
    int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climb_Stairs(0,n,memo);
    }
    private int climb_Stairs(int i,int n,int[] memo){
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(memo[i]>0){
            return memo[i];
        }
        memo[i] = climb_Stairs(i+1,n,memo) + climb_Stairs(i+2,n,memo);
        return memo[i];
    }
}