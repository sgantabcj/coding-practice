package test;

public class TestA {
    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
/*        testStringMethods();
        char a = 'A';  	int i = 0;
        Object a1,a2,a3;

        //0 is casted to char hence printed A
        System.out.print(true ? (a1=a) : 0);
        if(a1 instanceof Character) System.out.println(a1.getClass()+": a1 is a Character");
        //a is casted to int hence printed 65
        System.out.print(false ? i : (a2=a));
        if(a2 instanceof Integer) System.out.println(a2.getClass()+": a2 is an Integer");
        //a is casted to String hence printed A
        System.out.print(false ? "i" : (a3=a));
        if(a3 instanceof String) System.out.println(a3.getClass()+": a3 is a String");*/
    }

    private static void testStringMethods(){
        String testStr = "     ";
        testStr = testStr.trim();
        System.out.println(testStr+" is the remaining string after trimming with length: "+testStr.length());
    }

    private static int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;

        int retVal = 0;
        long sum = 0;
        int sign = 1;
        int index = 0;
        int len = str.length();

        if(str.charAt(index) == '+'){
            sign = 1;
            index++;
        }else if(str.charAt(index) == '-'){
            sign = -1;
            index++;
        }

        while(index < len && Character.isDigit(str.charAt(index))){
            sum = (sum * 10)+(str.charAt(index)-'0');
            if(sum >= Integer.MAX_VALUE){
                if(sign == -1 && sum >= Integer.MAX_VALUE){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            retVal = (int) sum;
            System.out.println("sum - "+sum);
            index++;
        }

        return retVal*sign;
    }
}
