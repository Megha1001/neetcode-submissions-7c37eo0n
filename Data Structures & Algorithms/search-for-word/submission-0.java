class Solution {
    private int ROWS;
    private int COLS;
    private HashSet<Pair<Integer, Integer>> path = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][]board, String word, int row, int col, int i){
        if(i == word.length()){
            return true;
        }

        if(row < 0 || col < 0 
        || row >= ROWS || col >= COLS 
        || path.contains(new Pair<>(row,col)) 
        || board[row][col] != word.charAt(i)){
            return false;
        }

        //match

        path.add(new Pair<>(row, col));
        boolean res = dfs(board, word, row + 1, col, i+1)||
                      dfs(board, word, row - 1, col, i+1)||
                      dfs(board, word, row , col - 1, i+1)||
                      dfs(board, word, row, col + 1, i+1);

        path.remove(new Pair<>(row, col));
        return res;
    }
}
