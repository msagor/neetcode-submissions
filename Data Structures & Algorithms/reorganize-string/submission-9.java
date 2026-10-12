
//entirely doen myself..took longer than needed

///do Longest Happy String after this - https://neetcode.io/problems/longest-happy-string/question


class Solution {
    public String reorganizeString(String s) {

        String res = "";

        //create maxheap - each item is an array of two strings
        //first - char, second - integer freq value in string
        PriorityQueue<String[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));


        //make a hashmap of frequency by character
        Map<Character, Integer> map = new HashMap<>();

        //populate map
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        //populate maxHeap
        for(char c: map.keySet()){
            String[] it = new String[2];
            it[0] = c + "";
            it[1] = Integer.toString(map.get(c));
            maxHeap.offer(it);
        }

        String[] prevItem = null;

        while(!maxHeap.isEmpty()){
            //handle currItem
            String[] currItem = maxHeap.poll();

            res = res + currItem[0];

            //decrease count for currItem
            currItem[1] = Integer.toString(Integer.parseInt(currItem[1]) - 1);
            
            //handle prevItem
            if(prevItem!=null && Integer.parseInt(prevItem[1])>0){
                maxHeap.offer(prevItem);
            }
            
            //reset prevItem
            prevItem = null;

            //assign currItem to prevItem only if maxHeap is not empty
            if(!maxHeap.isEmpty()){
                prevItem = currItem;
            }else if(Integer.parseInt(currItem[1])>0){
                maxHeap.offer(currItem);
            }
        }
        
        int i = 0;
        while(i<res.length()){
            if(i!=0 && res.charAt(i-1)==res.charAt(i)){
                return "";
            }

            i++;
        }

        return res;
    }
}