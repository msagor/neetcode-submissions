/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    //my implementation, passes some test cases
    public ListNode removeNthFromEnd_(ListNode head, int n) {

        if(head.next==null && n==1){
            return null;
        }

        ListNode first = head;
        ListNode second = new ListNode(-1, null);

        //first increment the first pointer n times
        int i = 1;
        while(i<=n && first.next!=null){
            first = first.next;
            i++;
        }

        //second increment second pointer until first reaches the end
        boolean first_iteration = true;
        ListNode prev_of_second = null;
        while(first!=null){
            first = first.next;
            if(first_iteration){
                prev_of_second = null;
                second = head;
                first_iteration = false;
            }else{
                prev_of_second = second;
                second = second.next;
            }     
        }

        //we need to increment second and prev_of_second one more time
        //but before doing that we need to make a resNode
        //initially resNode points to head
        
        ListNode resNode = head;

        //but if prev_of_second is still null, that means it did not move forward,
        //because the head is the one being removed
        //that means second is pointing at the head
        if(prev_of_second==null){
            //since head is being removed we need to update resNode
            resNode = second.next;
        }else{

           second.next = second.next.next;

        }

        return resNode;
    }

    //chatgpt
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node handles head removal cleanly
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }
}
