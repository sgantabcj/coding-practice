package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigZagStringPrinter {
    public static void main(String[] args){
        String input = "PAYPALISHIRING";
        int rowCount = 3;
        ZigZagStringPrinterSolution sol = new ZigZagStringPrinterSolution();
        System.out.println("The zig zag converted representation of string: "+ input + " is: "+sol.convertSortingThroughRows(input,rowCount));
        System.out.println("The converted string using second method: "+sol.convertVisitByRow(input,rowCount));
    }
}
class ZigZagStringPrinterSolution{
    String convertSortingThroughRows(String s, int rowCount){
        int n = s.length();
        if(n == 1) return s;
        List<StringBuilder> rows = new ArrayList();
        for(int i=0;i<Math.min(rowCount,n);i++){
            rows.add(i,new StringBuilder());
        }
        boolean goingDown = false;
        int currRow = 0;
        for(char c : s.toCharArray()){
            rows.get(currRow).append(c);
            if(currRow == 0 || currRow == rowCount-1){
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder retVal = new StringBuilder();
        for(StringBuilder row : rows){
            retVal.append(row);
        }
        return retVal.toString();
    }

    String convertVisitByRow(String s,int rowCount){
        int n = s.length();
        if(n == 1){
            return s;
        }

        StringBuilder retVal = new StringBuilder();
        int interval = 2*(rowCount - 1);
        char[] charArray = s.toCharArray();
        for(int i=0;i<rowCount;i++){
            for(int j=0;j+i<n;j+=interval){
                retVal.append(charArray[j+i]);
                if(i > 0 && i < rowCount-1 && j+interval-i < n){
                    retVal.append(charArray[j+interval-i]);
                }
            }
        }
        return retVal.toString();
    }
}
