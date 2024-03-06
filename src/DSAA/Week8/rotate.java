package DSAA.Week8;

public class rotate {
    public void rotate(int[] nums, int k) {
        if(nums.length==1){return;}
        int[] out = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            out[(k+i)%nums.length] = nums[i];
        }
        System.arraycopy(out, 0, nums, 0, nums.length);
     }
}
