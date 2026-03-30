class Solution {
    public double myPow(double x, int n) {

        //BRUTE FORCE
        // if(n == 0){ // any digit ^0 == 1
        //     return 1.0;
        // }

        
        // double res = x;
        // int count = 1;
        // if(n >= 0){
        //     while(count < n){
        //         ++count;
        //         res = res * x;
        //     }
        // }else{
        //     while(count > n){
        //         --count;
        //         res = res / x;
        //     }
        // }
        

        // return res;

        if (n == 0){
            return 1.0;
        }

        if(x==0){
            return 0;
        }

        double res = helper(x, Math.abs((long)n));
        return n>=0 ? res : 1/res;
    }

    private double helper(double x, long n){
        if(n==0){
            return 1.0;
        }
        double half = helper(x, n/2);
        return n%2 == 0 ? half*half : x * half * half;
    }
}
