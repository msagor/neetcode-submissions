
//baiscally when elders are sitting in a room,
//a youngerf ella enters the room, he can sit if there is enough room.
//but when another elder enters the room, all younger people vacvate the room.


//watched solution video then implemented myself
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length==1){
            return new int[]{nums[0]};
        }
        
        //result object
        int idx=0;
        int[] res = new int[nums.length-k+1];

        //deck where we only store index
        Deque<Integer> deck = new ArrayDeque<>();

        for(int i=0; i< nums.length; i++){

            int n = nums[i];

            //trim smaller values from the tail
            while(!deck.isEmpty() && nums[deck.peekLast()]<n){
                deck.removeLast();
            }

            //add this index
            deck.addLast(i);

            //trim out of window values from the head
            //if current index is i, then window size is i-k,
            //any valur before i-k is wack.
            while(deck.peekFirst() <= i - k){
                deck.removeFirst();
            }

            //capture result when i have reached k
            if(i>=k-1){
                int r = nums[deck.peekFirst()];
                res[idx++] = r;
            }

        }

        return res;
    }
}
