
//chatgpt solution, below is my solution which TLE
class Solution {

    public String minWindow(String s, String t) {

        Map<Character, Integer> freq = new HashMap<>();

        int min_Window_size = Integer.MAX_VALUE;
        int startIdx = -1;
        int endIdx = -1;

        //first, populate frequency map using t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        //here: use two pointers instead of restarting from every starter
        int l = 0;
        int matched = 0;

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            //expand window
            if (freq.containsKey(c)) {

                int count = freq.get(c);

                if (count > 0) {
                    matched++;
                }

                freq.put(c, count - 1);
            }

            //shrink window when all required characters are matched
            while (matched == t.length()) {

                //update minimum window
                if (r - l + 1 < min_Window_size) {
                    min_Window_size = r - l + 1;
                    startIdx = l;
                    endIdx = r;
                }

                char leftChar = s.charAt(l);

                //restore frequency when removing left character
                if (freq.containsKey(leftChar)) {

                    int count = freq.get(leftChar);

                    freq.put(leftChar, count + 1);

                    if (count == 0) {
                        matched--;
                    }
                }

                l++;
            }
        }

        if (startIdx == -1) {
            return "";
        }

        return s.substring(startIdx, endIdx + 1);
    }
}



/*

class Solution {

    public String minWindow(String s, String t) {

        List<Integer> starters = new ArrayList<>();
        Map<Character, Integer> freq = new HashMap<>();

        int min_Window_size = Integer.MAX_VALUE;
        int startIdx = -1;
        int endIdx = -1;

        //first, find all starters
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (t.contains(String.valueOf(c))) {
                starters.add(i);
            }
        }

        //here: populate frequency map using t, not s
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        //second, run sliding windows from each starter
        for (int i = 0; i < starters.size(); i++) {

            int l = starters.get(i);

            //here: if remaining characters cannot fit, skip
            if (s.length() - l < t.length()) {
                break;
            }

            //copy freq map
            Map<Character, Integer> freq_copy = new HashMap<>(freq);

            int ll = l;
            int matched = 0; //here: track total matched characters

            while (ll < s.length()) {

                char c = s.charAt(ll);

                //decrement the count for this char
                if (freq_copy.containsKey(c)) {

                    int count = freq_copy.get(c);

                    //here: only count required occurrences
                    if (count > 0) {
                        matched++;
                    }

                    count--;

                    if (count >= 0) { //here: retain zero and negative counts
                        freq_copy.put(c, count);
                    } else {
                        freq_copy.put(c, count);
                    }
                }

                //here: stop once all characters are matched
                if (matched == t.length()) {
                    int window_size = ll - l + 1;

                    if (window_size < min_Window_size) { //here: find smaller window
                        min_Window_size = window_size;
                        startIdx = l;
                        endIdx = ll;
                    }

                    break;
                }

                ll++;
            }
        }

        //here: handle case where no valid window exists
        if (startIdx == -1) {
            return "";
        }

        return s.substring(startIdx, endIdx + 1);
    }
}

*/