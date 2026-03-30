class Solution {

    public static int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean [][] pac = new boolean[ROWS][COLS];
        boolean [][] atl = new boolean[ROWS][COLS];

        //for first row and last row
        for(int c = 0 ; c < COLS; c++){
            dfs(0, c, pac, heights);
            dfs(ROWS-1, c, atl, heights);
        }

        //for first and last column
        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights);
            dfs(r, COLS-1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        //get common
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
        
    }

    public void dfs(int r, int c, boolean[][]oceans, int [][]heights){
        oceans[r][c] = true; //visited;
        for(int[] dir : directions){
            int row = r + dir[0];
            int col = c + dir[1];

            if(row >= 0 && row < heights.length
            && col >= 0 && col < heights[0].length
            && !oceans[row][col]&& heights[row][col] >= heights[r][c]){//last condition is imp that is reverse of original as we are trying to check what all can go to pacific/atlantic ocean
                dfs(row, col, oceans, heights);
            }
        }
    }
}
