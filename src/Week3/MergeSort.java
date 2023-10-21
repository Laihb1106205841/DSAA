package Week3;

import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] A){
        if(A.length==1){return;}

        int mid = A.length/2;
        int[] left = new int[mid];
        int[] right= new int[A.length-mid];

        System.arraycopy(A, 0, left, 0, left.length);
        System.arraycopy(A, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        merge(A,left,right);

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
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }//get the number in
        mergeSort(array);
        for (int i=0;i<N;i++){
            System.out.print(array[i]+" ");
        }
    }
}
