package leetcode;


import java.math.BigInteger;

/**
 * @author FDws
 * @date 2018/2/17  22:12
 * @title Multiply Strings
 */

public class MultiplyStrings {
	private String multiply(String inta, String intb) {
		int[] a;
		int[] b;
		int[] r;
		if (inta.length() * intb.length() == 0 || inta.charAt(0) == '0' || intb.charAt(0) == '0') {
			return "0";
		}
		if (inta.length() > intb.length()) {
			a = new int[inta.length()];
			b = new int[intb.length()];
			toIntArray(inta, intb, a, b);
		} else {
			a = new int[intb.length()];
			b = new int[inta.length()];
			toIntArray(intb, inta, a, b);
		}

		r = new int[a.length + b.length];

		for (int i = a.length - 1; i >= 0; i--) {
			int k = b.length + i;
			for (int j = b.length - 1; j >= 0; j--) {
				int sum = a[i] * b[j] + r[k];
				r[k] = sum % 10;
				r[k - 1] += sum / 10;
				k--;
			}
		}
		int i = 0;
		for (; i < r.length; i++) {
			if (r[i] != 0) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder("");
		for(;i<r.length;i++) {
			sb.append(r[i]);
		}
		return sb.toString();
	}

	private void toIntArray(String a, String b, int[] ar, int[] br) {
		int i = 0;
		for (; i < b.length(); i++) {
			ar[i] = a.charAt(i) - '0';
			br[i] = b.charAt(i) - '0';
		}
		for (; i < a.length(); i++) {
			ar[i] = a.charAt(i) - '0';
		}
	}

	public static void main(String[] args) {
		MultiplyStrings m = new MultiplyStrings();
		String ia = "986";
		String ib = "12333298";
		System.out.println(m.multiply(ia, ib));
		BigInteger a = new BigInteger(ia);
		BigInteger b = new BigInteger(ib);
		System.out.println(a.multiply(b));

	}
}
