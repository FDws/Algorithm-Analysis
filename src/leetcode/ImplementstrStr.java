package leetcode;

/**
 * @author FDws
 * @date 2017年12月19日 下午10:15:55
 * @title Implement strStr
 */
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		int sl = haystack.length();
		int nl = needle.length();
		char[] source = haystack.toCharArray();
		char[] need = needle.toCharArray();

		if (nl == 0) {
			return 0;
		}
		for (int i = 0; i < sl - nl + 1; i++) {
			int j = 0;
			int k = i;
			while (j < nl && need[j] == source[k]) {
				k++;
				j++;
			}
			if (j == nl) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		ImplementstrStr i = new ImplementstrStr();
		System.out.println(i.strStr("anccccfd", "cccff"));
	}
}
