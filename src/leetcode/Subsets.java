package leetcode;

import java.util.*;

/**
 * @author FDws
 * Created on 2018/5/30 21:41
 */

public class Subsets {
    private int[] nums = {};
    private List<List<Integer>> result = new ArrayList<>();

    private List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        make(0, new ArrayList<>());
        return result;
    }

    private void make(int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(list);
            return;
        }
        make(index + 1, list);
        List<Integer> li = new ArrayList<>(list);
        li.add(nums[index]);
        make(index + 1, li);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] ar = {1, 2, 3};
        System.out.println(subsets.subsets(ar));
    }
}
