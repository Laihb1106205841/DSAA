package DSAA.Week8;

public class RemoveElem {
    public int removeElement(int[] nums, int val) {
        int slow =0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
