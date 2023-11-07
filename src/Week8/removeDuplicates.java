package Week8;

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow =0;
        for(int fast=0; fast<nums.length; fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
    public int removeDuplicates3(int[] nums) {
        if(nums.length<=2){return nums.length;}
        int slow =0;
        for(int fast=2; fast<nums.length; fast++){
            if(nums[slow] != nums[fast]){
                nums[slow+2] = nums[fast];
                slow++;
            }
        }
        return slow+2;
    }
}
