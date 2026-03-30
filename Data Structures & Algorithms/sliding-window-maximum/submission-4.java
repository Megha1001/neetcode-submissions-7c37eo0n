class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        //must be in curr_win and curr <= q elements

        //for first k elements
        for(int i = 0; i < k; i++){
            while(q.size() > 0 && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }

            q.offerLast(i);
        }

        //for rest of elements
        for(int i = k; i < n; i++){
            res[idx] = nums[q.peekFirst()];

            while(q.size() > 0 && q.peekFirst() < i - k + 1){
                q.pollFirst();
            }

            while(q.size() > 0 && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            ++idx;
            q.offerLast(i);
        }

        res[idx] = nums[q.peekFirst()];

        return res;
        
    }
}
