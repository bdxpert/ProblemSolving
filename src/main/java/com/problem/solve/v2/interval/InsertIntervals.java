package com.problem.solve.v2.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertIntervals {
    static class Interval{
        int start, end;
        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    static List<Interval> getInterval(int[][] intervals){
        return Arrays.stream(intervals).map(inter1->new Interval(inter1[0], inter1[1])).collect(Collectors.toList());
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Interval newInterval1 = new Interval(newInterval[0], newInterval[1]);
        List<Interval> intervals1 = getInterval(intervals);
        List<Interval> res = new ArrayList<>();
        for(Interval oldInterval : intervals1) {

            if(oldInterval.end < newInterval1.start) {
                res.add(oldInterval);
            } else if(oldInterval.start>newInterval1.end){
                res.add(newInterval1);
                newInterval1 = oldInterval;
            } else if(oldInterval.end >= newInterval1.start || oldInterval.start <= newInterval1.end) {
                newInterval1 = new Interval(Math.min(oldInterval.start,newInterval1.start),
                        Math.max(newInterval1.end, oldInterval.end));
            }
        }
        res.add(newInterval1);

        int[][] res2 = new int[res.size()][2];
        for (int i=0;i<res.size();i++) {
            res2[i][0] = res.get(i).start;
            res2[i][1] = res.get(i).end;
        }
        return res2;
    }
}
