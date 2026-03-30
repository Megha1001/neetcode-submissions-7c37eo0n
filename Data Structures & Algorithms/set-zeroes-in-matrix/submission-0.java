class Solution {

    private int ROWS;
    private int COLS;
    public void setZeroes(int[][] matrix) {

        /*
        Maintain a row[] and col[] 1D matrix that will indicate which row and col should be zero
        1. Traverse the matrix 
            -> if matrix[i][j] == 0 => mark row[i] = true, col[j] = true
        2. traverse row[] matrix
            -> if row[i] == true ==> make the whole row true in original array
        3. traverse col[] matrix
            -> if col[i] == true ==> make the whole col true;
        */

        ROWS = matrix.length;
        COLS = matrix[0].length;

        boolean row[] = new boolean[ROWS];
        boolean col[] = new boolean[COLS];

        //populate row and column matrix
        populateRowAndColMatrix(matrix, row, col);

        //traverse row and make changes in matrix
        traverseRowAndChangeMatrix(matrix, row);

        //traverse col and make changes in matrix
        traverseColAndChangeMatrix(matrix, col);
        
    }

    public void populateRowAndColMatrix(int [][] matrix, boolean [] row, boolean [] col){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
    }

    public void traverseRowAndChangeMatrix(int [][] matrix, boolean [] row){
        for(int i = 0; i < ROWS; i++){
            if(row[i] == true){
                //make entire row as 0
                for(int col = 0; col < COLS; col++){
                    matrix[i][col] = 0;
                }
            }
        }
    }

    public void traverseColAndChangeMatrix(int [][] matrix, boolean [] col){
        for(int i = 0; i < COLS; i++){
            if(col[i] == true){
                //make entire col as 0
                for(int row = 0; row < ROWS; row++){
                    matrix[row][i] = 0;
                }
            }
        }
    }
}
