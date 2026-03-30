class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //Binary search
        int low = 0;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = -1;

        while(low <= high){
            int k = low + (high-low)/2;

            //check for speed k
            int totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil((double)(pile)/k);
            }

            if(totalTime <= h){
                res = k;
                high = k-1;
            }else{
                low = k+1;
            }
        }

        return res;

        
    }
}
