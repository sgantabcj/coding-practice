package leetcode;

public class CountAndSay {
    public static void main(String[] args){
        int input = 50;
        CountAndSaySolution sol = new CountAndSaySolution();
        System.out.println(input + " element in count and say sequence is: "+sol.countAndSay(input));
        OptimalCountAndSaySolution sol1 = new OptimalCountAndSaySolution();
        System.out.println("using optimal solution: "+sol1.countAndSay(input));
    }
}
class CountAndSaySolution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }else if(n==2){
            return "11";
        }

        String retVal = "11";
        StringBuilder temp = new StringBuilder("");

        for(int i=3;i<=n;i++){
            int count = 1;
            char[] charArray = retVal.toCharArray();
            int len = charArray.length;
            char prev = charArray[0];
            for(int j=1;j<len;j++){
                char curr = charArray[j];
                if(prev == curr){
                    count++;
                    if(j==len-1){
                        temp.append(count).append(prev);
                    }
                }else{
                    temp.append(count).append(prev);
                    count = 1;
                    prev = curr;
                    if(j==len-1){
                        temp.append(count).append(prev);
                    }
                }
            }
            retVal = temp.toString();
            temp = new StringBuilder("");
        }

        return retVal;
    }
}

class OptimalCountAndSaySolution{
    public String countAndSay(int n) {
        String str = "1";
        while(n>1){
            n--;
            str = countAndSayString(str);
        }
        return str;
    }

    public String countAndSayString(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<chars.length){
            int count=1;

            if(i+1<chars.length){
                while(chars[i+1]==chars[i]){
                    i++;
                    count++;
                    if(i==chars.length-1) break;
                }
            }


            char countChar = (char) (count+'0');
            sb.append(countChar);
            sb.append(chars[i]);
            i++;
        }
        return sb.toString();
    }
}