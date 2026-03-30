class Solution {
    public int maxArea(int[] heights) {

        //brute force
        int res = 0;
        int n = heights.length;

        for(int i=0; i<n; i++){
            int currMax = 0;
            for(int j=i+1; j<n; j++){
                currMax = Math.max(currMax, (j-i)*Math.min(heights[i], heights[j]));
            }
            res = Math.max(res, currMax);
        }

        return res;
        
    }
}
