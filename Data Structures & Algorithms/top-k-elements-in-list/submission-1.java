class Solution {

    // tried, watched solution video, implemented the code myself
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> key_to_freq = new HashMap<>();

        //max freq can be n when all nums are unique plus 1
        List<Integer>[] freq_to_keys = new List[nums.length+1];

        //initialize with empty array
        for (int i = 0; i < freq_to_keys.length; i++) {
            freq_to_keys[i] = new ArrayList<>();
        }

        //populate key_to_freq
        for(int i : nums){
            int f = key_to_freq.getOrDefault(i, 0);
            key_to_freq.put(i, ++f);
        }

        //populate freq_to_keys
        for (int key: key_to_freq.keySet()){
            int f_val = key_to_freq.get(key);
            List<Integer> innerlist = freq_to_keys[f_val];
            if(!innerlist.contains(key)){
                innerlist.add(key);
                freq_to_keys[f_val] = innerlist;
            }
        }

        // go from end to start of freq_to_keys to find the top k elem
        int[] res = new int[k];
        int k_index = 0;
        for(int i=freq_to_keys.length-1; i>0 && k_index<k ; i--){
            List<Integer> innerlist = freq_to_keys[i];
            if(innerlist.size()!=0){
                for(int v: innerlist){
                    res[k_index] = v;
                    k_index++;
                }  
            }
        }

        return res;
    }
}
