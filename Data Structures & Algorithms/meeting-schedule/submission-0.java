/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        //Idea = there should not be any overlapping intervals
        Comparator<Interval> sortByStart = new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        };

        Collections.sort(intervals, sortByStart);

        int res = 0;
        int originalLength = intervals.size();
        for(int i=1; i<originalLength; i++){
            if(intervals.get(res).end > intervals.get(i).start){
                return false;
            }else {
                ++res;
            }
        }


        return true;



    }
}
