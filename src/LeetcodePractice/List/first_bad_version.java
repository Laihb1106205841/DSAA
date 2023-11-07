package LeetcodePractice.List;


/**
 * @author admin
 * leetcode 278
 */
public class first_bad_version {

    /** actually a binary search */
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left <= right){
            int mid = left + (right-left) >> 1;
            if (isBadVersion(mid)){
                right = mid-1;

            }
            else{
                left = mid+1;
            }
        }
        return left;

    }
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//    public class Solution extends VersionControl {
//        public int firstBadVersion(int n) {
//            int left = 1, right = n;
//
//            while (left <= right){
//                int mid = left + (right-left)/2;
//                if (!isBadVersion(mid)){
//                    left = mid+1;
//                }
//                else{
//                    right = mid-1;
//                }
//            }
//            {return left;}
//
//        }
//    }

    boolean isBadVersion(int version){return true;}
}
