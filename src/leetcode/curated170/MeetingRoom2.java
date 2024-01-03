package leetcode.curated170;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
         PriorityQueue<int[]> pq=new PriorityQueue<>(((a,b)->Integer.compare(a[1],b[1])));
        for(int [] interval:intervals){
            if(!pq.isEmpty()&&pq.peek()[1]<=interval[0]){
                pq.poll();
            }
            pq.add(interval);
        }
        return pq.size();
    }
}
