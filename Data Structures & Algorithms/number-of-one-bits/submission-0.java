class Solution {
    public int hammingWeight(int n) {
        //Brain & Kerningham algorithm
        int res = 0;

        while(n!=0){
            ++res;
            n = n&(n-1);
        }

        return res;
    }
}
