class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        LOGIC : If curr_gas becomes -ve at pi then none of the gas station from p0 to pi can be the solution
        Pi incicates the amount of gas need to reach P(i+1)
        Pn-1 indicates the amount of gas need to reach P0
        */
        
        int start = 0;
        int curr_gas = 0;
        int prev_gas = 0;
        int n = gas.length;

        for(int i=0; i<n; i++){
            curr_gas += gas[i] - cost[i];
            
            if(curr_gas < 0){
                start = i+1;
                prev_gas  += curr_gas;
                curr_gas = 0;
            }

        } 

        return (curr_gas + prev_gas) >=0 ? start : -1;

    }
}