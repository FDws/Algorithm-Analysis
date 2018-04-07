package nowcode;

import java.util.Arrays;

/**
 * @author FDws
 * Created on 2018/4/7 17:11
 */

public class ArrayToMinNumber {
    public String PrintMinNumber(int[] numbers) {
        String[] sn = new String[numbers.length];
        for (int i = 0; i < sn.length; i++) {
            sn[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(sn, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (String i : sn) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayToMinNumber atmn = new ArrayToMinNumber();
        int[] ar = new int[]{3, 32, 321};
        System.out.println(atmn.PrintMinNumber(ar));
    }
}
