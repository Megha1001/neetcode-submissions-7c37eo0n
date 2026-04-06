class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        Logic : Two intervals overlap when
            [a0,a1] [b0, b1] -> sorted
            if(a1 <= b0)
        */

        int idx = 0;

        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));

        for(int i = 1; i < intervals.length; i++){
            if(intervals[idx][1] >= intervals[i][0]){
                intervals[idx][0] = Math.min(intervals[idx][0], intervals[i][0]);
                intervals[idx][1] = Math.max(intervals[idx][1], intervals[i][1]);
            }else{
                ++idx;
                intervals[idx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, idx+1);
        
    }
}
