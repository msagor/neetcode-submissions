class Solution {
    //watched solution then implementdd myself
    public int[][] merge(int[][] intervals) {
        //first we find the starters and their max run
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< intervals.length; i++){
            //get one inner array
            int[] it = intervals[i];

            //get key and value for this inner array
            int key = it[0];
            int val = it[1];

            //fetch the val for the key from map or get -1
            int val_ = map.getOrDefault(key, -1);

            //put the max between val and val_
            map.put(key, Math.max(val, val_));
        }

        //coming here means map is populated
        //get the unique keys from map and put them in a list
        //these values are the starters
        List<Integer> list = new ArrayList<>(map.keySet());

        //sort the starters
        Collections.sort(list);

        //create result data structurre,
        //this is a list of arrays,
        //we need to return array or arrays, aka 2d array.
        //we will use Arrays call to make that conversion.
        List<int[]> result = new ArrayList<>();

        //we now get the first element from the map
        int k1 = list.get(0);
        int v1 = map.get(k1);

        //we run a for loop from index 1 and mark it as k2
        //in each iteration we compare between k1 and k2
        for(int i =1; i<list.size(); i++){

            //get k2 from list
            int k2 = list.get(i);

            //get the value for k2
            int v2 = map.get(k2);


            //check that k2 <= v1
            //that means these two intervals overlap
            if(k2 <= v1){
                //this interval should be merged
                //meaning for k1, we found a higher v1
                //so we store the newer v1 value in v1
                v1 = Math.max(v1, v2);
                
                //we keep running this loop to find more suitable intervals for k1
            }else{
                //(k1,v1) and (k2,v2) are two distinct intervals,
                //so we store the final (k1,v1) into the result
                int[] r = new int[]{k1, v1};
                result.add(r);

                //we move k1 to k2 for next iteration
                k1 = k2;
                v1 = v2;
            }
        }

        //coming here means we exited the for loop
        //note that the last distinct interval still assigned to k1 and v1,
        //but they have not put into the result yet
        int[] r = new int[]{k1, v1};
        result.add(r);


        //convert list into array
        return result.toArray(new int[result.size()][]);
        
    }
}
