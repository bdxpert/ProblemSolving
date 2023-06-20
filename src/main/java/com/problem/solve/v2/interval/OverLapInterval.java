package com.problem.solve.v2.interval;

import java.util.ArrayList;
import java.util.List;

public class OverLapInterval {
    public static void main(String[] args)
    {

        int[][] inp5 = {{3,4},{3,2}};
        int[] target6 = {2,3};

        int[][] inp = {{1,2}, {3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        //Output: [[1,2],[3,10],[12,16]]


        int[][] inp7 = {{1,3},{6,9}};
        int[] intTarget = {2,5};

        int[][] inp8 = {{1,5}};
        int[] intTarget2 = {2,5};
        int[][] inp9 = {{1,5}};
        int[] intTarget3 = {6,8};//{2,7};

        int[][] inp10 = {{1,5}};
        int[] intTarget4 = {0,3};

        int[][] inp11 = {{1,5}};
        int[] intTarget5 = {0,1};

        int[][] inp12 = {{1,5}};
        int[] intTarget6 = {0,0};

        System.out.println(insertv2(inp12, intTarget6));

        /*
        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        Output: [[1,2],[3,10],[12,16]]
        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
        */

        /*
        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]
         */
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int insertPointFirstInterval = -1;
        int insertPointSecondInterval = -1;
        Boolean insertfirst = false;
        int insertPointLastInterval = 0;
        if(intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
        for(int i=0; i<intervals.length; i++) {
            if(insertPointFirstInterval ==-1 &&
                    intervals[i][0] <= newInterval[0] &&
                    intervals[i][1] >= newInterval[0]) {
                insertPointFirstInterval = i;
            }

            if(insertPointFirstInterval >=0 && insertPointSecondInterval==-1
                    && (intervals[i][0] > newInterval[1])) {
                //insert into first interval
                intervals[insertPointFirstInterval][1] = newInterval[1];
                insertPointSecondInterval = insertPointFirstInterval;
            }
            if(insertPointFirstInterval >=0 && insertPointSecondInterval==-1
                    && (intervals[i][1] < newInterval[1]) && intervals.length == 1) {
                //insert into first interval
                intervals[insertPointFirstInterval][1] = newInterval[1];
                insertPointSecondInterval = insertPointFirstInterval;
            }
            if(insertPointFirstInterval!=-1 && insertPointSecondInterval==-1 &&
                    intervals[i][0] >= newInterval[1] &&
                     newInterval[1] <= intervals[i][1]) {
                //merge interval
                //skip interval
                //i - insertPointFirstInterval;
                insertPointSecondInterval = i;
                //insert into first interval
                intervals[insertPointFirstInterval][1] = intervals[i][1];
            }

            // {1, 5} <- {0,3}
            if(insertPointFirstInterval==-1 &&
                    intervals[i][0] > newInterval[0] &&
                    intervals[i][1] >= newInterval[1] && intervals[i][0] < newInterval[1]) {
                //merge interval
                //skip interval
                //i - insertPointFirstInterval;
                insertPointSecondInterval = i;
                insertPointFirstInterval = i;
                //insert into first interval
                intervals[i][0] = newInterval[0];
            }
            if(insertPointFirstInterval==-1 &&
                    (intervals[i][0] > newInterval[0] &&
                            intervals[i][1] > newInterval[1]) && (newInterval[1] > intervals[i][0] || newInterval[1] < intervals[i][0])) {
                // && newInterval[1] > intervals[i][0]
                //merge interval
                //skip interval
                //i - insertPointFirstInterval;
                insertPointSecondInterval = i;
                insertPointFirstInterval = i;
                //insert into first interval
                insertfirst = true;
            }
            /*
            if(insertPointFirstInterval ==-1 &&
                    intervals[i][0] < newInterval[0] &&
                    intervals[i][1] < newInterval[0]) {
                insertPointLastInterval = 1;
            }*/
        }
        System.out.println("Total length::" + (intervals.length-(insertPointSecondInterval -insertPointFirstInterval)));
        int length =0;
        if(insertPointSecondInterval !=-1 && !insertfirst) {
            length = intervals.length-(insertPointSecondInterval -insertPointFirstInterval);
        } else if(insertPointSecondInterval == -1 && insertPointFirstInterval == -1) {
            length = intervals.length + 1;
        } else if (insertfirst) {
            length = intervals.length + 1;
        } else {
            length = intervals.length;
        }
        int[][] result = new int[length][2];
        int k=-1;
        if(insertfirst) {
            k++;
            result[k][0] = newInterval[0];
            result[k][1] = newInterval[1];
        }
        for(int i=0; i<intervals.length; i++) {
            if( (insertPointSecondInterval -insertPointFirstInterval) > 0 && i > insertPointFirstInterval &&
                    i <=insertPointSecondInterval){
                // skip
            } else {
                k++;
                result[k][0] = intervals[i][0];
                result[k][1] = intervals[i][1];
                System.out.println("{" + result[k][0] + ", " + result[k][1] + "}");
            }
        }
        if(insertPointSecondInterval == -1 && insertPointFirstInterval  == -1) {
            result[result.length-1][0] = newInterval[0];
            result[result.length-1][1] = newInterval[1];
        }
        System.out.println("Result length::"+result.length);
        System.out.println("insertPointFirstInterval:"+insertPointFirstInterval);
        return result;
    }
    public static int[][] insertv2(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int[] curInterval = intervals[i];
            if (intervals[i][1] < newInterval[0]) {
                // current interval starts first & not covered by newInterval, add intervals[i] to ans
                // [curInterval]
                //                      [newInterval]
                ans.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                // newInterval starts first and not covered by current interval
                // add newInterval to ans and set newInterval = curInterval
                //                       [curInterval]
                // [newInterval]
                ans.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1]) {
                // they are overlapped, merge them
                // [curInterval]
                //        [newInterval]
                // or
                // [newInterval]
                //        [curInterval]
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        // add the last interval
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
