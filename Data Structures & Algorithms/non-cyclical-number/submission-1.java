class Solution {
    public boolean isHappy(int n) {

        //Brute Force
        // HashSet<Integer> set = new HashSet<>();

        // while(true){
        //     int res = 0;
        //     while(n != 0){
        //         res = res + (n%10)*(n%10);
        //         n = n/10;
        //     }
        //     if(res == 1){
        //         return true;
        //     }
        //     else if(set.contains(res)){
        //         return false;
        //     }
        //     set.add(res);
        //     n = res;
        // }

        //Use fast and slow pointer -> Cycle detection
        int slow = n;
        int fast = n;

        do{
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
        }while(slow != fast);

        slow = n;

        while(slow != fast){
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(fast);
        }

        return fast == 1;
    }

    public int sumOfSquareOfDigits(int n){
        int res = 0;
        while(n != 0){
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }
}
