package DSAA.Week5;

import java.util.Scanner;

/**
 * @author admin
 */
public class RandomizeQuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }//get the number in
        quickSort(array,0,array.length-1);
        for (int i=0;i<n;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = randPartition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int randPartition(int[] arr, int left, int right) {
        // ser pivot left+(int)(Math.random()*(right-left+1))
        //pivot
        int pivotF = (int)(Math.random()*(right-left)) + left;
        int num =0;

        for (int i=0; i<arr.length; i++){
            if(arr[i] == pivotF){
                swap(arr,arr[num],arr[i]);
                num+=1;
            }
        }

        int pivot = num;
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
