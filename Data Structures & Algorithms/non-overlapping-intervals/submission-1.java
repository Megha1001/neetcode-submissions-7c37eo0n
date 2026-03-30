class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        //Greedy approach when two are overlap remove the one that end > overlapped interval since
        //if two interval overlapped then that ends after has possibility to overlap with others

        Arrays.sort(intervals, (a, b)-> Integer.compare(a[1], b[1]));

        int res = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start < prevEnd){ //overlap
                //overlap - retain where end is larger 
                ++res;
            }else{
                prevEnd = end;
            }
        }

        return res;

        
    }
}
