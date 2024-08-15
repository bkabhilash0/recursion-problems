import java.util.Arrays;

public class QuickSort {
    static int partition(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int i = lo;
        int j = hi;

        while (i < j) {
            while (i <= hi && a[i] <= pivot) {
                i++;
            }

            while (j > lo && a[j] > pivot ) {
                j--;
            }

            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                System.out.println(Arrays.toString(a));
            }
        }

        int tmp = a[j];
        a[j] = a[lo];
        a[lo] = tmp;

        return j;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,32,1,5,2};
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));


    }
}
