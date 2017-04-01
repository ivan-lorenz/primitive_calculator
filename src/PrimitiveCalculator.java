import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static List<Integer> DPoptimal_sequence(int n) {

        int[]  minOperations = new int[n+1];
        minOperations[0] = 0;
        int[] backtrackPointer = new int[n+1];
        backtrackPointer[0] = 0;
        for(int m = 1; m <= n; m++) {
            minOperations[m] = Integer.MAX_VALUE;

            if (isDivisibleByThree(m)) {
                int operations;
                if (m == 3)
                    operations = 1;
                else
                    operations = minOperations[m / 3] + 1;
                if (operations < minOperations[m]) {
                    minOperations[m] = operations;
                    backtrackPointer[m] = m / 3;
                }
            }

            if (isDivisibleByTwo(m)) {
                int operations;
                if (m == 2)
                    operations = 1;
                else
                    operations = minOperations[m / 2] + 1;
                if (operations < minOperations[m]) {
                    minOperations[m] = operations;
                    backtrackPointer[m] = m / 2;
                }
            }

            if (isGreaterOrEqualThanOne(m)) {
                int operations = minOperations[m - 1] + 1;
                if (operations < minOperations[m]) {
                    minOperations[m] = operations;
                    backtrackPointer[m] = m - 1;
                }
            }

        }

        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(n);
        int i = backtrackPointer[n];
        while (i > 0) {
            sequence.add(i);
            i = backtrackPointer[i];
        }

        Collections.reverse(sequence);
        return sequence;
    }

    private static boolean isDivisibleByThree(int m) {
        return m - (3 * (m/3)) == 0;
    }

    private static boolean isDivisibleByTwo(int m) {
        return m - (2 * (m/2)) == 0;
    }

    private static boolean isGreaterOrEqualThanOne(int m) {
        return m >= 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = DPoptimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

