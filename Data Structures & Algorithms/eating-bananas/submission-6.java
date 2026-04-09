// TC : O(logN), SC : O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = -1;

        while(low <= high){ // O(logN)
            int m = low + (high - low)/2;
            
            int totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil((double)(pile)/m);
            }

            if(totalTime <= h){
                res = m;
                high = m - 1;
            }else{
                low = m + 1;
            }
        }

        return res;
        
    }
}
