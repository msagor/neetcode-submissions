class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> uniqueNums = new ArrayList<>();

        List<Integer> count = new ArrayList<>();

        for(int i: nums){

            //if i doenst exist create first
            if(!uniqueNums.contains(i)){
                uniqueNums.add(i);
                count.add(0);
            }

            //get the index of i
            int idx = uniqueNums.indexOf(i);

            //increment the count for that idx in count list
            count.set(idx, count.get(idx)+1);
        }

        //coming here means we have the counts for each nums

        List<Integer> res = new ArrayList<>();

        int targetCount = (int) Math.floor(nums.length/3);

        for(int i=0; i<count.size(); i++){

            int c = count.get(i);

            if(c>targetCount){

                //get the digit for count c
                int d = uniqueNums.get(i);

                res.add(d);
            }
        }

        return res;
    }
}