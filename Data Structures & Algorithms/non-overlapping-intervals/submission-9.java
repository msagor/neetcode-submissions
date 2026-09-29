class Solution {
    //done entirely by myself
    //do merge intervals first
    //for two overlapping intervals we take the minimum for both start and end
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        if(intervals.length==0){
            int[][] res = new int[1][2];
            return 0;
        }

        Stack<int[]> stack = new Stack<>();

        stack.push(intervals[0]);

        int i=1;
        while(i<intervals.length && stack.size()>=1){
            int[] lastItem = stack.pop();
            int[] currItem = intervals[i];

            //check for merge
            if(lastItem[1] > currItem[0]){
                //overlapping
                //needs to delete currItem
                lastItem[0] = Math.min(lastItem[0], currItem[0]); 
                lastItem[1] = Math.min(lastItem[1], currItem[1]); //note - here we use min
                stack.push(lastItem);
                count++;
            }else{
                //non-overlapping
                //no merging needed
                stack.push(lastItem);
                stack.push(currItem);
            }
            i++;
        }

        return count;
    }
}
