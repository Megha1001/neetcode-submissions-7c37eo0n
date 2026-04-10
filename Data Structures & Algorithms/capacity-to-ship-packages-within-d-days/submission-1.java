//TC : O(nLog(sum of weights)), SC : O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for(int w : weights){//O(N)
            l = Math.max(l, w);
            r += w;
        }

        int res = r;
        while(l <= r){ //O(log(sum))
            int m = l + (r - l)/2;
            if(canShip(weights, days, m)){
                res = Math.min(res, m);
                r = m-1;
            }else{
                l = m+1;
            }
        }

        return res; 
    }

    private boolean canShip(int []weights, int days, int cap){
        int ship = 1;
        int currCap = cap;
        for(int w : weights){//O(n)
            if(currCap - w < 0){
                ++ship;
                if(ship > days){
                    return false;
                }
                currCap = cap;
            }
            currCap -= w;
        }
        return true;
    }
}