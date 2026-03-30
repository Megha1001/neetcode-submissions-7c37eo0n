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
    public ListNode mergeKLists(ListNode[] lists) {
        //Use solution of merge two sortedList
        
        int n = lists.length;

        if(n == 0){
            return null;
        }

        return partitionAndMerge(0, n - 1, lists);
    }

    private ListNode partitionAndMerge(int s , int e , ListNode[] lists){
        if(s == e){
            return lists[s];
        }

        int mid = s + (e - s)/2;

        ListNode l1 = partitionAndMerge(s, mid, lists);
        ListNode l2 = partitionAndMerge(mid + 1, e, lists);

        return mergeTwoSortedList(l1, l2);
    }
    

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 != null ? l1 : l2;

        return head.next;
    }

}
