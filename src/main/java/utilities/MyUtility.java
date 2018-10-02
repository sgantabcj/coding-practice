package utilities;

public class MyUtility {
    public static int[] stringToIntegerArray(String line){
        line = line.trim();
        if(line.length()==0) return new int[0];

        String[] stringArr = line.split(" ");
        int[] retVal = new int[stringArr.length];
        for(int i=0;i<stringArr.length;i++){
            String numStr = stringArr[i].trim();
            retVal[i] = (numStr.charAt(0) == '-') ? -(Integer.parseInt(numStr.substring(1))) : Integer.parseInt(numStr);
        }
        return retVal;
    }
}
