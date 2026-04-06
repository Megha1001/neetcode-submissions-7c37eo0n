class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        --> New interval can be
            -> completely before
            -> completely after
            -> overlapping
        */

        List<int[]> res = new ArrayList<>(); // SC : O(N)

        for(int[] interval : intervals){ //O(N)
            //after
            if(newInterval[0] > interval[1]){
                res.add(interval);
            }
            //before
            else if(newInterval[1] < interval[0]){
                res.add(newInterval);
                newInterval = interval;
            }
            //overlap
            else{
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        res.add(newInterval);

        return res.toArray(new int[res.size()][]);
        
    }
}
