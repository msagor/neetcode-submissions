class Solution {

    //implemented myself
    public String mergeAlternately(String word1, String word2) {
        
        int s1 = 0;

        String res = "";
        
        while(s1 < word1.length()){
            
            res = res + word1.charAt(s1) + (s1< word2.length()?word2.charAt(s1):"");

            s1++;
        }

        //add the remaining string from word2 if exists
        if(s1<word2.length() ){
            res = res + word2.substring(s1);
        }

        return res;
        
    }
}