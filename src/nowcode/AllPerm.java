package nowcode;

/**
 * @author FDws
 * Created on 2018/4/6 15:48
 */

public class AllPerm {
    public static void main(String[] args) {
        String str = "abc";
        perm(str.toCharArray(), 0, str.length());
    }

    private static void perm(char[] str, int from, int to) {
        if (from == to - 1) {
            System.out.println(str);
            return;
        }
        for (int i = from; i < to; i++) {
            swap(str, from, i);
            perm(str, from + 1, to);
            swap(str, from, i);
        }
    }

    private static void swap(char[] ch, int a, int b) {
        char t = ch[a];
        ch[a] = ch[b];
        ch[b] = t;
    }
}
