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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //so they reversed the LL so that a number 321 is actually organized as 1 -> 2 -> 3 order
        //this is good so that they are bsically giving us access to the ones digits first,

        //variable to keep track of carry
        int carry = 0;

    
        ListNode resHead = null;
        int iteration = 0;
        ListNode head = null;

        //an empty dummy listnode
        ListNode dummy = new ListNode(0, null);

        while(l1!=null && l2!=null){
            
            System.out.println("iteration - " + iteration + " l1 - " + l1.val + " " + "l2 - " + l2.val + " " + "carry - " + carry);

            if(iteration==0){
                //init head for this iteration
                head = new ListNode();
                resHead=head;
                iteration++;
            }else{
                //move head forward
                head.next = new ListNode();
                head = head.next;
                iteration++;
            }

            //get sum
            int sum = l1.val + l2.val + carry;

            //check if sum is two digits
            if(Integer.toString(sum).length()==2){
                //sum is 10, 11, 12, 13, 14, 15, 16, 17 or 18
                //we take the ones digit and carry the tens digit
                //for example, for 18, we take 8, and carry 1
                head.val = Integer.parseInt(String.valueOf(Integer.toString(sum).charAt(1)));

                //assign carry
                carry = sum/10;
                System.out.println("carry - " + carry);
                //carry = Integer.parseInt(String.valueOf(Integer.toString(sum).charAt(0)));
            
            }else{
                //sum is 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
                head.val = Integer.parseInt(String.valueOf(Integer.toString(sum).charAt(0)));

                //reset carry
                carry = 0;
            }

            //reassign head to new node
            head.next = new ListNode();

            //move l1 and l2
            l1 = l1.next;
            l2 = l2.next;

            //check if any of the LL is now null aka reached the end
            if(l1==null && l2!=null){
                l1 = dummy;
            }else if(l1!=null && l2==null){
                l2 = dummy;
            }else if(l1==null && l2==null){
                //check if carry has value
                if(carry!=0){
                    head.next = new ListNode();
                    head = head.next;
                    head.val = carry;
                    System.out.println("came here 1");
                }else{
                    head.next = null;
                }
                break;
            }

        }

        return resHead;
        
    }

}
