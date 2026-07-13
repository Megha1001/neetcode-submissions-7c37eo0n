class Solution {
    public int minCostConnectPoints(int[][] points) {
        //MST
        int V = points.length;
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int j = i + 1; j < V; j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, distance});
                adj.get(j).add(new int[]{i, distance});
            }
        }
        
        return prims(adj, V);
    }

    private int prims(List<List<int[]>>adj,  int V){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); //wt, node;

        boolean isMST[] = new boolean[V];

        int sum = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int curr_dist = curr[0];
            int curr_node = curr[1];

            if(isMST[curr_node]) continue;
            isMST[curr_node] = true;
            sum += curr_dist;

            for(int neig[] : adj.get(curr_node)){
                int neig_node = neig[0];
                int neig_wt = neig[1];

                if(!isMST[neig_node]){
                    pq.offer(new int[]{neig_wt, neig_node});
                }
            }
        }

        return sum;
    }
}
