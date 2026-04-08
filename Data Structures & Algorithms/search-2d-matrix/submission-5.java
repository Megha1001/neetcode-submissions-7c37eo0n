//TC : O(log(M) + logN), SC : O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //IDEA : Every row is unique non overlapping . target will lie in single row
        /*
        1. Search correct row -> start <=target<=end 
            //if we search for individual row -> O(M) but we dont want that complexity. Hence, will apply BS -> ROWS
        2. Then search in that row using binary search
        */
        
        // //1. Find targeted row

        // int targetRow = -1;
        // int rows = matrix.length;
        // int cols = matrix[0].length;


        // //for rows
        // int l = 0;
        // int h = rows-1;

        // while(l <= h){ //O(log M)
        //     int m = l + (h - l)/2;

        //     //lies in middle row
        //     if(target <= matrix[m][cols-1] && target >= matrix[m][0]){
        //         targetRow = m;
        //         break;
        //     }
        //     //go down;
        //     else if(target > matrix[m][cols-1]){
        //         l = m + 1;
        //     }else{
        //         h = m - 1;
        //     }
        // }
        
        // if (targetRow == -1) return false;

        // //2. Find in column fixing targetRow

        // l = 0;
        // h = cols-1;

        // while(l <= h){ //O(logN)
        //    int m = l + (h - l)/2;

        //    if(matrix[targetRow][m] == target){
        //         return true;
        //    }
        //    else if(matrix[targetRow][m] > target){
        //         h = m - 1;
        //    }else{
        //         l = m + 1;
        //    }
        // }

        // return false;


        //Approach - 2 Flatterned BS
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int h = rows * cols - 1;

        while(l <= h){
            int m = l + (h - l)/2;

            int row = m / cols;
            int col = m % cols;

            int val = matrix[row][col];

            if(val == target){
                return true;
            }

            else if(val > target){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }

        return false;
        
    }
}
