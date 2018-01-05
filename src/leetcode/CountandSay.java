package leetcode;

/**
 * @author FDws
 * @date 2018年1月5日 下午4:47:12
 * @title Count and Say
 */
public class CountandSay {
	public String countAndSay(int n) {
		String begin = "1";

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < n; i++) {
			int num = 0;
			char c = begin.charAt(0);
			for (int x = 0; x < begin.length(); x++) {
				if (begin.charAt(x) != c) {
					sb.append(num);
					sb.append(c);
					num = 0;
					c = begin.charAt(x);
				}
				num++;
			}
			sb.append(num);
			sb.append(c);
			begin = sb.toString();
			sb = new StringBuilder();
		}

		return begin;
	}

	public static void main(String[] args) {
		CountandSay c = new CountandSay();
		System.out.println(c.countAndSay(14));
	}
}
