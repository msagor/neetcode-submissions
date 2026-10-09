//please read - the description is very poor.
//issue #1: 
    //there can be multiple pickups at the same location,
    //also can be multiple dropoff at the same locations,
    //so we need to be careful not to add same value twice in the lists.
//issue #2:
    //also pickup and dropoff locations may not be sorted, 
    //so we have to sort the lists,
    //but the description says vehicle only travels from west to east.

//did entirely myself, took a long time thru multiple iterations.
//initially i used arrays for all lists of pickup and dropoff locations,
//but later found out issue #1 above, 
//so that means pickup and dropoff lists can be of different lengths,
//so had to switch everywhere from array to list.
//also, chatgpt told me that values in pickup and dropoff lists may not be sorted.


class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        //first, extract the pickup and dropoff locations and sort them 
        List<Integer> pickup_arr = new ArrayList<>();
        List<Integer> dropoff_arr = new ArrayList<>();

        Map<Integer, Integer> pickupp = new HashMap<>();
        Map<Integer, Integer> dropoff = new HashMap<>();

        //second,populate above data atructures
        for(int i=0; i<trips.length; i++){
            int[] trip = trips[i];

            if(!pickup_arr.contains(trip[1])){
                pickup_arr.add(trip[1]);
            }
            
            if(!dropoff_arr.contains(trip[2])){
                dropoff_arr.add(trip[2]);
            }

            //pickupp.put(trip[1], pickupp.getOrDefault(trip[1], 0) + trip[0]);
            //dropoff.put(trip[2], dropoff.getOrDefault(trip[2], 0) + trip[0]);

            pickupp.merge(trip[1], trip[0], Integer::sum);
            dropoff.merge(trip[2], trip[0], Integer::sum);
        }

        Collections.sort(pickup_arr);
        Collections.sort(dropoff_arr);

        System.out.println("pickup_arr - " + pickup_arr); 
        System.out.println("dropoff_arr - " + dropoff_arr);
        

        //third, merge the two arrays
        List<Integer> stations = new ArrayList<>();

        int p = 0;
        int d = 0;
        while(p<pickup_arr.size() && d<dropoff_arr.size()){

            if(pickup_arr.get(p) == dropoff_arr.get(d)){
                stations.add(pickup_arr.get(p));
                p++;
                d++;
            }else if(pickup_arr.get(p)<dropoff_arr.get(d)){
                stations.add(pickup_arr.get(p));
                p++;
            }else{
                stations.add(dropoff_arr.get(d));
                d++;
            }
        }

        while (p < pickup_arr.size()) {
            stations.add(pickup_arr.get(p));
            p++;
        }

        while(d<dropoff_arr.size()){
            stations.add(dropoff_arr.get(d));
            d++;
        }

        System.out.println("stations - " + stations); 

        //fourth, run the pickup and dropoff simulation
        int curr_pass = 0;
        for(int st:stations){
            curr_pass = curr_pass - dropoff.getOrDefault(st, 0) + pickupp.getOrDefault(st, 0);

            System.out.println("station - " + st + " curr_pass - " + curr_pass);

            //at every point check capacity overflow
            if(curr_pass>capacity){
                return false;
            }
        }
    
        return curr_pass==0?true:false;
    }
}