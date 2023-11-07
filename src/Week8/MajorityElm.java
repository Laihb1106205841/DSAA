package Week8;

import static java.util.Arrays.sort;

public class MajorityElm {
    public int majorityElement(int[] nums) {
        sort(nums);
        return nums[nums.length/2-1];
    }


}
