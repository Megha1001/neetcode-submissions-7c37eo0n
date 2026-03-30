class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] < 9){
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        //reach here -> means all are 9's
        int res[] = new int[digits.length + 1];
        res[0] = 1; //all others would be 9 and after adding 1 becomes 0
        return res;
    }
}
