class TimeMap {

    public class Tuple{
        public String x;
        public int y;

        public Tuple(String x, int y){
            this.x = x; //value
            this.y = y; //timestamp
        }
    }

    //hashmap of list of tuples
    Map<String, List<Tuple>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        //first check if the map contains the key already
        if(map.keySet().contains(key)){
            //key contains so fetch the list of tuples
            List<Tuple> list = map.get(key);

            //create a tupe
            Tuple t = new Tuple(value, timestamp);
            
            //add the tuple to the list
            list.add(t);

            //push the list into the map
            map.put(key, list);
        }else{
            //the key is new
            //create a new list of tuples
            List<Tuple> list = new ArrayList<>();

            //create a tupe
            Tuple t = new Tuple(value, timestamp);

            //add the tuple to the list
            list.add(t);

            //push the list into the map
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.keySet().contains(key)){
            //key contains so fetch the list of tuples
            List<Tuple> list = map.get(key);

            //now do binary search
            return binarySearchToGetVal(list, 0, list.size()-1, timestamp);
        }else{
            return "";
        }
        
    }

    //solution from chatgpt
    public String binarySearchToGetVal(List<Tuple> list, int left, int right, int target) {

        if (left > right) {
            return "";
        }

        int mid = left + (right - left) / 2;

        // perfect match → still search right for better (newer) valid answer
        if (list.get(mid).y == target && left==right) {
            String rightResult = binarySearchToGetVal(list, mid + 1, right, target);
            return rightResult.isEmpty() ? list.get(mid).x : rightResult;
        }

        // mid is too big → go left
        if (list.get(mid).y > target) {
            return binarySearchToGetVal(list, left, mid - 1, target);
        }else{
            // mid is valid candidate → store it, but try to find better on right
            String rightResult = binarySearchToGetVal(list, mid + 1, right, target);
            return rightResult.isEmpty() ? list.get(mid).x : rightResult;
        }
    }

    //my solution that did not work
    /*public String binarySearchToGetVal(List<Tuple> list, int left, int right, int target){

        //we exhausted the whole list
        if(left>right){
            return "";
        }

        //when btoh pointer points to the same elem, this is the last elemt
        if(left==right){
            //direct match test
            if(target == list.get(left).y){
                return list.get(left).x;
            }


            //handle left
            if(left==0){
                if(target < list.get(left).y){
                    return "";
                }else if(list.get(left).y < target){
                    return list.get(left).x;
                }
            }else{
                if(target < list.get(left).y){
                    return list.get(left-1).x;
                }else if(list.get(left).y < target){
                    return list.get(left).x;
                }
            }

            //handle right
            if(right==list.size()-1){
                if(list.get(right).y < target ){
                    return list.get(right).x;
                }
            }else{
                if(target < list.get(right).y){
                    return list.get(right-1).x;
                }else if(list.get(right).y < target){
                    return list.get(right).x;
                }
            }
        }

        //get mid
        int mid = left + (right - left)/2;

        //handle mid
        //direct match test
        if(target == list.get(mid).y){
            return list.get(mid).x;
        }else if(mid==0){
            if(target == list.get(mid).y){
                return list.get(mid).x;
            }else{
                return "";
            }
        }else if (mid>0 && target < list.get(mid).y){
            return list.get(mid-1).x; 
        }else if(mid < list.size()-1 && list.get(mid).y < target){
            return list.get(mid-1).x;
        }
        
        //coming here means mid did not deluiver result
        if(target <= list.get(mid).y){
          //the target value in the left side of the list
            return binarySearchToGetVal(list, left, mid-1, target);
        }else{
            //the target value in the right side of the list
            return binarySearchToGetVal(list, mid+1, right, target);
        }
    }*/
}
