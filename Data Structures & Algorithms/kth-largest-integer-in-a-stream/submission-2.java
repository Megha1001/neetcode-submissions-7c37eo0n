class KthLargest {

    /*
    To maintain the kth largest we will use minHeap of size k.
    kth largest element is available at root
    */

    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for(int num : nums){
            this.minHeap.offer(num);
            if(minHeap.size()>k){
                this.minHeap.poll();
            }
        }
        
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>k){ //no need of while as we are having k element when we are doing add -  returns the kth largest integer in the stream.
            minHeap.poll();
        }
        return minHeap.peek(); //kth largest
    }
}
