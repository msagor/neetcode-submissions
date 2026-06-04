class Solution {

    //solution done by me
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            char s_str = s.charAt(i);
            //check if s_str already exists in countS
            if(countS.containsKey(s_str)){
                //get current count of s_str
                int s_str_count = countS.get(s_str);

                //add +1
                int s_str_count_new = s_str_count + 1;

                //push in the hashmap
                countS.put(s_str, s_str_count_new);
            }else{
                //first time push in the hashmap
                countS.put(s_str, 1);
            }

            char t_str = t.charAt(i);
            //check if t_str already exists in countT
            if(countT.containsKey(t_str)){
                //get current count of t_str
                int t_str_count = countT.get(t_str);

                //add +1
                int t_str_count_new = t_str_count + 1;

                //push in the hashmap
                countT.put(t_str, t_str_count_new);
            }else{
                //first time push in the hashmap
                countT.put(t_str, 1);
            }
        }

        return countS.equals(countT);
    }
}

//answer from Solution
/*
public class Solution {
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
*/
