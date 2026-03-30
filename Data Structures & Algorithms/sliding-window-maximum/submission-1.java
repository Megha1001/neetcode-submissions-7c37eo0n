class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int output[] =  new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();

        int l = 0;
        int r = 0;

        while(r < n){
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }

            q.addLast(r);

            if(l > q.getFirst()){
                q.removeFirst();
            }

            if((r+1) >= k){
                output[l] = nums[q.getFirst()];
                ++l;
            }
            
            ++r;
        }

        return output;
    }

    //TLE
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int res [] = new int[n - k+1];

        for(int i = 0; i < n - k+1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                max = Math.max(nums[j], max);
            }
            res[i] = max;
        }

        return res;
        
    }
}
