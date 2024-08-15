import java.util.ArrayList;

public class Subsequence {
    static void printSequence(int index, ArrayList<Integer> arr, ArrayList<Integer> output) {
        if (index >= arr.size()) {
            System.out.println(output);
            return;
        }

        output.add(arr.get(index));
        printSequence(index + 1, arr, output);
        output.removeLast();
        printSequence(index + 1, arr, output);
    }

    static void printSubsequenceWithSumK(int index, ArrayList<Integer> arr, ArrayList<Integer> output, int k, int sum) {
        if (index >= arr.size()) {
            if (sum == k) {
                System.out.println(output);
            }
            return;
        }

        sum += arr.get(index);
        output.add(arr.get(index));
        printSubsequenceWithSumK(index + 1, arr, output, k, sum);

        sum -= output.getLast();
        output.removeLast();
        printSubsequenceWithSumK(index + 1, arr, output, k, sum);
    }

    static boolean printFirstSubsequenceWithSumK(int index, ArrayList<Integer> arr, ArrayList<Integer> output, int k, int sum) {
        if (index >= arr.size()) {
            if (sum == k) {
                System.out.println(output);
                return true;
            }
            return false;
        }
        sum += arr.get(index);
        output.add(arr.get(index));
        if (printFirstSubsequenceWithSumK(index + 1, arr, output, k, sum)) {
            return true;
        }

        sum -= output.getLast();
        output.removeLast();
        if (printFirstSubsequenceWithSumK(index + 1, arr, output, k, sum)) {
            return true;
        }

        return false;
    }

    static int countTotalSubsequence(int index, ArrayList<Integer> arr, int k, int sum) {
        if (index >= arr.size()) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        sum += arr.get(index);
//        output.add(arr.get(index));

        int prev = countTotalSubsequence(index + 1, arr, k, sum);

        sum -= arr.get(index);
//        output.removeLast();

        int next = countTotalSubsequence(index + 1, arr, k, sum);

        return prev + next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(2);

        ArrayList<Integer> output = new ArrayList<>();
        printSequence(0, input, output);
        System.out.println(output);

//        printSubsequenceWithSumK(0, input, output, 3, 0);

//        printFirstSubsequenceWithSumK(0, input, output, 3, 0);

        int total = countTotalSubsequence(0, input, 3, 0);
        System.out.println(total);
    }
}
