package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * @date 2017年12月11日 下午8:47:27
 * @title Generate Parentheses
 */
public class GenerateParentheses {

	int n = 0;
	List<String> result = new ArrayList<>();
	char[] arry = null;

	public List<String> generateParenthesis(int n) {
		this.n = n;
		arry = new char[n << 1];
		full(0, 0);
		return result;
	}

	public void full(int left, int right) {
		if (left + right == n << 1) {
			result.add(new String(arry));
//			System.out.println("N: " + result.get(result.size() - 1));
			return;
		}
		if (left < n) {
			arry[left + right] = '(';
			full(left + 1, right);
		}
		if (right < left) {
			arry[left + right] = ')';
			full(left, right + 1);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		System.out.println("Begin...");
		for (String s : g.generateParenthesis(3)) {
			System.out.println(s);
		}
		System.out.println("Done...");
	}
}
