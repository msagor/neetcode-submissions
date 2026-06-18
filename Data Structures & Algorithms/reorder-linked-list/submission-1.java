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
    public void reorderList(ListNode head) {

        if(head.next == null){
            return;
        }

        //first we need to to find the middle of the LL
        ListNode slow = head;
        ListNode fast = head;
        ListNode middle = null;
        ListNode prev_of_middle = null;


        while(fast.next!=null && fast.next.next!=null){
            prev_of_middle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //check if fast.next is not null but fast.next.next is null
        //in that case LL is even number and slow need to point to the second middle
        if(fast.next!=null && fast.next.next==null){
            middle =  slow.next;
            prev_of_middle = slow;
        }else if(fast.next==null){
            middle = slow;
            prev_of_middle = prev_of_middle;
        }

        //System.out.println("middle is - " + middle.val);
        //System.out.println("prev_of_middle is - " + prev_of_middle.val);

        //severe the connection from left part of LL to the right part of LL
        prev_of_middle.next = null;

        //second we need to reverse the right part of the LL
        ListNode currNode = middle;
        ListNode prevNode = null;

        while(currNode != null){

            //get the next node
            ListNode nextNode = currNode.next;

            //point currNode.next back to prevNode
            currNode.next = prevNode;

            //increment prevNode
            prevNode = currNode;

            //increment currNode
            currNode = nextNode;
        }

        
        //third merge two linked lists
        ListNode l1 = head;
        ListNode l2 = prevNode;

        //System.out.println("l1 is - " + l1.val);
        //System.out.println("l2 is - " + l2.val);

        

        /*
        ListNode temp1 = l1;
        while(temp1!=null){
            System.out.print(temp1.val + " -> ");
            temp1 = temp1.next;
        }
        System.out.println();

        ListNode temp2 = l2;
        while(temp2!=null){
            System.out.print(temp2.val + " -> ");
            temp2 = temp2.next;   
        }
        */
        

        //resultant node
        currNode = l1;

        boolean l1_turn = true;
        while(l1!=null && l2!=null){
            if(l1_turn){
                ListNode l1_next = l1.next;
                currNode.next = l2;
                l1 = l1_next;
                currNode = l2;
                l1_turn=false;
            }else{
                ListNode l2_next = l2.next;
                currNode.next = l1;
                l2 = l2_next;
                currNode = l1;
                l1_turn=true;
            }
        }
    }
}
