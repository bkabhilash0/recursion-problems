import java.util.ArrayList;

public class SumOfSubsets {
    static void sumOfSubsets(int index, int[] arr, int sum, ArrayList<Integer> subset) {
        if (index == arr.length) {
            subset.add(sum);
            return;
        }

        sumOfSubsets(index + 1, arr, sum + arr[index], subset);
        sumOfSubsets(index + 1, arr, sum, subset);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        ArrayList<Integer> subsets = new ArrayList<>();
        sumOfSubsets(0, arr, 0, subsets);
        System.out.println(subsets);
    }
}
