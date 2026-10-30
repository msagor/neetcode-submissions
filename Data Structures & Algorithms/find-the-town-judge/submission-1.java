class Solution {
    public int findJudge(int n, int[][] trust) {

        Set<Integer> uniquePeople = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        //first, populate hashset and hashmap
        for(int[] tr: trust){

            //add to set
            uniquePeople.add(tr[0]);
            uniquePeople.add(tr[1]);

            //add to map
            if(!map.containsKey(tr[0])){
                List<Integer> list = new ArrayList<>();  
                list.add(tr[1]);
                map.put(tr[0], list);     
            }else{
                List<Integer> list = map.get(tr[0]);
                list.add(tr[1]);
                map.put(tr[0], list);
            }
        }

        //second, go by each elem in set and check its list
        //exactly one guy has an empty list.
        for(int p: uniquePeople){
            if(!map.containsKey(p)){
                //p doesnt follow anyone
                //now check if everyone follow p
                boolean contains = true;
                for(int pp: uniquePeople){
                    if(map.containsKey(pp) ){
                        if(map.get(pp).contains(p)){
                            contains = true;
                        }else{
                            contains = false;
                            break;
                        }
                    }
                }

                if(contains){
                    return p;
                }

            }
        }

        return -1;
    }
}