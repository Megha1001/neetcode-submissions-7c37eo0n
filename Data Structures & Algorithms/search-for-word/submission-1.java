class Solution {
    private int row;
    private int col;
    private int wordLength;
    private int[][] directions  = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        wordLength = word.length();

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == word.charAt(0) && find(board, r, c, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][]board, int r, int c, String word, int idx){
        if(idx == wordLength){
            return true;
        }

        if(r < 0 || c < 0 || r >= row || c >= col || board[r][c] != word.charAt(idx)){
            return false;
        }

        //visited
        char temp = board[r][c];
        board[r][c] = '#';

        for(int[]dir : directions){
            int r_ = r + dir[0];
            int c_ = c + dir[1];

            if(find(board, r_, c_, word, idx + 1)){
                return true;
            }
        }
        board[r][c] = temp;
        return false;
    }
}
