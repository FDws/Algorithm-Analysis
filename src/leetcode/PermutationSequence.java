package leetcode;

/**
 * @author FDws
 * Created on 2018/4/29 20:24
 */
public class PermutationSequence {
    private String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] ar = new int[n];

        int allPerm = 1;
        for (int i = 1; i <= n; i++) {
            allPerm *= i;
        }
        k--;

        for (int i = 0; i < n; i++) {
            int groupSize = allPerm / (n - i);
            int groupIndex = k / groupSize;
            int kn = 0;
            for (int j = 0; j < n; j++) {
                if (groupIndex == kn && ar[j] == 0) {
                    sb.append(j + 1);
                    ar[j] = 1;
                    break;
                }
                if (ar[j] == 0) kn++;
            }
            allPerm = allPerm / (n - i);
            k = k - (groupIndex * groupSize);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(4, 9));
        System.out.println(ps.getPermutation(3, 2));
    }
}
