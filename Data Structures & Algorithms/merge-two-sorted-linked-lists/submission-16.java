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

    // tried, didnt work, had to see solution
    //before this problem must do - https://neetcode.io/problems/merge-sorted-array/history?submissionIndex=1
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode res = new ListNode(-1);
        ListNode curr = res;

        while(list1!=null && list2!=null ){

            if(list1.val<list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;

            //coming here means one of the lists,
            //has reached the end
            if(list1 != null){
                curr.next = list1;
            }

            if(list2 != null){
                curr.next = list2;
            }

            
            
        }

        return res.next;
    }
}