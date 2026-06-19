class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //implemented in LeetCode coz NeetCode dont have this problme
        //read the solution then implemented myself
        //we need to sort the pattern p string
        //then run a sliding window of length(p) and move one place at a time
        //and sort the substring in the window and match with the sorted pattern

        //make a res list of integer
        List<Integer> res = new ArrayList<>();

        //first check if s is smaller than p
        if(s.length() < p.length()){
            return res;
        }
        
        //second sort the pattern p 
        String p_sorted = sortString(p);

        //third, we run a sliding window across the string s
        int left = 0;
        int right = p_sorted.length()-1;

        while(right <= s.length()-1){
            //get the substring for this window
            String subS = s.substring(left, right+1);

            String subS_sorted = sortString(subS);

            //System.out.println("left- " + left + " right- " + right + " pattern- " + p_sorted + " subS- " + subS_sorted);

            //check if sorted string is equal to pattern
            if(subS_sorted.equals(p_sorted)){
                //get store the left index in the array
                res.add(left);
            }

            //increment left and right index
            left++;
            right++;
        }
        return res;
    }

    public String sortString(String p){
        //convert string in char array
        char[] p_charArray = p.toCharArray();

        //sort the char array
        Arrays.sort(p_charArray);

        //convert sorted char array into string
        String p_sorted = new String(p_charArray);

        return p_sorted;
    }
}
