class Solution {
    public double myPow(double x, int n) {

        if(n == 0){
            return 1.0;
        }

        
        double res = x;
        int count = 1;
        if(n >= 0){
            while(count < n){
                ++count;
                res = res * x;
            }
        }else{
            while(count > n){
                --count;
                res = res / x;
            }
        }
        

        return res;
        
    }
}
