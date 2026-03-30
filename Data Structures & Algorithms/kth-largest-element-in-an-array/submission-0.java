class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        Idea : To use minHeap that store the k largest elments and kth largest will be present at root
            -> Iterate through given nums array
                -> for every iteration
                    -> store the value in Heap
                    -> if size of heap > k
                        -> poll from heap -> this will poll smallest element and end up considering other value
                -> return top of heap
        */

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
