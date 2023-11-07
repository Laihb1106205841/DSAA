package LeetcodePractice.Array;

public class MergeAndBinarySearch {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length+nums2.length];
        merge(merge,nums1,nums2);
        if(merge.length%2==0){
            double a1 = merge[merge.length/2];
            double a2 = merge[merge.length/2-1];
            return (a2+a1)/2;
        }
        else {
            double am = merge[merge.length/2];
            return am;
        }
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

}
