class Solution {
    public int maxProfit(int[] prices) {

        //Brute force
        /*int res = 0;
        int n = prices.length;
        for(int i=0; i<n; i++){
            int currMax = 0;
            for(int j=i+1; j<n; j++){
                currMax = Math.max(currMax, prices[j]-prices[i]);
            }
            res = Math.max(res, currMax);
        }

        return res;
        */

        //Two Pointer
        int buyDay = 0;
        int sellDay = 1;
        int maxProfit = 0;

        while(sellDay < prices.length){
            if(prices[buyDay] < prices[sellDay]){
                maxProfit = Math.max(maxProfit, prices[sellDay] - prices[buyDay]);
            }else if(prices[buyDay] > prices[sellDay]){
                buyDay = sellDay;
            }
            ++sellDay;
        }

        return maxProfit;
        
    }
}
