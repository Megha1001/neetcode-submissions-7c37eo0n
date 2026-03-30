class Solution {
    public int missingNumber(int[] nums) {
        int res = -1;
        //with  extra space
        int [] temp = new int[1000]; //1 <= nums.length <= 1000
        for(int i : nums){
            ++temp[i];
        }

        for(int i=0; i<1000; i++){
            if(temp[i]==0){
                res = i;
                break;
            }
        }

        return res;
        
    }
}
