package leetcode;

import utilities.MyUtility;

import java.util.*;

public class NCombinations {
    public static void main(String[] args) {
        int N = 5;
        int K = 2;
        NCombinations nc = new NCombinations();
        List<List<Integer>> result = nc.getNComb(N, K);
        MyUtility.printMultiList(result);
    }

    public List<List<Integer>> getNComb(int N, int K) {
        List<List<Integer>> retVal = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        getNComb(q, N, K, 1, retVal);
        return retVal;
    }

    public void getNComb(Deque<Integer> q, int N, int K, int start, List<List<Integer>> retVal) {
        if (q.size() == K) {
            retVal.add(new ArrayList<>(q));
            return;
        }
        int i = start;
        while(i <= (N-K+q.size()+1)) {
            q.addLast(i);
            getNComb(q, N, K, i + 1, retVal);
            q.pollLast();
            i++;
        }
    }
}
