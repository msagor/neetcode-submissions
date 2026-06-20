class Solution {
    //Permutation in String
    //You are given two strings s1 and s2. 
    //Return true if s2 contains a permutation of s1, or false otherwise. 
    //That means if a permutation of s1 exists as a substring of s2, then return true.

    //this is literally Valid Anagram problme with a twist of sliding window.

    public boolean checkInclusion(String s1, String s2) {
        //we move a sliding window of size s1 to and check it they are anagrams
        int left = 0;
        int right = s1.length()-1;

        while(right <= s2.length()-1){
            //get the substring
            String sub_s2 = s2.substring(left, right+1);

            //check if they are anagrams
            if(isAnagram(sub_s2, s1)){
                return true;
            }else{
                left++;
                right++;
            }
        }

        return false;
    }

    //from chatgpt, my own solution is sismilar but longer
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}
