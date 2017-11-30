package leetcode;

/**
 * @author FDws
 * @date 2017年11月30日 下午8:08:26
 * @title Roman to Integer
 */
public class RomantoInteger {

	public int romanToInt(String s) {
		int result = 0;
		if (s.indexOf("IV") != -1) {
			result = result - 2;
		}
		if (s.indexOf("IX") != -1) {
			result = result - 2;
		}
		if (s.indexOf("XL") != -1) {
			result = result - 20;
		}
		if (s.indexOf("XC") != -1) {
			result = result - 20;
		}
		if (s.indexOf("CD") != -1) {
			result = result - 200;
		}
		if (s.indexOf("CM") != -1) {
			result = result - 200;
		}

		char[] number = s.toCharArray();
		int length = number.length;
		for (int i = 0; i < length; i++) {
			switch (number[i]) {
			case 'I':
				result += 1;
				break;
			case 'V':
				result += 5;
				break;
			case 'X':
				result += 10;
				break;
			case 'L':
				result += 50;
				break;
			case 'C':
				result += 100;
				break;
			case 'D':
				result += 500;
				break;
			case 'M':
				result += 1000;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RomantoInteger r = new RomantoInteger();
		IntegertoRoman i = new IntegertoRoman();
		System.out.println(r.romanToInt(i.intToRoman(874)));
	}
}
