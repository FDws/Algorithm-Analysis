package leetcode;

/**
 * @author FDws
 * Created on 2018/5/24 21:10
 */

public class SortColors {
    private void sortColors(int[] nums) {
        int loc0 = -1;
        int loc1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[++loc0] = 0;

                if (loc1 != -1) {
                    nums[++loc1] = 1;
                }
                if (i != loc0 && i != loc1) {
                    nums[i] = 2;
                }
            } else if (nums[i] == 1) {
                if(loc1==-1){
                    loc1 = loc0;
                }
                nums[++loc1] = 1;
                if(i!=loc1) {
                    nums[i] = 2;
                }
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] ar = {2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(ar);
    }
}
