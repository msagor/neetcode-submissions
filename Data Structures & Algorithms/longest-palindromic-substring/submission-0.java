class Solution {
    //watched the video solution then implemented myself
    //we need to iterate over each character and treat that character as a center of pallindrome
    //there can be odd or even numbered pallindrom, we need to check both.
    //odd number pallindrome, the middle char is unique, eample, abcdcba, here d is unique
      //so for each char, we expand sideways and keep doing char matching.
    //even number pallindrome, the middle two chars are same, ex - abccba, here cc are same.
      //so for each char, we check if the next char is same
    //example: 
    //for word 'racecar' we run a for loop for each character
      //iteration 02 for char c,
        //odd check - the alphabets around c are (a,e), which are not same, so odd check fails ❌
        //even chen - the alphaben next ot c is e, which are not same, so even check fails ❌
      //iteration 03 for char e,
        //odd check - the alphabets around e are (c,c),(a,a),(r,r), which are same, so odd check pass ✅ 
        //even chen - the alphaben next to e is c, which are not same, so even check fails ❌
    public String longestPalindrome(String s) {
        
        String res = "";

        for(int i=0; i<s.length(); i++){

            
            //odd check
            int l=i;
            int r=i;
            while(l>=0 && r<s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    //this satisfies odd pallindrom check
                    //record this res but keep the bigger one
                    if(s.substring(l, r+1).length() > res.length()){
                        res = s.substring(l, r+1);
                    }

                    l--;
                    r++;
                }else{
                    break;
                }
                
            }

            //even pallindrome check
            l=i;
            r=i+1;
            while(l>=0 && r<s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    //this satisfies even pallindrom check
                    //record this res but keep the bigger one
                    if(s.substring(l, r+1).length() > res.length()){
                        res = s.substring(l, r+1);
                    }

                    l--;
                    r++;
                }else{
                    break;
                }
            }

        }

        return res;
    }
}
