class Solution {
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i , boolean buying, int[]prices){
        if(i >= prices.length){
            return 0;
        }

        int cooldown = dfs(i+1, buying, prices);
        if(buying){
            int buy = dfs(i+1, false, prices) - prices[i]; //we cant buy if we buy at curr index
            return Math.max(cooldown, buy);
        }else{
            int sell = dfs(i+2, true, prices) + prices[i]; //if we sell now the next time we can buy is on i+2
            return Math.max(cooldown, sell);
        }
    }
}
