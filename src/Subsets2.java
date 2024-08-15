import java.util.ArrayList;

public class Subsets2 {

    private static void subsets(int index, int[] num, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> res) {
        res.add(new ArrayList<>(sub));
        for (int i = index; i < num.length; i++) {
            if (i != index && num[i] == num[i - 1]) {
                continue;
            }

            sub.add(num[i]);
            subsets(i + 1, num, sub, res);
            sub.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3};
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsets(0, arr, new ArrayList<>(), subsets);
        System.out.println(subsets);
    }
}
