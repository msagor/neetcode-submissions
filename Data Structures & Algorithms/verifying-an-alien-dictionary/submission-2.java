//there are two things in sorting a list of words lexicographically - 
    //one - all words need to be sorted following the order
    //two - even when they are sorted, the length of words need to be smaller ---> larger

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            map.put(order.charAt(i), i);
        }

        // we compare two words at a time...
        for(int i=0; i<words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];

            int j=0;
            while(j<w1.length() && j<w2.length()){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                
                if(c1!=c2){
                    if(map.get(c1)>map.get(c2)){
                        return false;
                    }else{
                        break;
                    }
                }
                j++;
            }

            //coming here means we have completed the lexicographical check, 
            //so we need to check the order of words here
            //here we add a length check becsasue we dont want to return false prematurely.
            //ex: disk vs dog - 
                //we would exit when we have done comparing i vs o but we have chars left over
            //ex: neetcode vs nbeet - 
                //we would exit when we have done comparing t vs t but secoind word has no char left to compare..
            if(w1.length()>w2.length() && j==Math.min(w1.length(), w2.length())){
                return false;
            }
        }

        return true;
    }
}