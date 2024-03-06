package DSAA.Week7;

import java.util.Scanner;

/**
 * @author admin
 */
public class CountingSort {

    public static int[] countingSort(int[] arr) {
        int k = arr[0];
        //int min = arr[0];
        for(int i=0;i<arr.length;i++){
            k = Math.max(k,arr[i]);
            //  min = Math.min(min,arr[i]);
        }
        // Create a count array to store the count
        int[] count = new int[k + 1];
        // Count the occurrences of each element
        for (int num : arr) {
            count[num]++;
        }

        // Calculate the prefix sum of the count array
        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }

        // Create a new array to store the sorted elements
        int n = arr.length;
        int[] sortedArr = new int[n];

        // Build the sorted array
//        for (int i = n - 1; i >= 0; i--) {
//            sortedArr[count[arr[i]] - 1] = arr[i];
//            count[arr[i]]--;
//        }
        for (int i = 0; i < arr.length; i++) {
            sortedArr[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }//get the number in
        array=countingSort(array);
        for (int i=0;i<n;i++){
            System.out.print(array[i]+" ");
        }
    }
}
