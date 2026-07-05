//TC : O(E logV);
//SC : O(V+E)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Dijkstra algo
        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();

        for(int i = 0; i <=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[]edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
        }

        int [] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dis[k] = 0;
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currTime = curr[0];
            int currNode = curr[1];

            if(currTime > dis[currNode]){
                continue;
            }

            for(int neig[] : adj.get(currNode)){
                int neigNode = neig[0];
                int neigDist = neig[1];

                if(currTime + neigDist < dis[neigNode]){
                    dis[neigNode] = currTime + neigDist;
                    pq.offer(new int[]{dis[neigNode], neigNode});
                }
            }
        }

        int res = 0;
        for(int i = 1; i <= n;  i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }

            res = Math.max(res, dis[i]);
        }

        return res;

    }
}
