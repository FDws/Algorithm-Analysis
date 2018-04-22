package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author FDws
 * Created on 2018/4/22 15:34
 */

public class Permutations {
    private List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        perm(result, nums, 0);
        return result;
    }

    private void perm(List<List<Integer>> result, int[] nums, int begin) {
        if (begin == nums.length) {
            List<Integer> l = new LinkedList<>();
            for (int i : nums) {
                l.add(i);
            }
            result.add(l);
            return;
        }
        int t;

        for (int i = begin; i < nums.length; i++) {
            if (hasEqual(nums, begin, i)) {
                continue;
            }
            t = nums[begin];
            nums[begin] = nums[i];
            nums[i] = t;
            perm(result, nums, begin + 1);
            t = nums[begin];
            nums[begin] = nums[i];
            nums[i] = t;
        }
    }

    private boolean hasEqual(int[] nums, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == nums[end]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] i = {0,0,0,1,9};
        List<List<Integer>> r = p.permute(i);
        int s = 0;
        for (List<Integer> l : r) {
            System.out.println(l);
            System.out.println(s++);
        }
    }
}
