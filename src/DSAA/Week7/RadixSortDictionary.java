package DSAA.Week7;

import java.util.Arrays;

public class RadixSortDictionary {

    public static void radixSort(String[] arr, int d, int n) {
        // Perform counting sort for each character from right to left (least significant to most significant)
        for (int i = d - 1; i >= 0; i--) {
            countingSortByCharacter(arr, i, n);
        }
    }

    public static void countingSortByCharacter(String[] arr, int index, int n) {
        final int NUM_CHARS = 256; // Assuming ASCII characters

        String[] output = new String[n];
        int[] count = new int[NUM_CHARS];

        // Count occurrences of characters at the specified index
        for (String word : arr) {
            count[word.charAt(index)]++;
        }

        // Calculate cumulative count
        for (int i = 1; i < NUM_CHARS; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i].charAt(index)] - 1] = arr[i];
            count[arr[i].charAt(index)]--;
        }

        // Copy the sorted output array to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        String[] dictionary = {"apple", "banana", "orange", "grapse", "lemoan", "kiwaai", "peassr"};
        int wordLength = 6; // Assuming all words have 6 characters

        System.out.println("Original Dictionary:");
        System.out.println(Arrays.toString(dictionary));

        radixSort(dictionary, wordLength, dictionary.length);

        System.out.println("\nDictionary after Radix Sort:");
        System.out.println(Arrays.toString(dictionary));
    }
}
