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

        /*
        1. Find middle of LL (Slow and fast approach)
        2. Reverse second half
        3. Merge two LL
        */

        //1. find middle of LL
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        //reverse
        ListNode prev = null;
        ListNode second = slow.next; // save head of second half
        slow.next = null;            // detach first half

        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }


        //3. Merge two LL
        ListNode first = head;
        second = prev; //head of reverse LL

        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        
    }
}
