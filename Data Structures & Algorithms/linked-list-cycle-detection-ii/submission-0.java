/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //not in NeetCode, implemented myself in LeetCode
    //https://leetcode.com/problems/linked-list-cycle-ii/description/
    public ListNode detectCycle(ListNode head) {

        if(head==null || head.next==null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

       //tried, had tov use ai to fix
       // missed fast.next != null check
        boolean loop_exists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            //here we are comparing two objects
            if (fast == slow) {
                loop_exists = true;
                break;
            }
        }

        if(loop_exists){
            //get another slow pointer from the beginning
            ListNode slow1 = head;
        
            while(slow1!=slow){
                slow = slow.next;
                slow1 = slow1.next;
            }

            return slow1;
        }else{
            return null;
        }
    }
}
