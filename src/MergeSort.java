import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return; // 如果数组长度为1或更小，则无需排序
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // 将数组分成左右两个子数组
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        // 递归对左右两个子数组进行排序
        mergeSort(left);
        mergeSort(right);

        // 合并已排序的左右子数组
        merge(arr, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("原始数组: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}
