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
    //watched video then implemented myself entirely
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }

        if(lists.length==1 && lists[0]==null){
            return null;
        }
        
        for(int i=1; i< lists.length; i++){
            ListNode resNode = mergeTwoLists(lists[i], lists[i-1]);

            System.out.println("resNode is - " + resNode.val);

            //put the resultant node in ith place in the array
            lists[i] = resNode;
        }

        return lists[lists.length-1];
    }

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
