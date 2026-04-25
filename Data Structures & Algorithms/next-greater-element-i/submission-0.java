class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //Monotonic stack -> decreasing from R to L

        int n1 = nums1.length;
        int n2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(n2); //nums2 contains unique elements.
        Stack<Integer> st = new Stack<>();

        for(int i = n2 - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }

            map.put(nums2[i], st.isEmpty() ? -1 : st.peek());
            st.push(nums2[i]);
        }

        int res [] = new int[n1];
        for(int i = 0; i < n1; i++){
            res[i] = map.get(nums1[i]);
        }

        return res;

        
    }
}