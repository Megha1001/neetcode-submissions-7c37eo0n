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
    public void reorderList(ListNode head) {

        // 1-> 2 -> 3 -> 4 -> 5 ->6
        // first Middle = 3
        // 1-> 2 ->3
        // 6 -> 5 ->4


        /*
        Find the middle (first middle)
        Reverse second half
        Merge two linkedList
        */

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null; //detach end of first list
        ListNode curr = secondHead;
        ListNode prev = null;
        //reverse
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode firstHead = head;
        secondHead = prev;

        while(secondHead != null){
            ListNode temp1 = firstHead.next;
            ListNode temp2 = secondHead.next;
            
            firstHead.next = secondHead;
            secondHead.next = temp1;

            firstHead = temp1;
            secondHead = temp2;
            
        }

        
    }
}
