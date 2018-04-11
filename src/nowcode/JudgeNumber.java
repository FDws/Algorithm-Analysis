package nowcode;

/**
 * @author FDws
 * Created on 2018/4/10 22:34
 */

public class JudgeNumber {
    public static void main(String[] args) {
        System.out.println(isNumeric("123.45e+6".toCharArray()));
    }

    private static boolean isNumeric(char[] str) {
        if (str.length == 0) return false;
        int begin = 0;
        if (str[0] == '-' || str[0] == '+') {
            begin = 1;
        } else if (str[0] < '0' || str[0] > '9') {
            return false;
        }
        boolean flag = false;
        while (begin < str.length) {
            if (str[begin] == '.') {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            } else if (str[begin] < '0' || str[begin] > '9') break;
            begin++;
        }
        if (begin == str.length) return true;
        if (str[begin] == 'e' || str[begin] == 'E' || str[begin] == '.') {
            return begin < str.length - 1 && isNum(str, begin + 1);
        }
        return false;
    }

    private static boolean isNum(char[] str, int begin) {
        if (str[begin] < '0' || str[begin] > '9') {
            if (str[begin] == '-' || str[begin] == '+') {
                begin++;
            } else {
                return false;
            }
        }
        if (begin == str.length) return false;
        for (int i = begin; i < str.length; i++) {
            if (str[i] < '0' || str[i] > '9') return false;
        }
        return true;
    }
}
