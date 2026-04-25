// TC : O(N)
// SC : O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Monotonic stack from R to L -> decreasing
        int n = temperatures.length;
        int res [] = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            res[i] = !st.isEmpty() ? st.peek() - i : 0;
            st.push(i);
        }

        return res;
        
    }
}
