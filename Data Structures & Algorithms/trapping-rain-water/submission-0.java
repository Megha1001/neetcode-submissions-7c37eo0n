class Solution {
    public int trap(int[] height) {
        /*
        IDEA : 
        Maintains two array
        -> lMax keep track of max seen so far from left
        -> rMax keep track of max seen so far from right
        -> iterate over the height array
            -> res = res + Math.min(lmax[i], rMax[i]) - height[i]
        */

        int n = height.length;
        int []lMax = new int[n];
        int []rMax = new int[n];

        lMax[0] = height[0];
        for(int i=1; i<n; i++){
            lMax[i] = Math.max(height[i], lMax[i-1]);
        }

        rMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            rMax[i] = Math.max(height[i], rMax[i+1]);
        }

        int res = 0;

        for(int i = 0; i < n; i++){
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return res;
        
    }
}
