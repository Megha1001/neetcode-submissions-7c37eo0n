//TC : O(logN)
/*
We process each digit of n
Number of digits ≈ log₁₀(n)

SC : O(1)
*/
class Solution {
    public boolean isHappy(int n) {
        //Linked List cycle detection
        int slow = n;
        int fast = n;

        //always end up in cycle either of 1 or else
        while(true){
            slow = sqrOfDigits(slow);
            fast = sqrOfDigits(sqrOfDigits(fast));
            if(slow == fast){
                break;
            }
        }

        return slow == 1;
        
    }

    private int sqrOfDigits(int n){
        int res = 0;
        while(n != 0){
            int digit = n%10;
            res += (digit * digit);
            n = n/10;
        }
        return res;
    }
}
