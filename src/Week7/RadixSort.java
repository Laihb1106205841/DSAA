package Week7;

import java.util.Scanner;

public class RadixSort {
//    public static String[] radixSort(String[] s1,int k){
//        for(int i=k;i>0;i--){
//            s1 = sortByIndex(s1,i);
//        }
//        return s1;
//    }
//
//    private static String[] sortByIndex(String[] s1,int num){
//        int[] arr = new int[s1.length];
//        for(int i=0;i<s1.length;i++){
//            arr[i] = s1[i].charAt(num-1);
//        }
//        s1 = AlphbetSort(s1,arr,num);
//        return s1;
//    }
//
//    public static String[] dictSort(String[] strArr){
//        List<String> list = Arrays.asList(strArr);
//        Collections.sort(list);
//        return list.toArray(new String[0]);
//    }
//
//    private static String[] AlphbetSort(String[]s1,int[] arr,int num1){
//        int k = arr[0];
//
//        for(int i=0;i<arr.length;i++){
//            k = Math.max(k,arr[i]);
//        }
//        // Create a count array to store the count
//        int[] count = new int[k + 1];
//        // Count the occurrences of each element
//        for (int num : arr) {
//            count[num]++;
//        }
//
//        // Calculate the prefix sum of the count array
//        for (int i = 1; i <= k; i++) {
//            count[i] += count[i - 1];
//        }
//
//        // Create a new array to store the sorted elements
//        int n = arr.length;
//        int[] sortedArr = new int[n];
//
//        // Build the sorted array
//        for (int i = n - 1; i >= 0; i--) {
//            sortedArr[count[arr[i]] - 1] = arr[i];
//            count[arr[i]]--;
//        }
//        for(int i=0;i<s1.length;i++){
//            int s = s1[i].charAt(num1-1);
//            //if(){}
//        }
//
//        return s1;
//    }
//public static int[] countingSort(int[] arr) {
//    int k = arr[0];
//    //int min = arr[0];
//    for (int j : arr) {
//        k = Math.max(k, j);
//        //  min = Math.min(min,arr[i]);
//    }
//    // Create a count array to store the count
//    int[] count = new int[k + 1];
//    // Count the occurrences of each element
//    for (int num : arr) {
//        count[num]++;
//    }
//
//    // Calculate the prefix sum of the count array
//    for (int i = 1; i <= k; i++) {
//        count[i] += count[i - 1];
//    }
//
//    // Create a new array to store the sorted elements
//    int n = arr.length;
//    int[] sortedArr = new int[n];
//
//    // Build the sorted array
//    for (int i = n - 1; i >= 0; i--) {
//        sortedArr[count[arr[i]] - 1] = arr[i];
//        count[arr[i]]--;
//    }
//
//    return sortedArr;
//}

    public static String[] dictSort(String[] array){
        int max =0;
        for (String s : array) {
            max = Math.max(s.length(), max);
        }
        for(int i=0;i<max;i++){
            array=dictSortInX(array, max - i);
        }
        return array;
    }

    private static String[] dictSortInX(String[] array, int x){
        char[] arr = new char[array.length];
        for(int i=0;i< array.length;i++){
            arr[i] = array[i].charAt(x-1);
        }

        int k = 0;
        //int min = arr[0];
        for (char c : arr) {
            k = Math.max(k, c);
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

        String[] sortedArr = new String[arr.length];
        // Build the sorted array
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[count[arr[i]] - 1] = array[i];
            count[arr[i]]--;
        }
//        for (int i = 0; i < array.length; i++) {
//            sortedArr[count[arr[i]] - 1] = array[i];
//            count[arr[i]]--;
//        }
        return sortedArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();//s.length
        //int k = scanner.nextInt();//each str length

        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.next();
        }//get the str in

        //array=radixSort(array,k);
        array=dictSort(array);
        //print
        for (int i=0;i<n;i++){
            System.out.println(array[i]);
        }
    }
}


