class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);

        int [] res = new int[numCourses];
        int idx = 0;

        for (int i = 0 ; i < numCourses; i++){
            adj.add(i, new ArrayList<>());
        }

        for(int i = 0 ; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]); // 1 -> 0
        }

        //Kahn's algorithm

        int [] indegree = new int[numCourses];
        populateIndegreeArray(indegree, adj);


        //populate Queue with vertex having indegree = 0

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        //keep track of elements popped/visited
        int count = 0;

        while(!q.isEmpty()){
            int p = q.poll();
            res[idx++] = p;

            ++count;

            //check adj
            for(int u : adj.get(p)){
                //since p is popped the degree of adjacent decrease by 1
                --indegree[u];
                if(indegree[u] == 0){
                    q.offer(u);
                }
            }
        }

        return count == numCourses ? res : new int[]{};


    }

    public void populateIndegreeArray(int [] indegree, ArrayList<ArrayList<Integer>>adj){
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                ++indegree[adj.get(i).get(j)];
            }
        }
    }
}
