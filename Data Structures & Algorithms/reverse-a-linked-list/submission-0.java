
 /* // Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }*/
 

class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while(current!=null){

            //get nextNode
            nextNode = current.next;

            //update current.next
            current.next = prevNode;

            //update vars for next itertion
            prevNode = current;
            current = nextNode;
        }

        return prevNode;
    }
}
