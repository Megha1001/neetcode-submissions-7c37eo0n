class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[]flight : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
        }

        int distance[] = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{src, 0});
        distance[src] = 0;
        int level = 0;
        while(!q.isEmpty() && level <= k){
            int size = q.size();
            for(int i = 0; i < size ; i++){
                int curr[] = q.poll();
                int u = curr[0];
                int d = curr[1];

                for(int[] neighbor : adj.getOrDefault(u, Collections.emptyList())){
                    int v = neighbor[0];
                    int cost = neighbor[1];

                    if(distance[v] > d + cost){
                        distance[v] = d + cost;
                        q.offer(new int[]{v, d + cost});
                    }
                }
            }
            ++level;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];

    }
}
