//TC : O(numRows*numRows)
//SC : O(numRows*numRows)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //Idea : res[row][col] = res[row - 1][col - 1] + res[row - 1][col]
        //if col == 0 || col == row return 1;

        List<List<Integer>> res = new ArrayList<>();

        for(int row = 0; row < numRows; row ++){
            List<Integer> curr = new ArrayList<>();
            for(int col = 0; col <= row; col++){
                if(col == 0 || col == row){
                    curr.add(1);
                }else{
                    int val = res.get(row - 1).get(col - 1) + res.get(row - 1).get(col);
                    curr.add(val);
                }
            }

            res.add(curr);
        }
        
        return res;
    }
}