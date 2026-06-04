class Solution {
    // tried, solution
    public List<List<String>> groupAnagrams(String[] strs) {
        // we need to compute a kind of 'unique hash' of each anagram, 
        // and put them in a map of <String, List<String>>

        Map<String, List<String>> outerMap = new HashMap<>();

        for (String s : strs) {
            //create an array of size 26 with initialized to 0
            int[] count = new int[26];

            //only increase the count for char that are present
            for(int i=0; i< s.length(); i++){
                char c = s.charAt(i);
                int index = c - 97;
                count[index]++;
            }

            //convert the count array into string
            String hashKey = Arrays.toString(count);

            //put the hashKey into outerMap
            outerMap.putIfAbsent(hashKey, new ArrayList<>());
            outerMap.get(hashKey).add(s);
        }

        return new ArrayList<>(outerMap.values());
    }
}
