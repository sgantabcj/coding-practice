package leetcode;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "dbca";

        String S = "beb";

        int ret = new Solution().numJewelsInStones(J, S);

        String out = String.valueOf(ret);

        System.out.print(out);
    }
}

class Solution {
    public int numJewelsInStones(String J, String S) {
        if(S.length() == 0) {return 0;}
        Map<String,Integer> stoneMap = stringToMap(S);
        int count = 0;
        for(int i=0;i<J.length();i++){
            String currentChar = String.valueOf(J.charAt(i));
            if(stoneMap.containsKey(currentChar)) {count += stoneMap.get(currentChar);}
        }
        return count;
    }

    private Map<String,Integer> stringToMap(String S){
        Map<String,Integer> stoneMap = new HashMap<String,Integer>();
        for(int i=0;i<S.length();i++){
            String currentChar = String.valueOf(S.charAt(i));
            System.out.println("Iteration: "+i);
            if(stoneMap.containsKey(currentChar)){
                stoneMap.put(currentChar,stoneMap.get(currentChar).intValue()+1);
            }else{
                stoneMap.put(currentChar,1);
            }
        }
        stoneMap.forEach((key,value) -> System.out.println(key +" : "+value));
        return stoneMap;
    }
}