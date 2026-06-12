class Solution {
    public int characterReplacement(String s, int k) {
        
        //saw the video solution then i implemented the whole code with 5-6 errors, AI helped fix.
        int res = 0;

        //keep count of the frequency of each char
        Map<Character, Integer> map = new HashMap<>();

        //initial sliding window
        int l=0;
        int r=0;

        while(r<s.length()){

            //get the target char for this iteration
            char c = s.charAt(r);

            //put the char for the first time in the map or increment if already exists
            map.put(c, map.getOrDefault(c, 0) + 1);

            //get the char and its count who is the max in the map as of now
            char max_char = '!';
            int max_count_val = -1;

            for(char cc: map.keySet()){
                int val = map.get(cc);
                if(val>max_count_val){
                    max_char = cc;
                    max_count_val = val;
                }
            }

            //get the current window size
            int curr_window_size = r-l+1;

            //check if the current window contains at most k places where we can make changes
            if(curr_window_size - max_count_val <= k){
                //that means this window is valid
                //we need to remember this window size
                res = Math.max(res, curr_window_size);
            }else{
                //current window contains more than k places where we could make changes
                //so we need to shorten our window

                //move the left pointer one place to right,
                //but before doing that reduce the char from map 
                char cc = s.charAt(l);
                int vv = map.getOrDefault(cc, -1);
                if(vv>0){
                    map.put(cc, map.get(cc)-1);
                }else{
                    map.remove(cc);
                }

                l++;
            }

            //iteration for next char
            r++;
        }


        return res;
    }
}
