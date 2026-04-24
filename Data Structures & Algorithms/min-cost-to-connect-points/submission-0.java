class Solution {
    public int minCostConnectPoints(int[][] points) {

        //Create adjacency and apply prims

        int V = points.length;
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int j = i+1; j < V; j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, distance});
                adj.get(j).add(new int[]{i, distance});
            }
        }

        return prims(adj, V);
    }

    private int prims(List<List<int[]>>adj, int V){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,0}); //weight, node
        boolean [] isMST = new boolean[V];
        int sum = 0;
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];
            if(isMST[node]) continue;
            isMST[node] = true;
            sum += wt;

            for(int []e : adj.get(node)){
                int nei = e[0];
                int neiWt = e[1];

                if(!isMST[nei]) pq.offer(new int[]{neiWt, nei});
            }
        }

        return sum;
    }
}
