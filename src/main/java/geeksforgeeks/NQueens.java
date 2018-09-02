package geeksforgeeks;

public class NQueens {
    public static void main(String[] args){
        //size of chess board
        int n = 30;
        int[][] NQ = new int[n][n];
        NQueensSolution sol = new NQueensSolution();
        long start = System.currentTimeMillis();
        boolean hasSolution = sol.solveNQ(NQ,0);
        long end = System.currentTimeMillis();
        if(hasSolution) sol.printNQSolution(NQ);
        else System.out.printf("No arrangement possible for given size: %d\n",n);
        System.out.printf("Execution time: %d",end-start);
    }
}
class NQueensSolution{
    boolean solveNQ(int[][] NQ,int currCol){
        if(currCol >= NQ.length){
            return true;
        }
        for(int R=0;R<NQ.length;R++){
            if(isSafe(NQ,R,currCol)){
                NQ[R][currCol] = 1;
                if(solveNQ(NQ,currCol+1)){
                    return true;
                }
                NQ[R][currCol] = 0;
            }
        }
        return false;
    }
    boolean isSafe(int[][] NQ,int R,int C){
        for(int c=0;c<C;c++){
            for(int r=0;r<NQ.length;r++){
                if((r == R || r-c == R-C || r+c == R+C) && NQ[r][c] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    void printNQSolution(int[][] NQ){
        System.out.println("****************");
        for(int r=0;r<NQ.length;r++){
            StringBuilder row = new StringBuilder("");
            for(int c=0;c<NQ[r].length;c++){
               row.append(" ").append(NQ[r][c]);
            }
            System.out.println(row);
        }
        System.out.println("****************") ;
    }
}
