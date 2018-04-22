package leetcode;

/**
 * @author FDws
 * Created on 2018/4/22 11:08
 */

public class WildcardMatching {
    private boolean isMatch(String s, String p) {
        char[] sh = s.toCharArray();
        char[] ph = p.toCharArray();
        boolean[][] m = new boolean[ph.length + 1][sh.length + 1];
        m[0][0] = true;
        for (int i = 1; i < m.length; i++) {
            m[i][0] = ph[i - 1] == '*' && m[i - 1][0];
        }

        for (int i = 1; i < ph.length + 1; i++) {
            for (int j = 1; j < sh.length + 1; j++) {
                if (ph[i - 1] == sh[j - 1] || ph[i - 1] == '?') {
                    m[i][j] = m[i - 1][j - 1];
                } else if (ph[i - 1] == '*') {
                    m[i][j] = m[i - 1][j - 1] || m[i][j - 1] || m[i - 1][j];
                }
            }
        }

        return m[ph.length][sh.length];
    }

    private boolean isMatch2(String s, String p) {
        char[] sh = s.toCharArray();
        char[] ph = p.toCharArray();

        int si = 0;
        int pi = 0;
        int start = -1;
        int match = -1;

        while (si < s.length()) {
            if (pi < p.length() && (ph[pi] == '?' || ph[pi] == sh[si])) {
                si++;
                pi++;
            } else if (pi < p.length() && ph[pi] == '*') {
                start = pi;
                match = si;
                pi++;
            } else if (start != -1) {
                pi = start + 1;
                match++;
                si = match;
            } else {
                return false;
            }
        }
        while (pi < p.length() && ph[pi] == '*') {
            pi++;
        }
        return pi == ph.length;
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        String s;
        String p;
        s = "acdcb";
        p = "a*c?b";
        System.out.println(s + "  " + p + " " + wildcardMatching.isMatch(s, p)+ " " + wildcardMatching.isMatch2(s, p));
        s = "adceb";
        p = "*a*b";
        System.out.println(s + "  " + p + " " + wildcardMatching.isMatch(s, p)+ " " + wildcardMatching.isMatch2(s, p));
        s = "cb";
        p = "?a";
        System.out.println(s + "  " + p + " " + wildcardMatching.isMatch(s, p)+ " " + wildcardMatching.isMatch2(s, p));
        s = "aa";
        p = "*";
        System.out.println(s + "  " + p + " " + wildcardMatching.isMatch(s, p)+ " " + wildcardMatching.isMatch2(s, p));
        s = "aa";
        p = "a";
        System.out.println(s + "  " + p + " " + wildcardMatching.isMatch(s, p)+ " " + wildcardMatching.isMatch2(s, p));
    }
}
