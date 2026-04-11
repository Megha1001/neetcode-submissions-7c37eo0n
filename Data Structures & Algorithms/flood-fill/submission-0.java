class Solution {
    private int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //DFS
        int original = image[sr][sc];

        if(original == color) return image;
        dfs(image, sr, sc, color, original);
        return image;
    }

    private void dfs(int[][]image, int r, int c, int color, int original){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != original){
            return;
        }

        image[r][c] = color;
        for(int dir[] : directions){
            dfs(image, r + dir[0], c + dir[1], color, original);
        }
    }
}