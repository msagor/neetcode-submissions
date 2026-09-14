class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //we need to first find the frequescies of each values in the array
        //we need a hashmap of <Integer, Integer>
        Map<Integer, Integer> key_to_freq = new HashMap<>();

        //1. we also going to need a list of arrays, to hold the numbers of same frequencies.
        //2. since frequency cannot be 0, so we need, to start counting from 1.
        //3. this is an array of list (of integers).
        //4. new List<Integer>[nums.length+1] is not allowed in java.
        List<Integer>[] freq_to_keys = new List[nums.length+1];

        //initialize with empty array
        for (int i = 0; i < freq_to_keys.length; i++) {
            freq_to_keys[i] = new ArrayList<>();
        }

        //populate key_to_freq map
        for(int i: nums){
            int stored_value = key_to_freq.getOrDefault(i, 0);
            key_to_freq.put(i, ++stored_value);
        }

        //populate freq_to_keys list
        for(int key: key_to_freq.keySet()){
            int f_val = key_to_freq.get(key);

            List<Integer> innerlist = freq_to_keys[f_val];

            //check if the innerList already contains the candidate val
            if(!innerlist.contains(key)){
                innerlist.add(key);
                freq_to_keys[f_val] = innerlist;
            }
        }

        //1. go from end to start of freq_to_keys list to get the k most frequest values
        //2. the indeces in freq_to_keys are actually frequency values, that is why we go from end to start
        //3. we also need to stop after k
        int[] res = new int[k];
        int k_index = 0;
        for(int f=freq_to_keys.length-1; k_index!=k && f>=0; f--){

            List<Integer> innerlist = freq_to_keys[f];

            //check if the innerlist is not empty
            if(innerlist.size()!=0){
                //this innerlist contains some unique keys
                for(int inl: innerlist){
                    res[k_index] = inl;
                    k_index++;
                }
                
            }
        }

        return res;

    }
}




/*

//Suman Bhunia

public int[] topKFrequent(int[] nums, int k) {

    // Map stores:
    // key   = number
    // value = how many times the number appears
    Map<Integer, Integer> map = new HashMap<>();

    // Count the frequency of every number
    for (int n : nums) {

        // Start count at 1 because we are seeing n right now
        int count = 1;

        // If n was already seen before,
        // add its previous count
        if (map.containsKey(n))
            count += map.get(n);

        // Store/update the frequency of n
        map.put(n, count);
    }


    // Min heap that stores numbers.
    // The numbers are compared based on their frequency in the map.
    //
    // The number with the SMALLEST frequency will be at the top.
    PriorityQueue<Integer> minHeap =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));


    // Go through every unique number
    for (int n : map.keySet()) {

        // If the heap does not have k elements yet,
        // simply add the current number
        if (minHeap.size() < k)
            minHeap.add(n);

        // If heap already has k elements,
        // compare the current number's frequency
        // with the smallest frequency currently in the heap.
        //
        // minHeap.peek() gives us the number with
        // the smallest frequency in the heap.
        else if (map.get(minHeap.peek()) < map.get(n)) {

            // Remove the least frequent number
            minHeap.poll();

            // Add the new number because it has a higher frequency
            minHeap.add(n);
        }
    }


    // At this point, the heap contains
    // the k most frequent numbers
    int[] result = new int[k];

    // Remove all k numbers from the heap
    // and place them into the result array
    for (int i = 0; i < k; i++)
        result[i] = minHeap.poll();

    // Return the k most frequent numbers
    return result;
}

*/