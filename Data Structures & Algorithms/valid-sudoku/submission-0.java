class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValidRows(board)
        && isValidColumns(board)
        && isValidBox(board);
    }

    private boolean isValidRows(char[][]board){
        for(int row = 0; row < 9; row++){
            Set<Character> set = new HashSet<>();
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.')continue;
                if(set.contains(board[row][col])) return false;
                set.add(board[row][col]);
            }
        }
        return true;
    }

    private boolean isValidColumns(char[][]board){
        for(int col = 0; col < 9; col++){
            Set<Character> set = new HashSet<>();
            for(int row = 0; row < 9; row++){
                if(board[row][col] == '.')continue;
                if(set.contains(board[row][col])) return false;
                set.add(board[row][col]);
            }
        }
        return true;
    }

    private boolean isValidBox(char[][]board){
        for(int sr = 0; sr < 9 ; sr = sr + 3){
            int er = sr + 2;
            for(int sc = 0; sc < 9; sc = sc + 3){
                int ec = sc + 2;
                if(!traverse(board, sr, er, sc, ec)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean traverse(char[][]board, int sr, int er, int sc, int ec){
        Set<Character> set = new HashSet<>();
        for(int row = sr; row <= er; row++){
            for(int col = sc; col <= ec; col++){
                if(board[row][col] == '.')continue;
                if(set.contains(board[row][col])) return false;
                set.add(board[row][col]);
            }
        }
        return true;
    }
}
