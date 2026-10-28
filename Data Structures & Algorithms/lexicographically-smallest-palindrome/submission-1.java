//from leetcode
class Solution {
    public String makeSmallestPalindrome(String s) {
        
        int l = 0;
        int r = s.length()-1;

        StringBuilder sb = new StringBuilder(s);

        //when l crosses over r we stop
        //l and r can be on same index for once
        while(l<=r){
            //we compare and replace the larger one
            if(s.charAt(l)>s.charAt(r)){
                sb.setCharAt(l, s.charAt(r));
            }else{
                sb.setCharAt(r, s.charAt(l));
            }

            //increment
            l++;
            r--;

        }

        return sb.toString();
    }
}
