class Solution {
    /*
    IDEA : Reverse thinking : Find all the areas except unsurrounded
        -> For first row and last row find 'o' and mark its as 'T' and apply dfs in all the directions
        -> For first column and last column find 'O' and mark it as 'T' and apply dfs in all the directions
        -> traverse each cell
            -> if 'O' update to 'X'
            -> if 'T' update to 'O'

    */

    private int ROWS;
    private int COLS;

    public static int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        //for first and last row
        for(int c = 0; c < COLS; c++){
            //first row
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }

            //last row
            if(board[ROWS-1][c] == 'O'){
                dfs(board, ROWS - 1, c);
            }
        }

        //for first and last column
        for(int r = 0; r < ROWS; r++){
            //first column
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }

            //last column
            if(board[r][COLS - 1] == 'O'){
                dfs(board, r, COLS - 1);
            }
        }


        //update O -> X and T -> O
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                //order important
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }

                if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void dfs(char [][] board, int r, int c){

        //check bounds
        if(r < 0 || c < 0 || r > ROWS-1 || c > COLS-1 || board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';
        //dfs in all four directions
        for(int [] dir : directions){
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}
