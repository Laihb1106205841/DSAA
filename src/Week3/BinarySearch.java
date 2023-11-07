package Week3;

import java.util.Scanner;

public class BinarySearch {
    public static boolean binarySearch(int[] array,int test,int low,int high){
        if (array.length==1) {
            return (array[0]==test);
        }

        if ((high-low)==1&&array[high]!=test&&array[low]!=test){
            return false;
        }

        int halfL =(low+high)>>1;

        if (array[halfL] == test){
            return true;
        }
        else if (array[halfL] > test){
            return binarySearch(array,test,low,halfL);
        }
        else {
            return binarySearch(array,test,halfL,high);
        }
    }
    public static int binarySearching(int[] arr, int num){
        int left =0;
        int right=arr.length-1;

        // why <= : since our district is [0,arr.length-1], 全闭区间
        // 左闭右开:if [0,arr.length],that is [0,arr.length)
        while (left<=right){
            //in this writing, we can avoid the left+right out of int's bound;
            int half = left + (right-left)/2;
            if(arr[half] == num){
                return half;
            }
            else if (arr[half] < num) {
                left = half+1;
                //since half has been searching, our district is [half+1,right]
            }
            else if (arr[half] > num) {
                right = half-1;
                //the half has been searching, the district is [left,half-1]
            }
        }
        return -1;
    }
    int leftBound(int[] nums, int target) {// 我们从左侧进行搜索，观察上下两种方法的区别
        int left = 0;
        int right = nums.length; // 注意，左闭右开 [left,right)

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // if (left - 1 < 0 || left - 1 >= nums.length) {
        //     return -1;
        // }

        // 由于 while 的结束条件是 right == left - 1，且现在在求右边界
        // 所以用 right 替代 left - 1 更好记
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i =0;i<T;i++){
            int N = scanner.nextInt();
            int[] array = new int[N];
            int find = scanner.nextInt();

            for (int j = 0; j < N; j++) {
                array[j] = scanner.nextInt();
            }//get the number in

            boolean M = binarySearch(array,find,0,array.length-1);
            int p = binarySearching(array,5);
            if(M){System.out.println("YES");}
            else {System.out.println("NO");}

        }
    }
}
