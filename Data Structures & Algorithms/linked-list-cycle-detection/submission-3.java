/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

       //tried, had tov use ai to fix
       // missed fast.next != null check
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            //here we are comparing two objects
            if (fast == slow) {
                return true;
            }
        }

        return false; //fast reached null so no cycle
    }
}