package leetcode;

/**
 * @author FDws
 * Created on 2018/5/18 21:27
 */

public class EditDistance {
    private int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 * l2 == 0) {
            return l1 + l2;
        }
        int[] distance = new int[l1 + 1];
        for (int i = 0; i < l1 + 1; i++) {
            distance[i] = i;
        }
        for (int j = 1; j <= l2; j++) {
            int pre = distance[0];
            distance[0] = j;
            for (int i = 1; i <= l1; i++) {
                int tmp = distance[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i] = pre;
                } else {
                    distance[i] = Math.min(pre,
                            Math.min(distance[i], distance[i - 1])) + 1;
                }
                pre = tmp;
            }
        }

        return distance[l1];
    }

    public static void main(String[] args) {
        EditDistance distance = new EditDistance();
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(distance.minDistance(s1, s2));
    }
}
