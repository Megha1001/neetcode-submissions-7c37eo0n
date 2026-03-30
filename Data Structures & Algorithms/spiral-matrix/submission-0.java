class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int top = 0; //move in columns
        int right = COLS - 1; //move in rows
        int bottom = ROWS - 1; //move in columns
        int left = 0; //move in rows

        while(top <= bottom && left <= right){

            //first row
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            ++top;

            //last column
            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            --right;

            //last row
            //for single row -> if condition
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
            }
            
            --bottom;

            //first column
            //for single column -> if condition
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
            }
            ++left;
            
        }

        return res;
        
    }
}
