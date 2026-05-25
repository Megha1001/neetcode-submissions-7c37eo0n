class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        //Brute force 
        int n = gas.length;

        for(int i = 0; i < n; i++){
            if(gas[i] < cost[i]){
                continue;
            }

            int j = (i + 1) % n;
            int currentGas = gas[i] - cost[i] + gas[j];

            while(i != j){
                if(currentGas < cost[j]){
                    break;
                }

                int costForMovingFromCurrentJ = cost[j];
                j = (j + 1)%n;
                int gasEarnFromNextJ = gas[j];

                currentGas = currentGas - costForMovingFromCurrentJ + gasEarnFromNextJ;
            }

            if(i == j){
                return i;
            }
        }

        return -1;
        
    }
}
