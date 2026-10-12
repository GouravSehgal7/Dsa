package mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Fundamental {

    public static List<int[]> mergeoverlap(int interval[][]){
        // sort by start
        Arrays.sort(interval,(a,b)->Integer.compare(a[0], b[0]));
        int st1 = interval[0][0];
        int ed1 = interval[0][1];
        List<int[]> ls = new ArrayList<>();
        for(int i = 1;i<interval.length;i++){
            int st2 = interval[i][0];
            int ed2 = interval[i][1];
            if(st2<=ed1){
                ed1 = Math.max(ed1, ed2);
            }else{
                ls.add(new int[]{st1,ed1});
                st1 = st2;
                ed1 = ed2;
            }
        }
        ls.add(new int[]{st1,ed1});
        return ls;
    }

    public static List<int[]> inseartnewintervalinsortedinterval(int interval[][], int newintervals[][]){
        List<int[]> ls = new ArrayList<>();
        for(int n[] : interval){
            ls.add(n);
        }
        for(int n[] : newintervals){
            ls.add(n);
        }
        if (ls.isEmpty()) {
            return new  ArrayList<>();
        }
        ls.sort((a,b)->Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int st1 = ls.get(0)[0];
        int ed1 = ls.get(0)[1];
        for(int i = 1;i<ls.size();i++){
            int s2 = ls.get(i)[0];
            int e2 = ls.get(i)[1];
            if (s2<=ed1) {
                ed1 = Math.max(ed1, e2);
            }else{
                ans.add(new int[]{st1,ed1});
                st1 = s2;
                ed1 = e2;
            }
        }
        ans.add(new int[]{st1,ed1});
        return  ans;
    }

    public static List<int[]> findintersectionregion(int interval[][]){
        Arrays.sort(interval,(a,b)->Integer.compare(a[0], b[0]));
        int st1 = interval[0][0];
        int ed1 = interval[0][1];
        List<int[]> ls = new ArrayList<>();
        for(int i = 1;i<interval.length;i++){
            int s = interval[i][0];
            int e = interval[i][1];
            if(s<=ed1){
                int l = Math.max(s, st1);
                int h = Math.min(e, ed1);
                ls.add(new int[]{l,h});
                ed1 = Math.max(e, ed1);
            }else{
                st1 = s;
                ed1 = e;
            }
        }
        return ls;
    }

    public static int cntcoveredinterval(int interval[][]){
        // An interval $[a, b)$ is covered by $[c, d)$ if and only if $c \le a$ and $b \le d$.
        Arrays.sort(interval,(a,b)->{
            if(a[0]!=b[0]) return  Integer.compare(a[0], b[0]);
            else return  Integer.compare(b[1], a[1]);
        });
        int cnt = 0;
        int ed = 0;
        for(int n[] : interval){
            int e = n[1];
            if(e >=ed){
                cnt++;
                ed = e;
            }
        }
        return  cnt;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 1. Sort intervals by end time in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removedCount = 0;
        int prevEnd = intervals[0][1];

        // 2. Iterate through the rest of the intervals
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= prevEnd) {
                // Non-overlapping: keep this interval and update prevEnd
                prevEnd = end;
            } else {
                // Overlapping: increment removal count
                removedCount++;
            }
        }

        return removedCount;
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 1. Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Min-Heap to keep track of meeting end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Reuse room if the earliest ending meeting finishes before/at current start
            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }

            // Allocate room (push end time)
            minHeap.add(end);
        }

        // 3. Heap size equals minimum rooms needed
        return minHeap.size();
    }


    public static void main(String[] args) {
        
    }
    
}
