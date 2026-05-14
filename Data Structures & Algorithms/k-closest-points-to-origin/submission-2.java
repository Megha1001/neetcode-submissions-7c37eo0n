class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //min Heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        
        for(int [] point : points){
            minHeap.offer(point);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int res[][] = new int[k][2];
        int idx = 0;
        while(!minHeap.isEmpty()){
            res[idx ++] = minHeap.poll();
        }

        return res;

    }

    private int distance(int [] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
