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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode resHead = null;
        ListNode resTail = null;

        ListNode head_1 = list1;
        ListNode head_2 = list2;

        while(head_1 != null && head_2 != null){
            if(head_1.val > head_2.val){
                ListNode newNode = new ListNode(head_2.val);
                if(resTail == null){
                    resHead = newNode;
                    resTail = newNode;
                }else{
                    resTail.next = newNode;
                    resTail = newNode;
                }
                head_2 = head_2.next;
            }

            else { //head_1.val < head_2.val
                ListNode newNode = new ListNode(head_1.val);
                if(resTail==null){
                    resHead = newNode;
                    resTail = newNode;
                }else{
                    resTail.next = newNode;
                    resTail = newNode;
                }
                head_1 = head_1.next;
            }
        }

        while(head_1!=null){
            ListNode newNode = new ListNode(head_1.val);
            if(resTail==null){
                    resHead = newNode;
                    resTail = newNode;
                }else{
                    resTail.next = newNode;
                    resTail = newNode;
                }
            head_1 = head_1.next;
        }

        while(head_2!=null){
            ListNode newNode = new ListNode(head_2.val);
            if(resTail == null){
                resHead = newNode;
                resTail = newNode;
            }else{
                resTail.next = newNode;
                resTail = newNode;
            }
            head_2 = head_2.next;
        }

        return resHead;
        
    }
}