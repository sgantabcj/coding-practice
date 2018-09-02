package geeksforgeeks;

public class MaximumConsecutiveRepeatingCharacterFinder {
    public static void main(String[] args){
        String input = "geeekk";
        String input2 = "aaaabbcbbb";
        MaximumConsecutiveRepeatingCharacterFinderSolution sol = new MaximumConsecutiveRepeatingCharacterFinderSolution();
    }
}
class MaximumConsecutiveRepeatingCharacterFinderSolution{
    char findMaximumRepeatedChar(String s){
        int count = 0;
        int len = s.length();
        char[] cArr = s.toCharArray();
        for(int i=0;i<len;i++){
            char c = cArr[i];
            if(i != len-1 && cArr[i+1] == c){

            }
        }
        return ' ';
    }
}
