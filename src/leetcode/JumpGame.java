package leetcode;

/**
 * @author FDws
 * Created on 2018/4/25 22:23
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && max <= i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        int left = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= left) {
                left = i;
            }
        }
        return left == 0;
    }
}
