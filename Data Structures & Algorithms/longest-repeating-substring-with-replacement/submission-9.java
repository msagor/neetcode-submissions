class Solution {
    //for understanding purpose, watch neetcode explainer video -
    //https://www.youtube.com/watch?v=gqXU1UyA8pk
    //implemented myself after watching video solution.
    //my explainer comment at the bottom
    //also check previous submission, coz this submission is a little different than that.
    public int characterReplacement(String s, int k) {
        
        //result to return
        int res = Integer.MIN_VALUE;

        //we create a map where keep the frequency ofcharacters stored
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        while(r<s.length()){

            //get the character
            char c = s.charAt(r);

            //increment the count for the character in the map
            map.put(c, map.getOrDefault(c, 0) + 1);

            //run a seaech thru the map to find the char that is the most frequent
            char maxChar = '!';
            int maxCharCount = Integer.MIN_VALUE;
            for(char cc: map.keySet()){
                int c_count = map.get(cc);
                if(c_count>maxCharCount){
                    maxChar = cc;
                    maxCharCount = c_count;
                }
            }

            //get current window size
            int window_size = r - l + 1;

            //check if we have enough room for error for this window size
            if(window_size - maxCharCount <= k){
                //this window size is good
                //so this can be a possible result
                //we keep the max between this window size and the res that is already recorded
                res = Math.max(res, window_size);

                //need to increment r counter for next iteration
                r++;
            }else{
                //this window size doesnt have enough room for error
                //so we need to increment l pointer and check again
                //before incrementing the l pointer, we need to decrement the char at l by 1
                //we also need to decrement the char at c by 1, the one we added in this iteration.
                //this is iteration 06 from example below
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                map.put(c, map.get(c)-1);

                //increment l pointer
                l++;

                //we do not increment r in this iteration
            }
 
        }

        return res;
    }
}


//algorithmic explanation - 
//suppose the given String is AAABABB and K = 1
//we start the sliding window with l=0 and r=0,
//at every iteration, the result is the window size
//here we go - 
    //iteration 01 => l=0, r=0, window=A,      A_count=1, B_count=0, good=✅, res=1
    //iteration 02 => l=0, r=1, window=AA,     A_count=2, B_count=0, good=✅, res=2
    //iteration 03 => l=0, r=2, window=AAA,    A_count=3, B_count=0, good=✅, res=3
    //iteration 04 => l=0, r=3, window=AAAB,   A_count=3, B_count=1, good=✅, res=4
    //iteration 05 => l=0, r=4, window=AAABA,  A_count=4, B_count=1, good=✅, res=5
    //iteration 06 => l=0, r=5, window=AAABAB, A_count=4, B_count=2, good=❌, res=no_result
    //iteration 07 => l=1, r=5, window=AABAB,  A_count=3, B_count=2, good=❌, res=no_result
    //iteration 08 => l=2, r=5, window=ABAB,   A_count=2, B_count=2, good=❌, res=no_result
    //iteration 09 => l=3, r=5, window=BAB,    A_count=1, B_count=2, good=✅, res=3
    //iteration 10 => l=3, r=6, window=BABB,   A_count=1, B_count=3, good=✅, res=4
//so the maximum window we observed is 5 so the result is 5
