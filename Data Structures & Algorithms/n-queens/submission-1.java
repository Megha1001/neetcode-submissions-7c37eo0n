class Solution {
    //Problem -> revised : Place n queen in n rows
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][]board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        backTrack(board, 0, res);
        return res;
    }

    private void backTrack(char[][]board, int row, List<List<String>>res){
        if(row == board.length){
            //found one solution
            List<String> copy = new ArrayList<>();

            for(char[] r : board){
                copy.add(new String(r));
            }

            res.add(copy);
            return;
        }

        //try to place queen in every column
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                backTrack(board, row+1, res);
                board[row][col] = '.';
            }
        }
    }


    private boolean isSafe(char[][]board, int row, int col){
        int n = board.length;
        //horizontal
        for(int c = 0; c < n; c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        //vertical
        for(int r = 0; r < n; r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }

        //left diagonal
        for(int r = row, c = col; r >=0 && c >=0; r--, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //right diagonal
        for(int r = row, c = col; r >=0 && c < n; r--, c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }
}
