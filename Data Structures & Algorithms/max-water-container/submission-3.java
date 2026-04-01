class Solution {
    public int maxArea(int[] heights) {
        //Two pointer
        // when we get height[l] < height[r] move l since if we move right then area will decrease but if we move l there
        //can be the possibility of larger area

        int l = 0;
        int r = heights.length - 1;
        int area = Integer.MIN_VALUE;
        while(l < r){
            area = Math.max(area, (r - l) * Math.min(heights[l], heights[r]));

            if(heights[l] <= heights[r]){
                ++l;
            }else{
                --r;
            }
        }

        return area;
        
    }
}
