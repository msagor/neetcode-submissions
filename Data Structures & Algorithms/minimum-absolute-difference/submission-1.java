class Solution {
    //my implementation, this works but long
    //done on LeetCode - https://leetcode.com/problems/minimum-absolute-difference/
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for(int i=0; i< arr.length; i++){

            int j = i;
            while(j < arr.length){
                if(j==i){
                    //we dont want to compare same value with itself,
                    //go to next iteration.
                }else{
                    //get the absolute difference between arr[i] and arr[j]
                    int diff = Math.abs(arr[i] - arr[j]);

                    //fetch the values stored in the map for diff
                    List<List<Integer>> listOfPairs = map.getOrDefault(diff,  new ArrayList<>());

                    //create a new inner list and populate
                    List<Integer> r = new ArrayList<>();
                    r.add(arr[i]);
                    r.add(arr[j]);

                    //add the inner list int he outer list
                    listOfPairs.add(r);

                    //put the outer list back in the map
                    map.put(diff, listOfPairs);
                }
                j++;
            }
            
        }

        //coming here means the map is populated
        //get the keys of the map and sort
        Set<Integer> keys_set = map.keySet();

        List<Integer> keys_list = new ArrayList<>(keys_set);

        //sort the list
        Collections.sort(keys_list);

        //get the first key
        int min_key = keys_list.get(0);

        //get the value for the min_key
        List<List<Integer>> result = map.get(min_key);

        // sort each pair [a,b]
        for(List<Integer> pair : result){
            Collections.sort(pair);
        }

        // sort pairs based on first value
        Collections.sort(result, (a,b) -> {return a.get(0) - b.get(0);});

        return result;
    }
}
