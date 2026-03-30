class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //IDEA : We can start from either top right or bottom left
        //If start from top right
        //      -> element == target return
        //      -> element > target -> decrease coloumn
        //      -> element < target -> increase row
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
