package princeton;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
 * Stack implementation using an array
 */
public class ArrayStackOfStrings {
    public static void main(String[] args) {
        int capacity = 3;
        ArrayStackOfStringsSolution stack = new ArrayStackOfStringsSolution(capacity);
        stack.push("1");
        System.out.println(stack.toString());
        stack.push("2");
        System.out.println(stack.toString());
        System.out.printf("pop - %s\n", stack.pop());
        System.out.println(stack.toString());
        stack.push("3");
        System.out.printf("pop - %s\n", stack.pop());
        System.out.printf("pop - %s\n", stack.pop());
        System.out.println(stack.toString());
    }
}

class ArrayStackOfStringsSolution {
    private String[] s;
    private int N;

    ArrayStackOfStringsSolution(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        if (N < s.length) {
            s[N++] = item;
            return;
        }
        throw new StackOverflowError();
    }

    public String pop() {
        if (!isEmpty()) {
            String retVal = s[--N];
            s[N] = null;
            return retVal;
        }
        throw new EmptyStackException();
    }
    public String toString(){
        return Arrays.toString(s);
    }
}
