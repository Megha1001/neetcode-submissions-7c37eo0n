class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }

        //Binary search
        int l = 0;
        int h = x;
        int res = 0;
        while(l <= h){
            int m = l + (h - l)/2;
            if(m <= x/m){ //protect overflow
                res = m;
                l = m + 1; //try bigger
            }else{
                h = m - 1;
            }
        }

        return res;
        
    }
}