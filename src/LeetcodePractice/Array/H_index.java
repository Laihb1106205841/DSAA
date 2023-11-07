package LeetcodePractice.Array;

import java.util.Arrays;

/**
 * @author admin
 */
public class H_index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i=citations.length; i>0; i--){
            if(citations[i-1] > h){
                h+=1;
            }
        }
        return h;
    }
    /**just a binary search */
    public int hIndexSorted(int[] citations) {
        int n = citations.length;
        int s=0,e=n-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(citations[mid] < n-mid){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return n-s;
    }
}
