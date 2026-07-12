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
    //proof at the bottom
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


/*
    Floyd's Cycle Detection Algorithm (Linked List Cycle II)

    Example:

        1 -> 2 -> 3
             ^    |
             |____|

    The cycle starts at node 2.

    Let's define:

        a = distance from head to cycle start
        b = distance from cycle start to meeting point
        c = distance from meeting point back to cycle start
        L = cycle length = b + c


    In this example:

        head = 1
        cycle start = 2
        meeting point = 3

        a = 1
        b = 1 (2 -> 3)
        c = 1 (3 -> 2)

        L = b + c = 2


    STEP 1: Find the meeting point using slow and fast pointers

    slow moves 1 step:
        1 -> 2

    fast moves 2 steps:
        1 -> 3

    slow and fast are not equal yet.

    Next iteration:

    slow:
        2 -> 3

    fast:
        3 -> 3 (because it loops back)

    They meet at node 3.


    STEP 2: Why does resetting one pointer to head find the cycle start?

    At the meeting point:

        slow distance = a + b

    In this example:

        slow distance = 1 + 1 = 2


    fast travels twice as far:

        fast distance = 2(a + b)

    Since fast is inside the cycle, the extra distance it traveled
    compared to slow must be some number of complete cycles.

        2(a + b) = a + b + kL

    Remove a + b from both sides:

        a + b = kL


    Rearrange:

        a = kL - b

    Since:

        L = b + c

    Substitute:

        a = k(b + c) - b

        a = (k - 1)(b + c) + c

        a = (k - 1)L + c


    Meaning:

        Distance from head to cycle start (a)
        equals:
            some complete cycles + distance from meeting point to cycle start.


    For our example:

        a = 1
        L = 2
        c = 1

        a = (k - 1)L + c

        1 = (1 - 1) * 2 + 1
        1 = 1


    Now we create two pointers:

        slow1 = head (node 1)
        slow2 = meeting point (node 3)


    Move both one step at a time:

        slow1:
            1 -> 2

        slow2:
            3 -> 2


    They meet at node 2, which is the start of the cycle.


    Why does this always work?

    slow1 needs exactly "a" steps to reach the cycle start.

    slow2 needs:
        (k - 1) full loops + c steps

    Full loops do not change its position, so after those loops,
    the remaining c steps take slow2 from the meeting point to the
    cycle start.

    Therefore both pointers arrive at the cycle start at the same time.
*/
