import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        new AtomicInteger(0).incrementAndGet();
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return list;
        Collections.sort(intervals, new IntervalComparator());
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int i = 0;
        for (Interval interval: intervals) {
            starts[i] = interval.start;
            ends[i++] = interval.end;
        }
        int tempStart = starts[0], tempEnd = ends[0];
        for (i = 1; i < n; i++) {
            if (starts[i] > tempEnd) {
                list.add(new Interval(tempStart, tempEnd));
                tempEnd = ends[i];
                tempStart = starts[i];
            } else {
                tempEnd = Math.max(tempEnd, ends[i]);
            }
        }
        list.add(new Interval(tempStart, tempEnd));
        return list;
    }

    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public static void main(String [] args) {
        List<Interval> list = new ArrayList<Interval>() {
            {add(new Interval(1,4));
             add(new Interval(0, 4));}
        };
        new MergeIntervals().merge(list);
    }

    public List<Interval> merge1(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}


