package leetcode;

/**
 * @author FDws
 * @date 2017年12月25日
 * @title Longest Valid Parentheses
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {

		int len = s.length();
		char[] arry = new char[len + 1];
		int[] conn = new int[len];
		arry[0] = '*';
		int result = 0;
		int conn_index = 0;
		int arry_index = 0;
		int loop = 0;

		while (loop < len) {
			if (s.charAt(loop) == '(') {
				arry[++arry_index] = '(';
			} else {
				if (arry[arry_index] == '(') {
					if (arry[arry_index - 1] == '^') {
						conn[conn_index] += 2;
						arry_index--;
					} else {
						conn[++conn_index] = 2;
						arry[arry_index] = '^';
					}
				} else if (arry[arry_index] == '^') {
					if (arry[arry_index - 1] == '(') {
						conn[conn_index] += 2;
						arry[--arry_index] = '^';
						if (arry[arry_index - 1] == '^') {
							conn[--conn_index] = conn[conn_index] + conn[conn_index + 1];
							arry_index--;
						}
					} else {
						arry[++arry_index] = ')';
					}
				} else {
				}
			}
			loop++;
		}
		for (int x : conn) {
			result = result > x ? result : x;
		}
		return result;
	}

	public void out(int[] i) {
		for (int x : i) {
			System.out.print(x + " --> ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LongestValidParentheses l = new LongestValidParentheses();
		System.out.println("Begin...");
		System.out.println(l.longestValidParentheses("(()(((()"));
		System.out.println(l.longestValidParentheses("(()(((()"));
		System.out.println(l.longestValidParentheses("()(()"));
		System.out.println(l.longestValidParentheses("((()())"));
		System.out.println(l.longestValidParentheses("()()"));
		System.out.println(l.longestValidParentheses("(((((("));
		System.out.println(l.longestValidParentheses(")()())()()("));
		System.out.println("Done...");
	}
}