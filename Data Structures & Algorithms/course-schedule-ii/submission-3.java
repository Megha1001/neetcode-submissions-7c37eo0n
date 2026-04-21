class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] res = new int[numCourses];
        int idx = 0;

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int e[] : prerequisites){
            adj.get(e[1]).add(e[0]);
        }

        int[]indegree = new int[numCourses];
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                ++indegree[adj.get(i).get(j)];
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }


        while(!q.isEmpty()){
            int curr = q.poll();
            res[idx++] = curr;
            for(int u : adj.get(curr)){
                --indegree[u];
                if(indegree[u] == 0){
                    q.offer(u);
                }
            }
        }

        return idx == numCourses ? res : new int[0];
        
    }
}
