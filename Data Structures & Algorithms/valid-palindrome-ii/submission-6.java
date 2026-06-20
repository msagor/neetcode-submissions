class Solution {
    public boolean validPalindrome(String s) {
        //valid palindrome with at most one deletion
        //watched the video then implemented myself

        if(isPalindrome(s)){
            return true;
        }

        int left = 0;
        int right = s.length()-1;

        while(left<right){
        
            if(s.charAt(left)!=s.charAt(right)){
                
                //get the left string
                String subS_left = s.substring(left, right);

                //get the right string
                String subS_right = s.substring(left+1, right+1);

                if(!isPalindrome(subS_left) && !isPalindrome(subS_right)){
                    return false;
                }
            }

            //when palindrome is good, we come here
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome(String s){
        String s_rev = new StringBuilder(s).reverse().toString();

        if(s.equals(s_rev)){
            return true;
        }

        return false;
    }
}
