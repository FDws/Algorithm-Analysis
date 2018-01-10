package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FDws
 * @date 2018年1月10日 下午9:57:24
 * @title Combination Sum
 */
public class CombinationSum {
	final Map<Integer, Integer> map = new HashMap<>();
	final List<List<Integer>> result = new ArrayList<>();
	int[] candidates = null;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		this.candidates = candidates;
		for (int i : candidates) {
			map.put(i, i);
		}

		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < candidates.length && candidates[i] < target; i++) {
			li.add(candidates[i]);
			search(li, target - candidates[i], i);
			li.remove(li.size() - 1);
		}
		if (map.containsKey(target)) {
			li.clear();
			li.add(target);
			result.add(li);
		}
		return result;
	}

	public void search(List<Integer> l, int tar, int begin) {
		if (map.containsKey(tar) && l.get(l.size() - 1) <= tar) {
			List<Integer> li = new ArrayList<>();
			li.addAll(l);
			li.add(tar);
			result.add(li);
		}
		for (int i = begin; i < candidates.length && candidates[i] < tar; i++) {
			l.add(candidates[i]);
			search(l, tar - candidates[i], i);
			l.remove(l.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] can = { 2, 3, 7 };
		CombinationSum c = new CombinationSum();
		c.combinationSum(can, 18).forEach(System.out::println);
	}
}
