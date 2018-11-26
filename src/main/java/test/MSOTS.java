package test;

public class MSOTS {
    public static void main(String[] args) {
        makeTheNumbersMatch(6,9,2,1);
    }

    public static void makeTheNumbersMatch(int a, int b, int x, int y) {
        while (a != x || b != y) {
            if (a > x) {
                a--;
            } else {
                a++;
            }
            if (b > y) {
                b--;
            } else {
                b++;
            }
            System.out.println("a: "+a);
            System.out.println("b: "+b);
        }
    }

}
