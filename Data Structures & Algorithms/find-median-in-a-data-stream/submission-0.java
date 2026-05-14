class MedianFinder {
    //maxheap -> for left half
    //minHeap -> for right half

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap =  new PriorityQueue<>(Collections.reverseOrder());
        minHeap =  new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        //rebalance
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
}

//TLE
// class MedianFinder {
//     List<Integer> list;

//     public MedianFinder() {
//         list = new ArrayList<>();
        
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//         Collections.sort(list);
//     }
    
//     public double findMedian() {
//         //even length
//         if(list.size () %2 == 0){
//             return (double)((list.get(list.size()/2) + list.get(list.size()/2 + 1)))/2;
//         }

//         return (double)list.get(list.size()/2);
        
//     }
// }