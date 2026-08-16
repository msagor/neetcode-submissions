class Solution {

    // we have one outer while loop  and three inner while loops
    public String reverseWords(String s) {
        
        String res = "";

        int i = s.length()-1;

        while(i>=0){

            //pass over empty spaces
            while(i >= 0 && s.charAt(i)==' '){
                i--;
            }

            //read from the end of word until the begining of word
            String word = "";

            while(i >= 0 && s.charAt(i)!=' '){
                word = s.charAt(i) + word;
                i--;
            }

            if(res.isEmpty()){
                //first word
                res = res + word;
            }else{
                res = res + ' ' + word;
            }

            //pass over empty spaces again
            while(i >= 0 && s.charAt(i)==' '){
                i--;
            }

        }

        return res;
    }
}
