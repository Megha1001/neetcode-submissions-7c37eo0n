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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //no need to check null as we have atleast one node
        int len = calLength(head);
        int target = len-n;

        //Case-1 Head will change
        if(target==0){
            return head.next;
        }

        //Case-2 Head wont change
        ListNode curr = head;
        int count = 1;

        while(count != target){
            ++count;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;

    }

    public int calLength(ListNode head){
        //no need to check null as we have atleast one node
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            ++count;
            curr= curr.next;
        }

        return count;
    }
}
