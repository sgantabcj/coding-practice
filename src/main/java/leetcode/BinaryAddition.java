package leetcode;

public class BinaryAddition {
    public static void main(String[] args) {
        String bN1 = "1010";
        String bN2 = "1011";
        BinaryAdditionSolution sol = new BinaryAdditionSolution();
        System.out.printf("Addition of binary numbers: %s + %s = %s", bN1, bN2, sol.addBinary(bN1, bN2));
    }
}

class BinaryAdditionSolution {
    String addBinary(String a, String b) {
        int carryOver = 0;
        StringBuilder retVal = new StringBuilder();

        int aLen = a.length();
        int bLen = b.length();
        int aIndex = aLen - 1;
        int bIndex = bLen - 1;

        int sum;
        while (aIndex >= 0 && bIndex >= 0) {
            sum = (a.charAt(aIndex) - 48) + (b.charAt(bIndex) - 48) + carryOver;
            switch (sum) {
                case 0:
                case 1:
                default:
                    retVal.append(sum);
                    carryOver = 0;
                    break;
                case 2:
                    retVal.append(0);
                    carryOver = 1;
                    break;
                case 3:
                    retVal.append(1);
                    carryOver = 1;
                    break;
            }
            aIndex--;
            bIndex--;
        }

        if (aIndex >= 0 ) {
            while (aIndex >= 0) {
                sum = (a.charAt(aIndex) - 48) + carryOver;
                if (sum == 0) {
                    retVal.append(0);
                    carryOver = 0;
                } else if (sum == 1) {
                    retVal.append(1);
                    carryOver = 0;
                } else if (sum == 2) {
                    retVal.append(0);
                    carryOver = 1;
                }
                aIndex--;
            }
        } else if (bIndex >= 0) {
            while (bIndex >= 0) {
                sum = (b.charAt(bIndex) - 48) + carryOver;
                if (sum == 0) {
                    retVal.append(0);
                    carryOver = 0;
                } else if (sum == 1) {
                    retVal.append(1);
                    carryOver = 0;
                } else if (sum == 2) {
                    retVal.append(0);
                    carryOver = 1;
                }
                bIndex--;
            }
        }

        if(carryOver>0) retVal.append(1);
        return retVal.reverse().toString();
    }
}
