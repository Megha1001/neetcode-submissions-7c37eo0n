class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int l [] = new int[n];
        int r [] = new int[n];
        int res = 0;

        Deque<Integer> st = new ArrayDeque<>();
        //for left nearest less
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            l[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            r[i] = st.isEmpty() ? n : st.peek(); // when right boundary not exists put n
            st.push(i); 
        }


        for(int i = 0; i < n; i++){
            int width = r[i] - l[i] - 1;
            int area = heights[i] * width;
            res = Math.max(area , res);
        }
        

        return res;
    }
}
