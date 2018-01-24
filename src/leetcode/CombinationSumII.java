package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FDws
 * @date 2018/1/24  22:21
 */
public class CombinationSumII {
	final List<List<Integer>> result = new LinkedList<>();
	final List<Integer> part = new LinkedList<>();
	int[] candidates = null;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		this.candidates = candidates;
		add(0, target);
		return result;
	}

	private void add(int deepth, int target) {
		if (deepth >= candidates.length) {
			return;
		}
		for (int i = deepth; i < candidates.length; i++) {
			part.add(candidates[i]);
			if (candidates[i] == target) {
				result.add(new ArrayList<>(part));
			} else if (candidates[i] < target) {
				add(i + 1, target - candidates[i]);
			} else {
				part.remove(part.size() - 1);
				break;
			}
			part.remove(part.size() - 1);
			while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumII c = new CombinationSumII();
		int[] i = {10,1,2,7,6,1,5};
		for (List<Integer> l : c.combinationSum2(i, 8)) {
			l.forEach(System.out::print);
			System.out.println();
		}
	}
}
