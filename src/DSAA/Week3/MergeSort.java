package DSAA.Week3;

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
    public static void merge(int[] nums1, int m, int[] nums2 , int n){
        int p1 =m-1,p2=n-1;
        int pointer = n+m-1;
        int current=0;
        while (p1 >=0 || p2>=0  || pointer>=0){
            if(p1==-1){current = nums2[p2];}
            else if(p2 ==-1){current = nums1[p1];}
            else if(nums1[p1] > nums2[p2]){
                current = nums1[p1];
                p1--;
            } else if (nums1[p1] <= nums2[p2]) {
                current = nums2[p2];
                p2--;
            }
            nums1[pointer--] = current;
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
