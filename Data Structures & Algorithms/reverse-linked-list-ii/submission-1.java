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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode leftPrev = dummy;

        for(int i = 0 ; i < left - 1; i++){
            leftPrev = curr;
            curr = curr.next;
        }
        
        //curr points to left and leftPrev is just prev before left

        ListNode prev = null;
        for(int i = 0; i < right - left +1; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;

    }
}