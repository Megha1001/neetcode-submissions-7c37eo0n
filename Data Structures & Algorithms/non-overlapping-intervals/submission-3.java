//TC : O(NLogN), SC : O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Greedy Approach : The interval that ends earliest gives you the maximum room for future intervals
        //sort by end
        int n = intervals.length;

        if(n==0){
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a->a[1])); //O(NlogN) //saves integer overflow
        int prevEnd = intervals[0][1];
        int count = 0;
        for(int i = 1; i < n; i++){ //O(N)
            if(intervals[i][0] < prevEnd){ // not = since[1,2] , [2,3] are non-overlapping
                ++count;
            }else{
                prevEnd = intervals[i][1];
            }
        }

        return count;

    }
}
