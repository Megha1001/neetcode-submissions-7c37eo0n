class Solution {
    public int[] countBits(int n) {
        //for every number apply brain & kerningham algorithm
        int[]res = new int[n+1];

        for(int i=0; i<=n; i++){
            int count=0;
            int temp = i;
            while(temp!=0){
                ++count;
                temp = temp & (temp-1);
            }
            res[i] = count; 
        }
        return res;
    }
}
