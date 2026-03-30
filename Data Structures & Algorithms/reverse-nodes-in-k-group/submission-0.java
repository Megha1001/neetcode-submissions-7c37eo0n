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
        //check if K nodes exists
        // recursively rest of LL
        // reverse the current group

        int count = 0;
        ListNode temp = head;

        //check if K nodes exists
        while(count < k){
            if(temp == null){
                return head;
            }
            temp = temp.next;
            ++count;
        }

        //temp points to k+1 node

        // recursively rest of LL
        ListNode prevNode = reverseKGroup(temp, k);

        // reverse the current group
        temp = head;
        count = 0;

        while(count < k){
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            ++count;
        }

        return prevNode;
        
    }
}
