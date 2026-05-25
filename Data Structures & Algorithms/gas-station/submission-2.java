class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        //Brute force 
        // int n = gas.length;

        // for(int i = 0; i < n; i++){
        //     if(gas[i] < cost[i]){
        //         continue;
        //     }

        //     int j = (i + 1) % n;
        //     int currentGas = gas[i] - cost[i] + gas[j];

        //     while(i != j){
        //         if(currentGas < cost[j]){
        //             break;
        //         }

        //         int costForMovingFromCurrentJ = cost[j];
        //         j = (j + 1)%n;
        //         int gasEarnFromNextJ = gas[j];

        //         currentGas = currentGas - costForMovingFromCurrentJ + gasEarnFromNextJ;
        //     }

        //     if(i == j){
        //         return i;
        //     }
        // }

        // return -1;


        // Better Approach - Greedy

        int totalKarcha = 0;
        int totalKamai = 0;
        int n = gas.length;

        for(int i = 0; i < n; i++){
            totalKarcha += cost[i];
            totalKamai += gas[i];
        }

        if(totalKarcha > totalKamai){
            return -1;
        }

        //gurantee to have an answer
        int total = 0;
        int res = 0;

        for(int i = 0; i < n; i++){
            total = total + gas[i] - cost[i];

            if(total < 0){
                total = 0;
                res = i + 1;
            }
        }

        return res;
        
    }
}
