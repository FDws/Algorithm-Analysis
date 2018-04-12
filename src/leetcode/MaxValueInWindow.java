package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author FDws
 * Created on 2018/4/12 22:42
 */

public class MaxValueInWindow {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        if (size <= 0) return list;
        for (int i = 0; i < num.length; i++) {
            if (!queue.isEmpty()) {
                if (i - queue.peek() >= size) queue.pop();
                while (!queue.isEmpty() && num[queue.getLast()] <= num[i]) {
                    queue.removeLast();
                }
            }
            queue.offer(i);
            if (i + 1 >= size) list.add(num[queue.peek()]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] l = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        maxInWindows(l, 3).forEach(System.out::println);
    }
}
