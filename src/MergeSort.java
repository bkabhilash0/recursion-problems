import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int index = 0;

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= high) {
            temp[index++] = arr[right++];
        }

        System.out.println(Arrays.toString(temp));
        System.out.println(low + ", " + mid + ", " + high);

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int size = arr.length;

        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, size - 1);
        System.out.println(Arrays.toString(arr));
    }
}
