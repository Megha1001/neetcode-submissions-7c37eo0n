class Solution {
    //brute force using HashSet
    public boolean isHappy(int n) {
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
