class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //build max heap
        for(int s : stones){
            minHeap.offer(-s); //store -ve
        }

        while(minHeap.size() > 1){
            int first = minHeap.poll();
            int second = minHeap.poll();

            if(first != second){ // second > first. there can never be condition when first > second since its min heap
                minHeap.offer(first-second);
            }
        }

        minHeap.offer(0);//when all stones are smashed we need to return 0;
        return Math.abs(minHeap.peek()); // remove minus sign
        
    }
}
