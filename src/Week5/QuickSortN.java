package Week5;

import java.util.Scanner;

public class QuickSortN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }//get the number in
        quickSort(array,0,array.length-1);
        for (int i=0;i<N;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = RandPartition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int RandPartition(int[] arr, int left, int right) {
        // ser pivot left+(int)(Math.random()*(right-left+1))
        int pivotf = (int)(Math.random()*(right-left)) + left; //pivot
        swap(arr, left, pivotf); //back to partition
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}