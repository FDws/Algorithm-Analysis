package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FDws
 * Created on 2018/5/6 14:33
 */
public class TextJustification {
    private List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        int sum = 0;
        int len;
        for (int i = 0; i < words.length; i++) {
            if (sum + words[i].length() > maxWidth) {
                sum = sum - (i - begin);
                if (i - begin == 1) {
                    sb.append(words[begin]);
                    len = maxWidth - words[begin].length();
                    if (len > 0) sb.append(space(len));
                    result.add(sb.toString());
                } else {
                    int spi = (maxWidth - sum) / (i - begin - 1);
                    int first = (maxWidth - sum) % (i - begin - 1);
                    for (int j = begin; j < i; j++) {
                        sb.append(words[j]);
                        if (j == i - 1) break;
                        if (first > 0) {
                            sb.append(space(1));
                            first--;
                        }
                        if (spi > 0) sb.append(space(spi));
                    }
                    result.add(sb.toString());
                }
                sb.delete(0, sb.length());
                begin = i;
                sum = words[i].length() + 1;
            } else {
                sum += words[i].length();
                sum++;
            }
        }
        sum = 0;
        for (int i = begin; i < words.length; i++) {
            sum += words[i].length();
            sum++;
            sb.append(words[i]);
            if (sum == maxWidth + 1) break;
            sb.append(' ');
        }
        len = maxWidth - sum;
        if (len > 0) sb.append(space(maxWidth - sum));
        result.add(sb.toString());
        return result;
    }

    private static char[] space(int num) {
        char[] c = new char[num];
        for (int i = 0; i < num; i++) {
            c[i] = ' ';
        }
        return c;
    }

    public static void main(String[] args) {
        String[] s = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        TextJustification textJustification = new TextJustification();
        textJustification.fullJustify(s, 20).forEach(System.out::println);
        textJustification.fullJustify(s, 16).forEach(System.out::println);
    }
}
