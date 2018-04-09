package nowcode;

import java.util.Scanner;

/**
 * @author FDws
 * Created on 2018/4/9 11:13
 */

public class ReverseNumberPair {
    private int result = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] sg = s.nextLine().split(",");
        int[] array = new int[sg.length];
        for (int i = 0; i < sg.length; i++) {
            array[i] = Integer.parseInt(sg[i]);
        }
        ReverseNumberPair rnp = new ReverseNumberPair();
        rnp.sort(array, 0, array.length);
        for (int anArray : array) {
            System.out.print(anArray + ",");
        }
        System.out.println();
        System.out.println(rnp.result);
    }

    public void sort(int[] ar, int begin, int end) {
        if (begin >= end - 1) {
            return;
        }

        int mid = (end + begin) >> 1;
        sort(ar, begin, mid);
        sort(ar, mid, end);
        int i = begin;
        int j = mid;
        int[] ta = new int[end - begin];
        int k = 0;
        for (; i < mid && j < end; k++) {
            if (ar[i] > ar[j]) {
                ta[k] = ar[j];
                j++;
                result += mid - i;
                if(result>1000000007){
                    result = result % 1000000007;
                }
            } else {
                ta[k] = ar[i];
                i++;
            }
        }
        while (i < mid) {
            ta[k++] = ar[i++];
        }
        while (j < end) {
            ta[k++] = ar[j++];
        }
        i = begin;
        for (k = 0; i < end; ) {
            ar[i++] = ta[k++];
        }
    }
}
