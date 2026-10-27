
//done entirely by myself after trying fro three days
//see the diagram - https://drive.google.com/file/d/1rOSRgqDCW63U0jwX9R4a20Wsbs_JC6M6/view?usp=sharing

//im passing substrings of S every time, you could just keep track of indexes,
//in that caase you would have to keep track of two indexes - s and e
//because we dont start from 0 all the time,

// do Keypad Letter Combination after this - https://www.hack2hire.com/question-bank/questions/coding-questions/67e38ccf87527b3f41af78b5/practice?questionId=67e3915487527b3f41af78b6&collectionKey=hack2hire-50-picks





class Solution {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        backtrack(s, path);
        return res;
    }

    public void backtrack(String s, List<String> path){

        if(s.isEmpty()){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0; i<s.length(); i++){
            //get the substring from 0 to i
            String subS = s.substring(0, i+1);

            //check if subS a palindrome
            if(isPalindrome(subS)){

                //get the remaining substirng
                String rem_subS = s.substring(i+1);
                path.add(subS);
                backtrack(rem_subS, path);
                path.removeLast();
            }
        }
    }

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        
        int start = 0;
        int end = str.length() - 1;
        
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false; // Mismatch found, not a palindrome
            }
            start++;
            end--;
        }
        return true; // All characters matched
    }
}