package leetcode;

public class LongestPalindromeSubstringFinder {
    public static void main(String[] args) {
        String input = "babad";
        System.out.print("The longest palindrome substring of given string: " + input + " is: " + new LongestPalindromeSubstringFinderSolution().longestPalindrome(input));
    }
}

class LongestPalindromeSubstringFinderSolution {
/*    //Second approach
    public String longestPalindrome(String s) {
        String retVal = "";
        int n = s.length();
        int longLength = 0, i = 0, j = 0;
        while (i < n && j < n) {
            String subString = s.substring(i, j+1);
            if (isPalindrome(subString)){
                longLength = Math.max(longLength, j-i);
                retVal = (subString.length()>longLength) ? subString : retVal;
                j++;
                System.out.println("palindrome: "+subString+" i: "+i+" j: "+j+" retVal: "+retVal+" longLength: "+longLength);
            } else {
                System.out.println("not a palindrome: "+subString+" i: "+i+" j: "+j+" retVal: "+retVal+" longLength: "+longLength);
                i++;
            }
        }
        return retVal;
    }*/

    //First approach - fell short by time complexity
    public String longestPalindrome(String s) {
        String retVal = "";
        int n = s.length();
        for(int i=0;i<n;i++){
            System.out.print("i: "+i);
            for(int j=n;j>=i+1;j++){
                System.out.println(" j: "+j);
                String substr = s.substring(i,j);
                System.out.println(substr);
                if(substr.length()>retVal.length() && isPalindrome(substr)) retVal = substr;
            }
        }
        return retVal;
    }
    boolean isPalindrome(String s) {
        int l = s.length();
        if (l == 1) {
            return true;
        }
        for(int i=0;i<l/2;i++){
            if(s.charAt(i)!=s.charAt(l-i-1)) return false;
        }
        return true;
    }
}
