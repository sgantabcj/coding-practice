package visa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RepeatedWordFinder {
    public static void main(String[] args){
        String input = "This is the     ;:- given string";
        RepeatedWordFinderSolution sol = new RepeatedWordFinderSolution();
        sol.firstRepeatedWord(input);
    }
}
class RepeatedWordFinderSolution{
    String firstRepeatedWord(String s){
        s = s.replaceAll("[\\s.;:-]+"," ");
        String[] words = s.split("[\\s]");
        System.out.print(Arrays.toString(words));
        Set<String> wordSet = new HashSet();
        for(String word : words){
            if(!wordSet.add(word)){
                return word;
            }
        }
        return "none found";
    }
}
