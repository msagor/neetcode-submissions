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

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.size()==0 || intervals.size()==1){
            return true;
        }

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        Interval current = intervals.get(0);

        for(int i=1; i< intervals.size(); i++){

            Interval next = intervals.get(i);

            if( (next.start == current.end) ){
                //meeting ends at 8, another starts at 8
                current = next;
            }else if(next.start < current.end){
                //two meetings overlap;
                return false;
            }else if(next.start > current.end){
                //meeting ends at 8, another starts at 9
                current = next;
            }
        }

        return true;
    }
}
