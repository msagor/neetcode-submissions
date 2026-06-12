public class Solution {
    //wrong implementation, does not work
    //i understood the problem wrong
    public int characterReplacement(String s, int k) {

        //create a class tuple
        class Tuple{
            public int x;
            public int y;

            public Tuple(int x, int y){
                this.x=x;
                this.y=y;
            }

            public void print(){
                System.out.println("(" + x + "," + y + ")");
            }
        }

        //for all unique characters, we need to find -
            // the length of substrings 
            // the start index of that substring
        //for example, for a string AAAABABBCCCCCC
            //find the starting index and length of substring for A = [{0, 3},{4,1}]
            //find the starting index and length of substring for B = [{3, 1},{5,1}]
            //find the starting index and length of substring for C = [{7,6}]

        //create a set to contains the unique tuple lists
        Map<Character, List<Tuple>> map = new HashMap<>();

        int l=0;
        int r=0;
        while(r<s.length()){

            //increment r to the point we encounter a different char
            while(s.charAt(r) == s.charAt(l)){
                r++;

                if(r>=s.length()){
                    break;
                }
            }
            
            //coming out of inner while loop means we r now points to a different char other than l
            //get the length of the current substring
            int len_subs = r-l;

            //System.out.println("l:" + l + " r:" + r + " len_subs: " + len_subs);

            //the starting index for this substring is l
            //make a tuple of this {starting_index, substring_length}
            Tuple t = new Tuple(l, len_subs);

            //we need to add this tuple to the hashmap
            if(map.keySet().contains(s.charAt(l))){
                //get the list of tuples
                List<Tuple> tuple_list = map.get(s.charAt(l));

                //add new tuple t to the existing list
                tuple_list.add(t);

            }else{
                //fresh entry to the map

                //create a new list
                List<Tuple> new_tuple_t = new ArrayList<>();

                //add new tuple t to the new list
                new_tuple_t.add(t);

                //put the new tuple list in the map
                map.put(s.charAt(l), new_tuple_t);
            }
            l=r;
        }

        return 0;
    }
}
