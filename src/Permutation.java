import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    static void permutations(int[] arr, int[] map, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res) {
        if (ds.size() == arr.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int j : arr) {
            if (map[j] == 1) {
                continue;
            }
            ds.add(j);
            map[j] = 1;
            permutations(arr, map, ds, res);

            ds.removeLast();
            map[j] = 0;
        }
    }

    static void permutations(int[] arr, int index, ArrayList<ArrayList<Integer>> res) {
        if (index == arr.length) {
            ArrayList<Integer> ds = new ArrayList<>(arr.length);
            for(int i:arr){
                ds.add(i);
            }
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permutations(arr, index + 1,  res);
            swap(arr, index, i);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] map = new int[1001];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        permutations(arr, map, new ArrayList<>(), res);
        permutations(arr, 0, res);
        System.out.println(res);
        System.out.println(res.size());
    }
}
