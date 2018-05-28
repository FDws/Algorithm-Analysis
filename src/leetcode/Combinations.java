package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FDws
 * Created on 2018/5/28 21:34
 */

public class Combinations {
    List<List<Integer>> result = new ArrayList<>();

    private List<List<Integer>> combine(int n, int k) {
        Integer[] arr = new Integer[k];
        add(1, n, 0, arr);
        return result;
    }

    private void add(int b, int n, int deep, Integer[] arr) {
        if (deep == arr.length) {
            result.add(Arrays.asList(Arrays.copyOf(arr, arr.length)));
        } else {
            for (int i = b; i <= n - arr.length + 1 + deep; i++) {
                arr[deep] = i;
                add(i + 1, n, deep + 1, arr);
            }
        }
    }

    public static void main(String[] args) {
        Combinations com = new Combinations();
        System.out.println(com.combine(4, 2));
        System.out.println(com.combine(5, 3));
    }
}
