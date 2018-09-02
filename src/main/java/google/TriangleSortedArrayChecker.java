package google;

public class TriangleSortedArrayChecker {
    public static void main(String[] args) {
        TriangleSortedArrayCheckerSolution sol = new TriangleSortedArrayCheckerSolution();
        int[] input = {1, 2, 3, 4, 9, 8, 7, 6, 5};
        System.out.println("Is given array triangle sorted: " + sol.isTriangleSortedBruteForce(input));
    }
}

class TriangleSortedArrayCheckerSolution {
    boolean isTriangleSortedBruteForce(int[] input) {
        int n = input.length;
        boolean asc = false;
        boolean hasAsc = false;
        for (int i = 2; i < n; i++) {
            if (!hasAsc) {
                if (input[i - 2] > input[i - 1]) {
                    return false;
                } else {
                    asc = true;
                    hasAsc = true;
                }
            }
            System.out.println("check1");
            if (asc) {
                System.out.println("check2");
                if (input[i - 1] > input[i]) {
                    asc = !asc;
                    System.out.println("check3");
                }
            } else {
                System.out.println("check4");
                if (input[i - 1] < input[i]) {
                    System.out.println("check5");
                    return false;
                }
            }
        }
        return true;
    }

    boolean isTriangleSortedOptimal(int[] input) {
        return true;
    }
}
