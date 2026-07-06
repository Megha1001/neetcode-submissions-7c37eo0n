class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        int[][]effort = new int[r][c];

        for(int i = 0; i < r; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0}); //effort, row, col
        effort[0][0] = 0;

        int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int currEffort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == r - 1 && col == c - 1){
                return currEffort;
            }
            
            if(currEffort > effort[row][col]){
                continue;
            }

            for(int dir[] : directions){
                int nr = dir[0] + row;
                int nc = dir[1] + col;

                if(nr < 0 || nc < 0 || nr >= r || nc >= c){
                    continue;
                }

                int edgeEffort = Math.abs(heights[nr][nc] -  heights[row][col]);
                int newEffort = Math.max(edgeEffort, currEffort);

                if(newEffort < effort[nr][nc]){
                    effort[nr][nc] = newEffort;
                    pq.offer(new int[]{newEffort, nr, nc});
                }
            }
        }

        return 0;
        
    }
}