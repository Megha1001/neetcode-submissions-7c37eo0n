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
    public ListNode reverseKGroup(ListNode head, int k) {
        //1. check if we have k nodes

        int cnt = 0;
        ListNode temp = head;

        while(cnt < k){
            if(temp == null){
                return head;
            }
            temp = temp.next;
            ++cnt;
        }

        // recursively call for rest
        ListNode prev = reverseKGroup(temp, k);

        //reverse current group
        temp = head;
        cnt = 0;

        while(cnt < k){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            ++cnt;
        }

        return prev;
    }
}
