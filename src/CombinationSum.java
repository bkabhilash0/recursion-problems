import java.util.ArrayList;

public class CombinationSum {
    private static void findCombinations(int index, int target, int[] input, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> result) {
        if (index == input.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if (input[index] <= target) {
            ds.add(input[index]);
            findCombinations(index, target - input[index], input, ds, result);
            ds.removeLast();
        }
        findCombinations(index + 1, target, input, ds, result);
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,3,6,7};
        int target = 7;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findCombinations(0, target, input, new ArrayList<>(), result);

        System.out.println(result);
    }
}
