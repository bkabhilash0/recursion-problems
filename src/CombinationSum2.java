import java.util.ArrayList;

public class CombinationSum2 {
    private static void combinationSum2(int index, int[] candidates, int target, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            ds.add(candidates[i]);
            combinationSum2(i + 1, candidates, target - candidates[i], ds, res);
            ds.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1, 1, 1, 2, 2};
        int target = 4;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        combinationSum2(0, candidates, target, new ArrayList<>(), res);
        System.out.println(res);
    }
}
