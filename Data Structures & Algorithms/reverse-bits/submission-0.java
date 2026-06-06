class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for(int i = 0; i < 32; i++){
            int rightmost_bit = n & 1;
            ans = ans << 1; //make space for rightmost_bit to fit into ans
            ans = ans | rightmost_bit;
            n = n >>> 1; //signed shift
        }
        
        return ans;
    }
}
