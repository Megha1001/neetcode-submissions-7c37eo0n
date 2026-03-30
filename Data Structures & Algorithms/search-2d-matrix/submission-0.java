class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int i=0; 
        int j = c-1;

        while(i<r && j>=0){
            int element = matrix[i][j];
            if(element == target){
                return true;
            }

            else if(element > target){
                --j;
            }else{
                ++i;
            }
        }

        return false;
    }
}
