class Solution {
    //By Dynamic programming
    /*
    For Ex : {1,2,4,3}  = idx : 0,1,2,3
    //LIS[idx]
    LIS[3] = 1;
    LIS[2] = Max(1 , 1+LIS[3]-> second one is not allowed, bcoz 4 !< 3)
    LIS[1] = Max(1, 1 + LIS[2], 1 + LIS[3] = 1, 1+1, 1+1 ) = 2
    LIS[0] = Max(1, 1 + LIS[1], 1 + LIS[2], 1 + LIS[3] = 1, 1+2, 1+1 ) = 3
    */
    public int lengthOfLISUsingDP(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int n = nums.length;
        int LIS[] = new int[n];
        Arrays.fill(LIS, 1); // for every single element LIS is 1

        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(nums[i] < nums[j]){
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
        
    }

    //using binary search
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }

        ArrayList<Integer> list = new ArrayList<>();

        list.add(nums[0]);

        for(int i = 1; i < n ;i++){
            if(nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int ceilIdx = findCeil(list, 0, list.size()-1, nums[i]);
                list.set(ceilIdx, nums[i]);
            }
        }

        return list.size();
    }

    public int findCeil(ArrayList<Integer> list, int l, int r, int x){
        while(r > l){
            int m = l + (r-l)/2;
            if(list.get(m) >= x){
                r = m;
            }else{
                l = m+1;
            }
        }

        return r;
    }
}
