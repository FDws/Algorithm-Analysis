package leetcode;

/**
 * @author FDws
 * @date 2017年11月22日 下午6:43:49
 * @title Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

	private int start = 0;
	private int length = 1;
	private char[] arry = null;
	private int arLen = 0;

	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		arLen = s.length();
		arry = s.toCharArray();

		for (int i = 0; i < arLen; i++) {
			int r = i + 1;
			while (r < arLen && arry[i] == arry[r]) {
				r++;
			}
			search(i, r - 1);
			i = r - 1;
		}
		return s.substring(start, start + length);
	}

	public void search(int left, int right) {
		int l = left - 1;
		int r = right + 1;

		for (; l >= 0 && r < arLen; l--, r++) {
			if (arry[l] != arry[r]) {
				break;
			}
		}

		if (r - l - 1 > length) {
			start = l + 1;
			length = r - start;
		}
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome("babad"));
	}
}
