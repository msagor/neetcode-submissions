//my implementatiom but claude fixed it
//note - tentativeky take the course first before deleting the longest duration elem
import java.util.*;

class Solution {
    public int scheduleCourse(int[][] courses) {

        //minHeap by deadline (second value)
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        //maxHeap by duration (first value)
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));

        //first, populate minHeap by deadline
        for(int[] course: courses){
            minHeap.offer(course);
        }

        int currentTime = 0;

        while(!minHeap.isEmpty()){

            //get this course
            int[] course = minHeap.poll();

            //tentatively take this course
            currentTime += course[0];
            maxHeap.offer(course);

            //if we overshot the deadline, drop the longest course taken so far
            if(currentTime > course[1]){
                int[] evicted = maxHeap.poll();
                currentTime -= evicted[0];
            }
        }

        return maxHeap.size();
    }
}
