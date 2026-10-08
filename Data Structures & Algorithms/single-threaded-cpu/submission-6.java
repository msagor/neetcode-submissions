
//took help from chatgpt, 
//need to be able to redo again myself
class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // Result array stores the original index of each task
        int[] res = new int[n];
        int resIdx = 0;

        // First PQ:
        // Sort all tasks by enqueueTime
        // Each item = [enqueueTime, processingTime, originalIndex]
        PriorityQueue<int[]> enqueuePQ = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Populate the first PQ
        for (int i = 0; i < n; i++) {
            enqueuePQ.offer(new int[] {
                tasks[i][0],
                tasks[i][1],
                i
            });
        }

        // Second PQ:
        // Contains only tasks that are currently available
        // Sort by processingTime first, then original index
        PriorityQueue<int[]> availablePQ = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Integer.compare(a[1], b[1]);

                if (cmp != 0) {
                    return cmp;
                }

                return Integer.compare(a[2], b[2]);
            }
        );

        // Current CPU time
        long time = enqueuePQ.peek()[0];

        // third, Continue while there are unprocessed or available tasks
        while (!enqueuePQ.isEmpty()) {
            //check if peek is smaller than or equal to time
            while(!enqueuePQ.isEmpty() && enqueuePQ.peek()[0]<=time){
                //candidate to put in availablePQ
                int[] it = enqueuePQ.poll();
                availablePQ.offer(it);
            }

            //coming here means availablePQ could be populated
            if(!availablePQ.isEmpty()){
                //get the first value in availablePQ
                int[] it = availablePQ.poll();
                //add to the result
                res[resIdx++] = it[2];

                time = time + it[1];

                //put the other values in the availablePQ back to enqueuePQ
                while(!availablePQ.isEmpty()){
                    enqueuePQ.offer(availablePQ.poll());
                }
            }else{
                //need to increment time to the next item in enqueuePQ
                time  = enqueuePQ.peek()[0];
            }

        }

        return res;
    }
}