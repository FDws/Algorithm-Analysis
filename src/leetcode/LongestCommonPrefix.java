package leetcode;

/**
 * @author FDws
 * @date 2017年12月1日 下午9:47:34
 * @title Longest Common Prefix
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		char[] result = strs[0].toCharArray();
		int len = result.length;

		for (int i = 1; i < strs.length; i++) {
			char[] now = strs[i].toCharArray();
			len = now.length > len ? len : now.length;
			int index = 0;
			for (index = 0; index < len; index++) {
				if (result[index] != now[index]) {
					len = index;
					break;
				}
			}
			if (len == 0) {
				break;
			}
		}
		return new String(result, 0, len);
	}

	public static void main(String[] args) {
		LongestCommonPrefix l = new LongestCommonPrefix();
		String[] s = { "aa", "aaa", "abc" };
		System.out.println("Begin...");
		System.out.println(l.longestCommonPrefix(s));
		System.out.println("Done");
	}
}
