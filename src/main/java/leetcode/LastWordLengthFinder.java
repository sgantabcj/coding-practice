package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastWordLengthFinder {
    public static void main(String[] args) {
        String input = "Returns the offset after the last character of the subsequence captured by the given group during the previous match operation";
        LastWordLengthFinderSolution sol = new LastWordLengthFinderSolution();
        long start = System.currentTimeMillis();
        System.out.printf("The length of the last word for string: %s is: %d ", input, sol.lengthOfLastWord2(input));
        long end = System.currentTimeMillis();
        System.out.printf("& time taken is: %d\n",end-start);
        start = System.currentTimeMillis();
        System.out.printf("The length of the last word using optimal solution is: %d ", sol.lengthOfLastWord1(input));
        end = System.currentTimeMillis();
        System.out.printf("& time taken is: %d\n",end-start);
    }
}

class LastWordLengthFinderSolution {
    //simple and fast solution
    public int lengthOfLastWord1(String s) {
        int lastWordLen = 0;
        boolean isWordPresent = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lastWordLen++;
                isWordPresent = true;
            } else {
                if (isWordPresent) break;
            }
        }
        return lastWordLen;
    }


    //takes huge amount of time for pattern
    public int lengthOfLastWord2(String s) {
        Pattern p = Pattern.compile("\\s*([a-zA-Z]+)\\s*$");
        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.printf("The match is found: %s\n", m.group(1));
            return m.group(1).length();
        }
        return 0;
    }
}
