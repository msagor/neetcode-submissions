class Solution {
    public int lengthOfLongestSubstring(String s) {

        //we use sliding window mechanism to solve this problem,
        //we keep sliding a window of unique characters across the string s,
        //when we encounter a duplicate char, we adjust the window size by removing those duplicate
    
        //contains list of unique characters
        Set<Character> alphabets = new HashSet<>();
        

        int maxlength = 0;

        //initially the window size is 0
        int l = 0;
        int r = 0;

        //iterate over each char in string s
        while(r<s.length()){
            char c = s.charAt(r);

            //check if c was observed before
            if(alphabets.contains(c)){
                //we hit a duplicate
                //for example - string abcabcbb, r reached at index 3 at value a
                   //the current window is - l is at index 0 and r is at index 3,
                   //so we need to update l so that the window does not contain any duplicate,
                   //so we need to increment l to index 1
                //another example - for string abcba when l=0 and r=3, 
                   //so we want to increment l to index 2
                while(l<r){
                    if(s.charAt(l)!=c){
                        //remove this from set
                        alphabets.remove(s.charAt(l));

                        //increment l
                        l++;
                    }else{
                        //remove this from set
                        alphabets.remove(s.charAt(l));

                        //increment l
                        l++;

                        //break loop
                        break;
                    }
                    
                }

            }else{
                //this is unique character
                //for example - string abcabcbb, we reached a at index 0

                //add it to the hashSet
                alphabets.add(c);

                //increment r;
                r++;

            }

            //update maxlength after each iteration and only keep the maximum
            maxlength = Math.max(maxlength, r-l);
            
            
        }
        return maxlength;
    }
}
