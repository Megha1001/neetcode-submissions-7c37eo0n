class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    private Set<Integer> travelDays = new HashSet<>();
    private int[]costs;
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        for(int day : days){
            travelDays.add(day);
        }
        
        return dp(1);
    }

    private int dp(int day){
        if(day > 365){
            return 0;
        }
        
        if(memo.containsKey(day)){
            return memo.get(day);
        }

        int result;
        if(!travelDays.contains(day)){
            result = dp(day + 1);
        }else{
            int opt1 = costs[0] + dp(day + 1);
            int opt2 = costs[1] + dp(day + 7);
            int opt3 = costs[2] + dp(day + 30);
            result = Math.min(opt1, Math.min(opt2, opt3));
        }

        memo.put(day, result);
        return result;
    }
}