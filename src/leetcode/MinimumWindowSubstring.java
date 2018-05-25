package leetcode;

/**
 * @author FDws
 * Created on 2018/5/25 21:46
 */

@SuppressWarnings("unused")
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() * t.length() == 0) {
            return "";
        }
        int[] tm = new int[128];
        int[] sm = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tm[t.charAt(i)]++;
        }
        int start = 0, begin = -1, end = 0;
        int found = 0, min = s.length();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            sm[curr]++;
            if (sm[curr] <= tm[curr]) {
                found++;
            }
            if (found == t.length()) {
                while (start < i && sm[s.charAt(start)] > tm[s.charAt(start)]) {
                    sm[s.charAt(start)]--;
                    start++;
                }
                if (i - start < min) {
                    min = i - start;
                    begin = start;
                    end = i;
                }
                sm[s.charAt(start)]--;
                found--;
                start++;
            }
        }
        return begin == -1 ? "" : s.substring(begin, end + 1);
    }

    private String minWindow2(String s, String t) {
        int[] map = new int[256];
        char[] sChars = s.toCharArray();

        int counter = t.length();
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int head = 0, tail = 0, front = 0, len = Integer.MAX_VALUE;
        while (tail < sChars.length) {
            if (map[sChars[tail++]]-- > 0) { // t中存在tail处的字符, 找到一个, counter--
                counter--;
            }
            while (counter == 0) { // 当counter为0时, 表明找到了所有的字符
                if (tail - head < len) { // len保存最短长度
                    len = tail - (front = head);
                }
                if (map[sChars[head++]]++ >= 0) {// t中head字符大于等于0, 说明上1次循环加了一个, 即有重复字符
                    counter++;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(front, front + len);
    }
}
