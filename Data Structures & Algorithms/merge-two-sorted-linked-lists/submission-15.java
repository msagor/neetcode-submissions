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

    //works and implemented myself
    //in this one we check if any of LL ran out inside the while loop
    public ListNode mergeTwoLists_(ListNode l1, ListNode l2) {
        
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }


        //resultant node
        ListNode resHead = new ListNode(-1, null);

        ListNode currNode = resHead;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                currNode.next = l1;
                l1 = l1.next;
            }else{
                currNode.next = l2;
                l2 = l2.next;
            }
            
            currNode = currNode.next;

            //we need to check after each iteration whether any of LL has reached the end
            if(l1==null && l2!=null){
                //l2 has residual elements left
                currNode.next = l2;
            }else if(l1!=null && l2==null){
                //l1 has residual elements left
                currNode.next = l1;
            }
        }

        return resHead.next;
    }

    //works and implemented myself
    //in this one we check if any of LL ran out outside the while loop
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        ListNode resNode = new ListNode(-1, null);
        ListNode currNode = resNode;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                //l2 bigger so currNode next points ot l1
                currNode.next = l1;
                l1 = l1.next;
            }else{
                //l1 bigger so currNode next points ot l2
                currNode.next = l2;
                l2 = l2.next;
            }

            currNode = currNode.next;

        }

        //coming here means one or both LL has ran out of
        //we need to check if any of the LL has residual value left
        if(l1==null && l2!=null){
            //l2 has residual values left
            //we join currNode next to l2
            currNode.next = l2;
        }else if(l1!=null && l2==null){
            //l1 has residual values left
            //we join currNode next to l1
            currNode.next = l1;
        }

        return resNode.next;
    }
}