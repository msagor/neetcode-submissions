class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //so for each string we need to compute a unique hash
        //then store all  strings that produced the same hash in same array
        //so we need a hashmap for hash ---> list of string
        HashMap<String, List<String>> hashToStrings = new HashMap<>();

        //iterate thru each string
        for(String s: strs){

            //create an array of 26 slots
            //all chars of s will be counted 
            //and stored in the array
            int[] alphabets = new int[26];

            // iterate thru each char
            for(int ii=0; ii<s.length(); ii++){
                char c = s.charAt(ii);
                //find the index of c
                int index = c - 97;

                //increment value at index slot
                alphabets[index]++;
            }

            //convert the alphabets array into unique hash
            String hash = Arrays.toString(alphabets);

            //check if this unique hash is absent in the hashToStrings map
            if(!hashToStrings.containsKey(hash)){
                //create an empty array,
                //put the first value in
                //put the array in the map
                List<String> strArray = new ArrayList<>();
                strArray.add(s);
                hashToStrings.put(hash, strArray);
            }else{
                //unique hash is present in the map
                hashToStrings.get(hash).add(s);
            }
        }

        return new ArrayList<>(hashToStrings.values());
    }
}
