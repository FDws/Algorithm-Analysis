package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author FDws
 * @date 2017年12月22日 下午7:59:36
 * @title Substring with Concatenation of All Words
 */
public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		final Map<String, Integer> map = new HashMap<>();
		final List<Integer> result = new LinkedList<>();

		for (String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}

		final int arLen = words.length;
		final int wL = words[0].length();
		final int length = s.length();
		int i = 0;
		for (; i < length - arLen * wL + 1; i++) {
			final Map<String, Integer> m = new HashMap<>();
			int j = 0;
			while (j < arLen) {
				String word = s.substring(i + j * wL, i + (j + 1) * wL);
				if (map.containsKey(word)) {
					m.put(word, m.getOrDefault(word, 0) + 1);
					if (m.get(word) > map.get(word)) {
						break;
					}
				} else {
					break;
				}
				j++;
			}
			if (j == arLen) {
				result.add(i);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords s = new SubstringwithConcatenationofAllWords();
		System.out.println("Begin...");
		String ss = "barfoothefoobarman";
		String[] words = new String[] { "foo", "bar" };
		s.findSubstring(ss, words).forEach(System.out::println);
		System.out.println("Done...");
	}
}
