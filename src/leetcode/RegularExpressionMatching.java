package leetcode;

/**
 * @author FDws
 * @date 2017年11月26日 下午9:13:15
 * @title Regular Expression Matching
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if (pLen == 2 && p.charAt(0) == '.' && p.charAt(1) == '*') {
			return true;
		}

		char[] sArry = s.toCharArray();
		char[] pArry = p.toCharArray();
		boolean[][] board = new boolean[sLen + 1][pLen + 1];
		board[0][0] = true;

		for (int i = 1; i <= pLen; i++) {
			if (pArry[i - 1] == '*') {
				board[0][i] = board[0][i - 2];
			}
		}

		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= pLen; j++) {
				if (sArry[i - 1] == pArry[j - 1] || pArry[j - 1] == '.') {
					board[i][j] = board[i - 1][j - 1];
				} else if (pArry[j - 1] == '*') {
					if (sArry[i - 1] != pArry[j - 2] && pArry[j - 2] != '.') {
						board[i][j] = board[i][j - 2];
					} else {
						board[i][j] = board[i][j - 2] || board[i][j - 1] || board[i - 1][j];
					}
				}
			}
		}
		return board[sLen][pLen];
	}

	public static void main(String[] args) {
		RegularExpressionMatching r = new RegularExpressionMatching();
		System.out.println(r.isMatch("aa", "a*"));
		System.out.println(r.isMatch("abcca", "abc*b*a"));
	}
}
