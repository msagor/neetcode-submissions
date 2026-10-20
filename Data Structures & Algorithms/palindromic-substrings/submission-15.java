//must do Longest Palindromic Substring before this - https://neetcode.io/problems/longest-palindromic-substring/question


class Solution {

    int res = 0;

    public int countSubstrings(String s) {

        for(int i=0; i<s.length(); i++){

            //odd length expansion
            int l = i;
            int r = i;
            while(l>=0 && r<=s.length()-1){
                if(s.charAt(l) == s.charAt(r)){
                    res++;
                }else{
                    break;
                }
                l--;
                r++;
            }

            //even length expansion
            l = i;
            r = i+1;
            while(l>=0 && r<=s.length()-1){
                if(s.charAt(l) == s.charAt(r)){
                    res++;
                }else{
                    break;
                }
                l--;
                r++;
            }
        }

        return res;
    }   

    public static boolean isPalindrome(String s){

        // Convert to lowercase for case-insensitive check
        s = s.toLowerCase();

        // Reverse the string
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }

        // Compare original and reversed
        return s.equals(rev);
    }
}
