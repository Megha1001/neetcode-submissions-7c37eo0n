class Solution {
    private int[][] directions = {
        {1,0}, //down
        {-1,0}, //up
        {0, 1}, //right
        {0, -1} //left
        };
    public int longestIncreasingPath(int[][] matrix) {

        //Brute Force
        /*
            Find maximum length for all the elements and then return max from that
                -> for every element go in all the direction and find max
        */

        int m = matrix.length;
        int n = matrix[0].length;
        int maxLength = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxLength = Math.max(maxLength, dfs(matrix, i, j));
            }
        }
        
        return maxLength;
    }

    private int dfs(int[][]matrix, int row, int col){
        int m = matrix.length;
        int n = matrix[0].length;

        int maxLength = 1; //consider itself

        for(int dir[] : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < m
                && newCol >= 0 && newCol < n
                && matrix[newRow][newCol] > matrix[row][col]){
                    int len = 1 + dfs(matrix, newRow, newCol);
                    maxLength = Math.max(maxLength, len);
                }
        }

        return maxLength;
    }
}
