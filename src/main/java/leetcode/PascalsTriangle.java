package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 10;
        int rowIndex = 10;
        PascalsTriangle pt = new PascalsTriangle();
//        pt.printMultiList(pt.generatePascalTriangle(numRows));
        for(int i=0;i<=rowIndex;i++)
            System.out.println(rowIndex+" row of pascal triangle is: "+Arrays.toString(pt.getRow(i).toArray()));
    }

    private void printMultiList(List<List<Integer>> multiList) {
        if (multiList == null) {
            System.out.println("Empty list");
        }
        int len = multiList.size();
        for (int i = 0; i < len; i++) {
            List<Integer> innerList = multiList.get(i);
            System.out.println(Arrays.toString(innerList.toArray()));
        }
    }

    private List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> retVal = new ArrayList<>();
        List<Integer> currList;
        for (int i = 1; i <= numRows; i++) {
            currList = new ArrayList<>();
            if (i == 1) {
                currList.add(1);
                retVal.add(currList);
                continue;
            }
            List<Integer> prevList = retVal.get(i - 2);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    currList.add(1);
                }else{
                    currList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            retVal.add(currList);
        }
        return retVal;
    }

    private List<Integer> getRow(int rowIndex){
        List<Integer> prev = new ArrayList<>(rowIndex+1);
        prev.add(1);
        if(rowIndex == 0) return prev;
        prev.add(1);
        int i=1;
        while(i<rowIndex){
            for(int j=prev.size()-1;j>0;j--){
                prev.set(j,prev.get(j-1)+prev.get(j));
            }
            prev.add(1);
            i++;
        }
        return prev;
    }
}
