class Solution {
    //leetcode - https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/
    //solution copied from discussion
    public String findValidPair(String s) {
        StringBuilder sb = new StringBuilder();

        // maintain a map of the character and its frequency
        Map<Character, Integer> frequency_map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequency_map.put(s.charAt(i), frequency_map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // iterate through the array and compare adjacent characters
        // if the frequency matches that character for both,
        // then append them to StringBuilder object and break the loop
        // since we have to find the 1st pair when moving left to right
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                continue;
            }
            
            // convert the character to int before comparing
            if ((s.charAt(i)-'0') == frequency_map.get(s.charAt(i)) &&
                    (s.charAt(i + 1)-'0') == frequency_map.get(s.charAt(i + 1))) {
                sb.append(s.charAt(i)).append(s.charAt(i + 1));
                break;
            }
        }

        return sb.toString();
    }
}
