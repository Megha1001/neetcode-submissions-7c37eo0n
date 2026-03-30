class Solution {
    public int maxArea(int[] heights) {

        //brute force -> TLE solution
        // int res = 0;
        // int n = heights.length;

        // for(int i=0; i<n; i++){
        //     int currMax = 0;
        //     for(int j=i+1; j<n; j++){
        //         currMax = Math.max(currMax, (j-i)*Math.min(heights[i], heights[j]));
        //     }
        //     res = Math.max(res, currMax);
        // }

        // return res;

        //Two Pointer approach
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while(l < r){
            int area = (r-l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, area);

            if(heights[l] <= heights[r]){
                ++l;
            }else{
                --r;
            }
        }

        return res;
        
    }
}
