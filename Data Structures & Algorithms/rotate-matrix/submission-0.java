class Solution {

    private int ROWS;
    private int COLS;

    public void rotate(int[][] matrix) {

        /*
        Idea : 
        1. take the transpose
        2. Swap columns -> first with last , second with second last and so on
        */

        ROWS = matrix.length;
        COLS = matrix[0].length;

        if(ROWS==1 && COLS == 1){
            return;
        }

        transpose(matrix);
        swapColumns(matrix);
    }

    public void transpose(int [][] matrix){
        for(int i = 0; i < ROWS; i++){
            for(int j = i+1; j < COLS; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void swapColumns(int [][]matrix){
        for(int col = 0; col < COLS/2; col++){
            for(int row = 0; row< ROWS; row++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][COLS - 1 - col];
                matrix[row][COLS - 1 - col] = temp;
            }
        }
    }
}
