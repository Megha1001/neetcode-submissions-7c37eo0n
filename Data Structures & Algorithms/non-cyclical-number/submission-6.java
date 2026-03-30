class Solution {
    //using slow and fast pointers
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }while(slow != fast);

        return slow == 1;
    }

    private int  sumOfSquares(int n){
        int sum = 0;
        while(n != 0){
            int digit = n%10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    //brute force using HashSet
    public boolean isHappyUsingHashSet(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = findSqrOfEachNum(n);
        }

        return true;
    }

    private int findSqrOfEachNum(int n){
        int sum = 0;
        while(n != 0){
            int digit = n%10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }


}
