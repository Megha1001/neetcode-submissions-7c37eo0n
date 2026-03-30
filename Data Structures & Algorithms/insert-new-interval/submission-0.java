class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int [][] res = new int[n+1][];
        //find the position
        int idx = n; //if need to insert at last
        for(int i=0; i<n; i++){
            if(intervals[i][0] >= newInterval[0]){
                idx = i;
                break;
            }
            res[i] = intervals[i];
        }

        res[idx] = newInterval;

        for(int i=idx; i<n; i++){
            res[i+1] = intervals[i];
        }

        //merging overlapping intervals
        idx = 0;
        for(int i=0; i<res.length; i++){
            if(res[idx][1] >= res[i][0]){
                //merge
                res[idx][0]= Math.min(res[idx][0], res[i][0]);
                res[idx][1]= Math.max(res[idx][1], res[i][1]);
            }else{
                ++idx;
                res[idx] = res[i];
            }
        }

        return Arrays.copyOf(res, idx+1);
        
        
    }
}
