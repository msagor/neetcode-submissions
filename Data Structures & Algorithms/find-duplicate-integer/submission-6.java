class Solution {
    
    //this is a LL problem in disguide
    //this is literally the Linked List Cycle II problem
    //wacthed the NeetCode video and implementation from there
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        //coming here means slow = fast
        //get another slow pointer
        int sslow = 0;

        do{
            slow = nums[slow];
            sslow = nums[sslow];
        }while(slow!=sslow);

        //coming here means slow = sslow
        return slow;
        
    }
}
