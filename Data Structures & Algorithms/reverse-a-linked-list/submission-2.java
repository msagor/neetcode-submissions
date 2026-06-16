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

    /*
    //tried myself did not work.
    public ListNode reverseList(ListNode head) {

        ListNode currHead = head;
        ListNode prevHead = null;

        while(currHead!=null){

            //get the next of head
            ListNode nextNode  = currHead.next;

            //point the next of nextNode to currHead
            if(nextNode!=null){
                nextNode.next = currHead;
                //this is wrong.
                //in this iteration only worry about currNode
                //do not do nextNode
                //nextNode will be handled in the next iteration.
            }

            //severe the next of currHead
            currHead.next = prevHead;

            //update prevHead
            prevHead = currHead;

            currHead = nextNode;
        }

        return prevHead;
    }*/

    public ListNode reverseList(ListNode head) {

        ListNode currHead = head;
        ListNode prevHead = null;

        while (currHead != null) {

            ListNode nextNode = currHead.next; // save next
            currHead.next = prevHead;          // reverse link
            prevHead = currHead;               // move prev
            currHead = nextNode;               // move curr
        }

        return prevHead;
    }

}
