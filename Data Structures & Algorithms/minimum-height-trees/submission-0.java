/*
Easy intuition: “Best root is the middle”
If you stand at the middle of the tree, the farthest places are closer.
If you stand at an end/leaf, the farthest place is very far.

So the best root(s) must be the center of the tree.

And a tree can have:

1 center (like odd-length chain: 0-1-2-3-4 center is 2)
or 2 centers (even-length chain: 0-1-2-3 centers are 1 and 2)
It can’t have 3 centers.
How to find the center without “guessing”?
Here’s the onion trick:

Step A: Find all leaves
Leaves are nodes with degree 1 (only one neighbor).

Step B: Remove all leaves together
If leaves can’t be the center (they’re at the edge), delete them.
After removing them, some nodes become new leaves.

Step C: Repeat
Keep removing “outer layers”.

Eventually, you’ll be left with:

1 node → that’s the center
or 2 nodes → those are the centers
Those remaining nodes are exactly the answers (minimum height roots).
*/

//TC : O(N)
//SC : O(N)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return List.of(0);
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){ //O(N)
            adj.add(new ArrayList<>());
        }

        int deg[] = new int[n];
        for(int e[] : edges){ //O(E) = O(N-1) as we have edges in tree = N-1
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            ++deg[u];
            ++deg[v];
        }
        
        Deque<Integer> q = new ArrayDeque<>(); //SC : O(N)
        //get the nodes with degree  = 1;
        for(int i = 0; i < n; i++){ //O(N)
            if(deg[i] == 1){
                q.offer(i);
            }
        }

        int remaining = n;
        while(remaining > 2){
            int size = q.size();
            remaining -= size;
            for(int i = 0; i < size; i++){
                int leaf = q.poll();

                for(int neighbor : adj.get(leaf)){
                    if(--deg[neighbor] == 1){ //new leaf
                        q.offer(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(q);


    }
}