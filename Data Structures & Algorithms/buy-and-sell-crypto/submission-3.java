class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n < 2){
            return 0;
        }

        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while(r < n){
            if(prices[l] > prices[r]){
                l = r;
            }

            else if(prices[l] < prices[r]){
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            }

            ++r;
        }
        return maxProfit;
    }
}
