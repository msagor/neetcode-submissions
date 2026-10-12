
//implemented the whole thing except //here
//and use backtracking to go acorss each words such as - def, ghi, jkl
//and use the for loop to iterate over each char
class Solution {

    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits.isEmpty()){
            return res;
        }

        String[] words = digitsToWordsArray(digits);

        backtrack(words, path, 0, digits.length());

        return res;
    }


    public void backtrack(String[] words, List<String> path, int wordIdx, int targetLength){
        
        if(path.size()==targetLength){
            String str ="";
            for(String s: path){
                str = str + s;
            }

            res.add(str);
            return;
        }
        
        //here - 
        for(int i=0; i<words[wordIdx].length(); i++){
            path.add(String.valueOf(words[wordIdx].charAt(i)));
            backtrack(words, path, wordIdx+1, targetLength);
            path.removeLast();
        }
    }

    public String[] digitsToWordsArray(String digits){

        int idx = 0;
        String[] words = new String[digits.length()];

        for(int i=0; i< digits.length(); i++){

            char c  = digits.charAt(i);

            switch(c){
                case '2':
                   words[idx++] = "abc";
                   break;
                case '3':
                   words[idx++] = "def";
                   break;
                case '4':
                   words[idx++] = "ghi";
                   break;
                case '5':
                   words[idx++] = "jkl";
                   break;
                case '6':
                   words[idx++] = "mno";
                   break;
                case '7':
                   words[idx++] = "pqrs";
                   break;
                case '8':
                   words[idx++] = "tuv";
                   break;
                case '9':
                   words[idx++] = "wxyz";
                   break;
            }

        }

        return words;
    }

}
