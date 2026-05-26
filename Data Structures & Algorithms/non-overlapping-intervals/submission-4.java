//TC : O(NlogN)
//SC : O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(prevEnd > intervals[i][0]){
                ++count;
                //keep prevEnd;
            }else{
                prevEnd = intervals[i][1];
            }
        }

        return count;
        
    }
}
