
//watched solution then watched chatgpt solution then typed myself
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length==0){
            int[][] res = new int[1][2];
            res[0][0] = newInterval[0];
            res[0][1] = newInterval[1];
            return res;
        }
        
        List<int[]> res = new ArrayList<>();


        //first, add all items which are non-overlapping
        //we only stop at the item when overlap happens
        //ex: for [[1,3],[4,6]] and newInterval = [2,5]
            //we stop at i=0 [1,3]
        int i=0;
        while(i<intervals.length && newInterval[0] > intervals[i][1]){
            res.add(intervals[i]);
            i++;
        }

        //second, merge the overlap with newInterval
        //coming here means we found a overlap
        //note that, the overlap has two edge - start and end
        //ex: for [[1,3],[4,6]] and newInterval = [2,5]
            //we are merging [1,3] and [2,5]

        //merge left edge
        //ex: for [1,3] and [2,5] - compare between 1 vs 2, we pick 1 (left edge)
        if(i<intervals.length){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        }

        //merge right edge
        //we keep merging right edge until we cannot no longer
        //ex: for [1,3] and [2,5] - compare between 5 vs 1, we pick 5
            //for [2,5] and [4,6] - compare between 5 and 6, we pick 6
        while(i<intervals.length){
            if(newInterval[1] >= intervals[i][0]){
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }else{
                break;
            }
        }

        res.add(newInterval);

        //third, copy over the remaining values
        while (i < intervals.length) {

            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
