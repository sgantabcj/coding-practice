package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerConverter {
    public static void main(String[] args){
        String romanNumeral = "MCMXCIV";
        RomanToIntegerSolution romanToIntegerSolution = new RomanToIntegerSolution();
        System.out.println(romanNumeral+" : "+romanToIntegerSolution.romanToInt(romanNumeral));
    }
}

class RomanToIntegerSolution {
    public int romanToInt(String s) {
        Map<String,Integer> romanToIntMap = new HashMap<>(){{
            put("i",1);
            put("v",5);
            put("x",10);
            put("l",50);
            put("c",100);
            put("d",500);
            put("m",1000);
            put("iv",4);
            put("ix",9);
            put("xl",40);
            put("xc",90);
            put("cd",400);
            put("cm",900);
        }};

        s = s.toLowerCase();
        int count = 0;
        String key = "";
        for(int i=0;i<s.length();i++){
            if(i+2<s.length() && romanToIntMap.containsKey(key = s.substring(i,i+2))){
                count += romanToIntMap.get(key);
                i+=1;
            }else if(i+2 == s.length() && romanToIntMap.containsKey(key = s.substring(i))){
                count += romanToIntMap.get(key);
                i+=1;
            }else if(romanToIntMap.containsKey(key = s.substring(i,i+1))){
                count += romanToIntMap.get(key);
            }else{
                throw new IllegalArgumentException();
            }
        }
        return count;
    }
}
