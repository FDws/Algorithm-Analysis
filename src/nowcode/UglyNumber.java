package nowcode;

import java.util.*;

/**
 * @author FDws
 * Created on 2018/4/7 21:25
 */

public class UglyNumber {
    private int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;
        List<Integer> list = new LinkedList<>();
        list.add(1);
        int num = 1;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        int next = 1;
        while (num < index) {
            next = Math.min(list.get(m2) * 2, Math.min(list.get(m3) * 3, list.get(m5) * 5));
            if (next == list.get(m2) * 2) m2++;
            if (next == list.get(m3) * 3) m3++;
            if (next == list.get(m5) * 5) m5++;
            list.add(next);
            num++;
        }
        System.out.println(list);
        return next;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.GetUglyNumber_Solution(7));
        System.out.println(uglyNumber.GetUglyNumber_Solution(8));
    }
}
