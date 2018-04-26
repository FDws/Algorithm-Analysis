package leetcode;

import java.util.*;

/**
 * @author FDws
 * Created on 2018/4/26 21:07
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i + 1);
            if (i2.start <= i1.end) {
                i1.end = Math.max(i1.end, i2.end);
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        int size = intervals.size();
        int[] start = new int[size];
        int[] end = new int[size];
        int index = 0;
        for (Interval i : intervals) {
            start[index] = i.start;
            end[index++] = i.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        List<Interval> result = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (i == size - 1 || end[i] < start[i + 1]) {
                result.add(new Interval(start[i], end[i]));
            } else {
                start[i + 1] = start[i];
            }
        }
        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        int i = 0;
        while (i < intervals.size() && intervals.get(i).start < newInterval.start) {
            result.add(intervals.get(i++));
        }

        if (result.size() > 0 && result.get(result.size() - 1).end >= newInterval.start) {
            result.get(result.size() - 1).end = Math.max(newInterval.end, result.get(result.size() - 1).end);
        } else {
            result.add(newInterval);
        }
        while (i < intervals.size() && intervals.get(i).end <= result.get(result.size() - 1).end) i++;

        if (i < intervals.size()) {
            if (intervals.get(i).start <= result.get(result.size() - 1).end) {
                result.get(result.size() - 1).end = intervals.get(i).end;
                i++;
            }
            while (i < intervals.size()) {
                result.add(intervals.get(i++));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] i = {{1, 3}, {6, 9}};
        List<Interval> list = new LinkedList<>();
        for (int[] s : i) {
            list.add(new Interval(s[0], s[1]));
        }
        MergeIntervals mi = new MergeIntervals();
        for (Interval in : mi.insert(list, new Interval(2, 5))) {
            System.out.println(in.start + " " + in.end);
        }
    }
}

@SuppressWarnings({"WeakerAccess", "unused"})
class Interval {
    int start;
    int end;

    Interval() {

    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
