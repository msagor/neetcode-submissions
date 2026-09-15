//watched video solution then implemented myself
//chatGPT fixed my errors at lines with '//here' comments

//intuition #1: group the values
    //example,
        //for input = AAABC and n=3
            //step #1: find out how many times A, B, C tasks are present (A=3, b=1, c=1)
            //step #2: convert them into tuples A=(3,0), B=(1,0), C=(1,0)
                //first elem is the frequency of the task
                //second elem is the remaining colldown period of the task
//intuition #2: use of correct data structure
    //put them in the PQ where they sorted by frequency A=(3,0), B=(1,0), C=(1,0)
//intuition #3: pick the tuple with most frewuency
    //for the above example, we pick from A=(3,0) tuple
    //after first move, A=(3,0) becomes A=(2,3) meaning, 2 frequency and 3 cooldown left
    //we need a mechanism to keep track of this tuple when cooldown reaches to 0
//intuition #4: maintain a separate queue for the tuples needing cooldown
    //after every move, all tuples in the cooldown queue, second value decrements
    //when reaches to 0, we take it out from queue and out it back in the PQ


class Solution {
    public int leastInterval(char[] tasks, int n) {

        //global res
        int res = 0;

        //create frequencey map and populate
        Map<Character, Integer> taskToFreqMap = new HashMap<>();

        for(char c: tasks){

            //here
            taskToFreqMap.put(c, taskToFreqMap.getOrDefault(c, 0) + 1);
        }


        //create maxHeap PQ and populate
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(char c: taskToFreqMap.keySet()){

            int f = taskToFreqMap.get(c);

            int[] tuple = new int[2];
            tuple[0] = f; //frequency of this task
            tuple[1] = 0; //all task start with 0 cooldown

            maxHeap.add(tuple);
        }


        //coming here means PQ is populated
        //create a Queue where we keep all tuples needing cooldown
        Queue<int[]> cooldownQueue = new LinkedList<>();


        while(!maxHeap.isEmpty() || !cooldownQueue.isEmpty()){

            //first get the tuple out of PQ

            //here
            int[] t = null;

            //here
            if(!maxHeap.isEmpty()){

                //here
                t = maxHeap.poll();
            }


            //second process the queue
            int i = 0;
            int queue_size = cooldownQueue.size();

            while(queue_size != 0 && i < queue_size){

                int[] tup = cooldownQueue.poll();

                //decrement cooldown value
                tup[1]--;

                if(tup[0] != 0 && tup[1] != 0){

                    //valid and still have cooldown to go for
                    //so add back to queue
                    cooldownQueue.add(tup);

                }else if(tup[0] != 0 && tup[1] == 0){

                    //valid and cooldown has passed
                    //so put it back to PQ
                    maxHeap.add(tup);
                }

                i++;
            }


            //third process the candidate tuple

            //here
            if(t != null){

                //decrement frequency count

                //here
                t[0]--;

                //add the default cooldown period n
                t[1] = n;

                //put this tuple somewhere only if its still useful
                if(t[0] != 0){

                    //here
                    //if there is no cooldown,
                    //task can immediately become available again
                    if(n == 0){
                        maxHeap.add(t);
                    }

                    //here
                    else{
                        cooldownQueue.add(t);
                    }
                }
            }


            res++;
        }

        return res;
    }
}