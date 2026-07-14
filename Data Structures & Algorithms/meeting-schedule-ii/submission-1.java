/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

//watched solution then implemented myself again
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        //we have now sorted start and end index
        //for each pair of s and i we need to check if s is smaller than e
        //if smaller, count++ and increment s
        //else count-- and increment e;
        int s=0;
        int e=0;
        int res = 0;
        int count = 0;

        //example - 
        //start - [1, 5, 15]
        //end - [10, 20, 40]
        while(s < start.length){
            if(start[s] < end[e]){
                count++;
                s++;
            }else{
                e++;
                count--;
            }

            res = Math.max(res, count);   
        }

        return res;
        
    }
}
