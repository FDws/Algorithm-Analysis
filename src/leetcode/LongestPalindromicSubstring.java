package leetcode;

/**
 * @author FDws
 * @date 2017年11月22日 下午6:43:49
 * @title Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		String max = "";
		for (int i = 0; i < s.length(); i++) {
			int r = i + 1;
			while (r < s.length() && s.charAt(i) == s.charAt(r)) {
				r++;
			}

			String res = search(s, i, r - 1);

			if (res.length() > max.length()) {
				max = res;
			}
			i = r - 1;
		}

		return max;
	}

	public String search(String origin, int left, int right) {
		int l = left;
		int r = right;

		for (; l >= 0 && r < origin.length(); l--, r++) {
			if (origin.charAt(l) != origin.charAt(r)) {
				break;
			}
		}

		return origin.substring(l + 1, r);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.search("cbbd", 1, 2));
		System.out.println(l.longestPalindrome("babad"));
		System.out.println(l.longestPalindrome("cbbd"));
		System.out.println(l.longestPalindrome("a"));
	}
}
