class Solution {
    //did myself but needed help from chatGPT for line #10,
    //was missing the -1
    public boolean isPalindrome(String s) {
        
        String ss =  s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i=0; i< ss.length()/2; i++){


            if(ss.charAt(i) != ss.charAt(ss.length()-i-1)){
                return false;
            }
        }

        return true;
    }
}
