class Solution {
    public int subarraySum(int[] nums, int k) {

        //did not understand the problem coz tricky
        //then watched NeetCode video multiple time
        //then implemented myself and still did nto work
        //then chatgpt fixed it

        //the given array is not sorted
        //values can be negative
        //k can be negative as well

        //resultant variable
        int res = 0;

        //this map keeps track of how many ways every prefixSum can be achieved
        Map<Integer, Integer> map = new HashMap<>();

        //we put an initial value in the map that is (0, 1)
        //meaning there is currently 0 ways to 1 way to achieve prefixSum 0
        map.put(0, 1);

        //the total sum across the array
        int currSum = 0;
        for(int i=0; i< nums.length; i++){
            //get the currnt value
            int v = nums[i];

            //add to the currSum
            currSum = currSum + v;

            //check the difference of the currSum - k
            int pfs = currSum - k;

            //now we check how many ways we can fulfil the pfs
            if(map.containsKey(pfs)){
                //there is a match
                //meaning we have some ways to fulfil the pfs
                //get the count of the ways
                int existing_count = map.get(pfs);
                res = res + existing_count;
            }
            //we put the the count for currSum in the map
            int existing_count = map.getOrDefault(currSum, 0);
            map.put(currSum, existing_count+1);
        }

        return res;
    }
}