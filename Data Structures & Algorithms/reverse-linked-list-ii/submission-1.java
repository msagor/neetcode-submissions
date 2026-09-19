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

//re-implemented myself twice, solution and code is mine exept bottom part
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode res = null;

        if(head==null || left == right){
            return head;
        }

        //variables for future use
        ListNode prev_origLeftNode = null;
        ListNode origLeftNode = null;
        ListNode origRightNode = null;
        ListNode next_origRightNode = null;

        //loop variables
        ListNode prevNode = null;
        ListNode currNode = head;
        int i = 1;

        //loop
        while(currNode!=null){
            if(i<left){

                //regular increment of node
                prevNode = currNode;
                currNode = currNode.next;
            }if(i==left){
                //we have reached the left node
                //keep a copy of the left node
                prev_origLeftNode = prevNode;
                origLeftNode = currNode;

                //reverse this link
                ListNode tempNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = tempNode;

            }else if(i>left && i<right){
                //reverse this link
                ListNode tempNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = tempNode;
            }else if(i==right){
                //we have reached the right node
                //keep a copy of the right node
                next_origRightNode = currNode.next;
                origRightNode = currNode;

                //still need to reverse this link
                currNode.next = prevNode;
                prevNode = currNode;

                break;
            }else if(i>right){
                //will never reacht this case
            }
            i++;
        }

        //this portion is from chatGPT
        //connect the node before original left
        //to the original right node
        if(prev_origLeftNode != null){
            prev_origLeftNode.next = origRightNode;
        }else{
            //left == 1, so original right becomes the new head
            head = origRightNode;
        }

        //connect the original left node
        //to the node after original right
        origLeftNode.next = next_origRightNode;

        return head;
    }
}