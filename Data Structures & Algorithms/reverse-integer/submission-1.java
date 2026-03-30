class Solution {
    public int reverse(int x) {

        int res = 0;
        
        while(x != 0){
            int digit = x%10;
            x = x/10;

            //overflow check
            /*
            later we are going to multiple res by 10.
            Hence, we are checking if res >  Integer.MAX_VALUE/10 then when we multiple it later it will overflow
            Similarly for digit it can happen -> the last digit for Integer.MAX_VALUE is 7
            */
            if(res > Integer.MAX_VALUE/10 ||
                res == Integer.MAX_VALUE/10 && digit > 7){
                return 0;
            }

            //check for underflow
            if(res < Integer.MIN_VALUE/10 ||
                res == Integer.MIN_VALUE/10 && digit < -8){
                return 0; 
            }

            //safe to multiple
            res = res * 10 + digit;

        }

        return res;
    }
}
