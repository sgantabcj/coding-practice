package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReorderedPowerOf2 {
    public static void main(String[] args){
        int input = 24;
        System.out.println("Is reordered power of 2: "+new ReorderedPowerOf2Solution().reorderedPowerOf2(input));
    }
}
class ReorderedPowerOf2Solution {
    public boolean reorderedPowerOf2(int N) {
        double p=1;
        int twoPow = 1;
        Map<Character,Integer> NMap = intToMap(N);
        while(integerLen(twoPow) <= integerLen(N)){
            if(integerLen(twoPow) == integerLen(N) && intToMap(twoPow).equals(NMap)){
                return true;
            }
            p = p+1;
            twoPow = (int) Math.pow(2, p);
        }
        return false;
    }
    private Map<Character, Integer> intToMap(int num){
        Map<Character,Integer> retVal = new HashMap<>();
        String intStr = String.valueOf(num);
        for(int i=0;i<intStr.length();i++){
            if(retVal.containsKey(intStr.charAt(i))){
                retVal.put(intStr.charAt(i),retVal.get(intStr.charAt(i))+1);
            }else{
                retVal.put(intStr.charAt(i),1);
            }
        }
        return retVal;
    }
    private int integerLen(int twoPow){
        return (int) (Math.log10(twoPow) + 1);
    }
}