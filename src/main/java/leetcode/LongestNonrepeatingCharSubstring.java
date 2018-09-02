package leetcode;

public class LongestNonrepeatingCharSubstring {
    public static void main(String[] args){
        String inputStr = "dvdf";
        int ret = new LongestNonrepeatingCharSubstringSolution().lengthOfLongestSubstring(inputStr);
        System.out.println("length of longest substring: "+ret);
        /*int input = 6;
        String toBinaryStr = Integer.toBinaryString(input);
        int longDistance = 0;
        for(int i=0;i<toBinaryStr.length();i++){
            if(toBinaryStr.charAt(i) == '1'){
                longDistance = (toBinaryStr.indexOf('1',i+1)-i) >longDistance ? toBinaryStr.indexOf('1',i+1)-i : longDistance;
            }
        }
        System.out.println(toBinaryStr+" | longest distance: "+longDistance);*/
    }
}
class LongestNonrepeatingCharSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }else if(s.length() == 1){
            return 1;
        }

        int retVal = 0;
        StringBuilder tempString = new StringBuilder(s.substring(0,1));
        System.out.println("Initial string: "+tempString);
        for(int i=1;i<s.length();i++){
            if(tempString.toString().indexOf(s.charAt(i))<0){
                tempString.append(s.charAt(i));
                System.out.println("not present");
            }else{
                retVal = (tempString.length()>retVal) ? tempString.length() : retVal;
                System.out.println("substring: "+tempString.toString().substring(tempString.toString().indexOf(s.charAt(i))));
                String tempStr = tempString.substring(tempString.toString().indexOf(s.charAt(i))+1);
                tempString = new StringBuilder(tempStr);
                tempString.append(s.charAt(i));
                System.out.println("present");
            }
            System.out.println("tempString: "+tempString+" | long string length: "+retVal);
        }

        if(tempString.length() > retVal){
            retVal = tempString.length();
        }
        return retVal;
    }
}