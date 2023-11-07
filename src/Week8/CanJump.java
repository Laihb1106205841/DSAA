package Week8;

public class CanJump {
    public boolean canJump(int[] nums) {
        int firstNum = nums[0];
        if(nums.length == 1 || nums.length <= firstNum+1){return true;}

        int count = 1;
        for(int i=nums.length-2; i>=0;i--){
            if(nums[i] >= count){
                count = 1;
            }else{
                count++;
            }
        }
        return count == 1;

    }
}
