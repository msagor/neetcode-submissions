class Solution {
    //tried myself first, then look at video solution and implemented myelf
    //basically you must check every substring whether its a valid palindrome or not
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                String leftCharExcluded = s.substring(0,l) + s.substring(l+1);
                String rightCharExcluded = s.substring(0,r) + s.substring(r+1);
                return isPalindrome(leftCharExcluded) || isPalindrome(rightCharExcluded);
            }
        }

        return true;
    }

    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;

        while(l<r){

            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }

        return true;
    }

    public boolean validPalindrome_mySolution(String s) {
        Map<Character, Integer> alphabets = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            alphabets.put(c, alphabets.getOrDefault(c, 0)+1);
        }

        int count = 0;
        for(char c: alphabets.keySet()){
            if(
                alphabets.get(c) == 1
            ){
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}