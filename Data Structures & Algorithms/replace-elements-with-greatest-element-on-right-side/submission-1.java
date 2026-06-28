class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max_element[] = new int[n];
        max_element[n-1] = -1;
        for(int i = n - 2; i >= 0; i--){
            max_element[i] = Math.max(arr[i+1], max_element[i+1]);
        }
        return max_element;
        
    }
}