class Solution {
    public int findDuplicate(int[] nums) {
        //this is a LL problem in disguide
        //this is literally the Linked List Cycle II problem
        //wacthed the NeetCode video and implementation from there
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        //coming here means slow == fast
        //get another slow pointer
        int slow2 = 0;
        do{
            slow = nums[slow];
            slow2 = nums[slow2];
        }while(slow!=slow2);

        return slow2;
    }
}
