package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MorseCodeWords {
    public static void main(String[] args) {
        String line = "This is a line";
        String delimiter = " ";
        String[] words = stringToStringArray(line, delimiter);
        System.out.println("words: "+ Arrays.toString(words));

        int ret = new morseWordsSolution().uniqueMorseRepresentations(words);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

    private static String[] stringToStringArray(String line, String wordDelimiter) {
        line = line.toLowerCase();
        return line.split(wordDelimiter);
    }
}

class morseWordsSolution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseArr = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> transformedSet = new HashSet<>();
        if (words == null || words.length == 0) {
            return transformedSet.size();
        }
        for (String word : words) {
            String transformedStr = "";
            for (int i = 0; i < word.length(); i++) {
                transformedStr += String.valueOf(morseArr[word.charAt(i) - 97]);
            }
            System.out.println("normal word: "+word+" transformed word: "+transformedStr);
            transformedSet.add(transformedStr);
        }
        transformedSet.forEach(System.out::println);
        return transformedSet.size();
    }
}
