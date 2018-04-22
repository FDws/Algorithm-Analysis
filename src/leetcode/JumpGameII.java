package leetcode;

/**
 * @author FDws
 * Created on 2018/4/22 14:53
 */

public class JumpGameII {
    private int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums[0] >= nums.length) return 1;

        int begin = 0;
        int end = 1;
        int result = 0;
        int limit = 0;

        while (limit < nums.length - 1) {
            for (int i = end - 1; i >= begin; i--) {
                limit = limit < nums[i] + i ? nums[i] + i : limit;
            }
            result++;
            begin = end;
            end = limit + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] i = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jumpGameII.jump(i));
    }
}
