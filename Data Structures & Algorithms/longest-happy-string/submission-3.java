
//did entirely myself
//do not pull two char in one iteration
//see my prev implementation below that does not work
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        String res = "";

        PriorityQueue<String[]> pq = new PriorityQueue<>(
            (x,y) -> Integer.compare(Integer.parseInt(y[1]), Integer.parseInt(x[1]))
        );

        String[] a_item = new String[]{"a", Integer.toString(a)};
        String[] b_item = new String[]{"b", Integer.toString(b)};
        String[] c_item = new String[]{"c", Integer.toString(c)};

        if(a!=0){pq.offer(a_item);}
        if(b!=0){pq.offer(b_item);}
        if(c!=0){pq.offer(c_item);}

        while(!pq.isEmpty()){
            //get the item with most freq
            String[] item = pq.poll();

            System.out.println("handling item - " + item[0] + " freq - " + item[1]);

            //check if the res already have last two char as item
            if(
                res.length()>=2 && 
                String.valueOf(res.charAt(res.length()-1)).equals(item[0]) &&
                String.valueOf(res.charAt(res.length()-2)).equals(item[0])
            ){
                //we cannot use this item
                if(!pq.isEmpty()){

                    //so we pull from pq again
                    String[] item1 = pq.poll();

                    System.out.println("we cannot use item - " + item[0] + " so we poll again - " + item1[0]);

                    res = res + item1[0];
                    item1[1] = Integer.toString(Integer.parseInt(item1[1])-1);

                    //then push both items back in pq
                    if(Integer.parseInt(item[1])>0){pq.offer(item);}
                    if(Integer.parseInt(item1[1])>0){pq.offer(item1);}
                    
                    
                }else{
                    break;
                }
            }else{
                //we can use this item
                res = res + item[0];
                item[1] = Integer.toString(Integer.parseInt(item[1])-1);

                //and push it back to pq
                if(Integer.parseInt(item[1])>0){
                    pq.offer(item);
                }
                

            }
        }

        return res;
    }
}




/*
//does not work because im pulling two char in each iteration
class Solution {
    public String longestDiverseString(int a, int b, int c) {

        String res = "";

        PriorityQueue<String[]> pq = new PriorityQueue<>(
            (x,y) -> Integer.compare(Integer.parseInt(y[1]), Integer.parseInt(x[1]))
        );

        String[] a_item = new String[]{"a", Integer.toString(a)};
        String[] b_item = new String[]{"b", Integer.toString(b)};
        String[] c_item = new String[]{"c", Integer.toString(c)};

        if(a!=0){pq.offer(a_item);}
        if(b!=0){pq.offer(b_item);}
        if(c!=0){pq.offer(c_item);}

        String[] prev = null;

        while(!pq.isEmpty()){
            //get the item with most freq
            String[] item = pq.poll();

            System.out.println("handling item - " + item[0] + " freq - " + item[1]);

            //handle prev
            if(prev!=null && Integer.parseInt(prev[1])>0){
                pq.offer(prev);
            }

            prev = null;

            //handle curr
            int count = 2;
            while(count>0 && Integer.parseInt(item[1])>0){
                
                res = res + item[0];
                item[1] = Integer.toString(Integer.parseInt(item[1])-1);
                count--;
            }

            //set the item to prev only if count is 0
            if(count==0){
                System.out.println("setting prev - " + item[0] + " freq - " + item[1] + " res  - " + res);
                prev = item;
            }
        }

        return res;

    }
}

*/