class Solution {
    //typed myself
    //please see the previous submission


    //note below solution is not the most optimal.
    //we use a minHeap where we push all n elements that takes O(nlogn)
    //we dont need to keep all n elements, we only need to keep k elements.
    //we could use a maxHeap instead, and only keep K elements.
    //each time we add to the maxHeap we check, if maxHeap overflowing, 
    //i nthat case we do a pull.
    //to use maxHeap the comparator would be - return Integer.compare(b[0], a[0]);
    //using maxHeap the time complexity would be O(nlogk)
    public int[][] kClosest(int[][] points, int k) {

        //create a comparator that will compare the first elements of two arrays
        //ex - [a1 ,b1, c1] and [a2, b2, c2], compare between a1 and a2
        Comparator<int[]> cmp = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        };

        //create a PQ with the comparator
        PriorityQueue<int[]> PQ = new PriorityQueue<int[]>(cmp);

        //populate the PQ
        for(int[] p: points){

            int sqr_dist_x = (p[0] - 0)*(p[0] - 0);
            int sqr_dist_y = (p[1] - 0)*(p[1] - 0);
            int sqr_dist = sqr_dist_x + sqr_dist_y;

            PQ.offer(new int[]{sqr_dist, p[0], p[1]});
        }

        //create a res array
        int[][] result = new int[k][2];


        //run a loop across the PQ
        for(int i=0;i < k; i++){
            int[] point = PQ.poll();

            int[] res = new int[]{point[1], point[2]};

            result[i] = res;
        }

        return result;

    }
}
