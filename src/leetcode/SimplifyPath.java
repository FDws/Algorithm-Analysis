package leetcode;

/**
 * @author FDws
 * Created on 2018/5/10 10:24
 */
public class SimplifyPath {
    private String simplifyPath(String path) {
        String[] p = path.split("/+");
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals("..")) {
                p[i] = "";
                for (int j = i - 1; j >= 0; j--) {
                    if (!p[j].equals("")) {
                        p[j] = "";
                        break;
                    }
                }
            } else if (p[i].equals(".")) {
                p[i] = "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : p) {
            if (!s.equals("")) {
                sb.append("/");
                sb.append(s);
            }
        }
        String res = sb.toString();
        return res.length() == 0 ? "/" : res;
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/a/./b/../../c"));
        System.out.println(sp.simplifyPath("/home/"));
        System.out.println(sp.simplifyPath("/home//foo/."));
    }
}
