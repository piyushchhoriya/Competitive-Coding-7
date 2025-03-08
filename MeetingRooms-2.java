// In this problem, if the endtime of previous meeting is greater than the start time of next meeting, we will need a seperate room
// for both. So sorting the intervals by start time first, then iterating and comparing the start time with the peek element of 
// priority queue, as it is having end times sorted in ascending order(min heap). So, if start time is less than or equal, we can
// share the room so poll min element from pq and put the current end time. At last size of heap will give us the number of rooms
// required

// Time Complexity : O(nlogn) n is the number of intervals
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
import java.util.*;

class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        // Base case
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // Declare a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Loop for all intervals
        for (int[] i : intervals) {
            // Check if end time is less than or equal, we can use same room, so poll one
            // element
            if (!pq.isEmpty() && pq.peek() <= i[0]) {
                pq.poll();
            }
            // Add the end time of current interval
            pq.add(i[1]);
        }
        // Return pq.size
        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRooms2 m = new MeetingRooms2();
        int[][] intervals = new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(m.minMeetingRooms(intervals));
    }
}