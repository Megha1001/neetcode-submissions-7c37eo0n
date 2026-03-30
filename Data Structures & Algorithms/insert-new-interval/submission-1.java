class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        There can be three possibilities while traversing
        1. Completely different interval
            -> newInterval before current interval
            -> newInterval after current interval
        2. overlapping interval -> merge
        */

        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            //1. newInterval completely before
            if(newInterval[1] < interval[0]){
                res.add(newInterval);
                newInterval = interval;
            }
            //2. newInterval completely after
            else if(newInterval[0] > interval[1]){
                res.add(interval);
            }
            //overlap
            else{
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        res.add(newInterval);

        return res.toArray(new int[res.size()][]);
        
    }
}
