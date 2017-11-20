package leetcode;

/**
 * @author FDws
 * @date 2017年11月20日 下午7:31:06
 * @title Longest Substring Without Repeating Characters
 */
public class LSWRC {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}

		int[] chars = new int[128];
		int result = 0;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			while (index < s.length() && chars[s.charAt(index)] == 0) {
				chars[s.charAt(index)] = 1;
				result = result >= (index - i + 1) ? result : index - i + 1;
				index++;
			}
			chars[s.charAt(i)] = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		LSWRC l = new LSWRC();
		System.out.println(l.lengthOfLongestSubstring("abacf"));
	}
}
