class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        for(int i=0; i<n; i++){
            int currMax = 0;
            for(int j=i+1; j<n; j++){
                currMax = Math.max(currMax, prices[j]-prices[i]);
            }
            res = Math.max(res, currMax);
        }

        return res;
        
    }
}
