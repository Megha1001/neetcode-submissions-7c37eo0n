class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the intervals
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        //merge overlapping intervals
        int idx = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[idx][1] >= intervals[i][0]){
                //found overlapping
                intervals[idx][0] = Math.min(intervals[idx][0], intervals[i][0]);
                intervals[idx][1] = Math.max(intervals[idx][1], intervals[i][1]);
            }else{
                //find one non overlapping interval
                ++idx;
                intervals[idx] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, idx+1);
        
    }
}
