//TC : O(nLogK)
//SC : O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Min head -> k largest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
        
    }
}
