class Solution {
    //brute force using HashSet
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true){
            if(set.contains(n)){
                if(n == 1){
                    return true;
                }else{
                    return false;
                }
            }
            set.add(n);
            n = findSqrOfEachNum(n);
        }
    }

    private int findSqrOfEachNum(int n){
        int sum = 0;
        while(n != 0){
            sum += ((n%10) * (n%10));
            n /= 10;
        }
        return sum;
    }


}
