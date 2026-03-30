class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //topological sort -> if possible then we can finish otherwise not

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]); // 1 -> 0
        }

        int [] indegree = new int[numCourses];
        
        //calculate indegree
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                ++indegree[adj.get(i).get(j)];
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ++count;
            for(int u : adj.get(curr)){
                --indegree[u];
                if(indegree[u] == 0){
                    q.offer(u);
                }
            }
        }

        return count == numCourses;
    }
}
