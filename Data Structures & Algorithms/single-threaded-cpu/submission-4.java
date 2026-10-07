
//chatgpt solution, need to be able to redo again myself
//see below for my impl
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
        long time = 0;

        // Continue while there are unprocessed or available tasks
        while (!enqueuePQ.isEmpty() || !availablePQ.isEmpty()) {

            // If no task is currently available,
            // jump time to the next task's enqueueTime
            if (availablePQ.isEmpty() && !enqueuePQ.isEmpty()) {
                time = Math.max(time, enqueuePQ.peek()[0]);
            }

            // Move ALL tasks that have arrived into availablePQ
            while (!enqueuePQ.isEmpty()
                    && enqueuePQ.peek()[0] <= time) {

                availablePQ.offer(enqueuePQ.poll());
            }

            // Pick ONE task:
            // smallest processingTime, then smallest index
            int[] task = availablePQ.poll();

            // Store the original index in the result
            res[resIdx++] = task[2];

            // CPU processes this task
            time += task[1];
        }

        return res;
    }
}

/*

//doesnt work entirely
//implemented myself after reading a walk-thru example in chatgpt
//please check //here
class Solution {
    public int[] getOrder(int[][] tasks) {

        //zeroth, create res array
        int resIdx = 0;
        int[] res = new int[tasks.length];

        //first, create PQ where its sorted in ASC by enqueueTimei only
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Integer.compare(a[0], b[0]); 
                return cmp;
        });

        //second, populate the PQ
        //each item has three elements = [enqueueTimei, processingTimei, i]
        for(int i=0; i<tasks.length; i++){
            int[] task = tasks[i];

            int[] item = new int[3];
            item[0] = task[0];
            item[1] = task[1];
            item[2] = i;

            pq.offer(item);
        }

        //third, process the first task manually
        int time = 0;
        int[] first_task = pq.poll();
        time = first_task[0] + first_task[1];
        res[resIdx++] = first_task[2];

        //fourth, create pq1 is ASC sorted by processingTimei first, index second.
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(
            (a, b) -> {
                int cmp = Integer.compare(a[1], b[1]); 
                
                if(cmp!=0){
                    return cmp;
                }

                return Integer.compare(a[2], b[2]); 
        });

        //sixth, keep going over the pq until its empty,
        //each time pull out task which are smaller than current time,
        //put them in pq1.
        while(!pq.isEmpty()){
            if(!pq.isEmpty() && pq.peek()[0]<=time){
                int[] it = pq.poll();
                pq1.offer(it);
            }else{
                //coming here means pq1 may be populated,
                //if populated, pq1 need to be processed.
                //if not populated, time need to be increased to the next pq[0] value
                if(pq1.isEmpty()){
                    time = pq.peek()[0];
                }else{
                    //process pq1
                    while(!pq1.isEmpty()){
                        int[] it = pq1.poll();
                        res[resIdx++] = it[2];
                        time = time + it[1];
                    }
                }
            }
        }

        // Process remaining available tasks
        //here - i was missing this block
        while(!pq1.isEmpty()){
            int[] it = pq1.poll();
            res[resIdx++] = it[2];
            time = time + it[1];
        }

        return res;
    }
}

*/