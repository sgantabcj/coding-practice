package multithreading;

public class MultithreadingMethodsTest {
    public static void main(String[] args) {
        //to see how notify and works is useful
        int input = 50;
        Calculator calculator = new Calculator(input, "cal-1");
        calculator.start();
        synchronized (calculator) {
            try {
                calculator.wait();
            } catch (InterruptedException ie) {
                System.out.println("Thread " + calculator.getName() + "got interrupted");
            }
        }
        System.out.println("Sum of first " + input + "natural number is: " + calculator.sum);
    }
}

class Calculator extends Thread {
    int n;
    long sum;

    Calculator(int n, String name) {
        this.n = n;
        this.setName(name);
    }

    public void run() {
        synchronized (this) {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
        }
        notify();
    }
}