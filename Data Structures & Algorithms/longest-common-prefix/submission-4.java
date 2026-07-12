
//first imagine how we would find the longest common prefix between two strings,
//we sould have to keep matching their characters one by one and get the most amount of match.
//in this problem, we need to run a loop across the entire array of strings,
//and keep finding the common prefix for all strings.
//for first iteration, we take two strings from the list and find the common prefix of them and store in global variable res.
//after that, we take one string from the list and find common prefix between res and that one string.

class Solution {

    String res = "";
    String str1 = "";
    String str2 = "";

    public String longestCommonPrefix(String[] strs) {
        for(int i=0; i< strs.length; i++){
            if(i==0){
                //the first iteration we pick two strings from the list and find LCP.
                //but the given list can also have only one string in it, 
                //so for the first iteration, we need to pick the same string for str1 and str2,
                //yeah i know its one operation inefficient.
                str1 = strs[0];
                str2 = strs[0];

                res = findPrefixbetweenTwoStrings(str1, str2);
            }else{
                //we are not doing first iteration,
                //that means res probably has a possible result in it.
                //we need to pick another string from the list and compete that against res.
                str1 = strs[i];
                str2 = res;

                //here we also reset res but we dotn have to 
                res = "";

                res = findPrefixbetweenTwoStrings(str1, str2);
            }
        }

        return res;
    }

    public String findPrefixbetweenTwoStrings(String s1, String s2){
        String prefix = "";
        for(int i=0; i< Math.min(s1.length(), s2.length()); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                prefix = prefix + s1.charAt(i);
            }else{
                break;
            }
        }
        return prefix;
    }
}