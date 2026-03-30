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

        /*
        IDEA : if we have two intervals (increasing order of start time) -> I1, I2
            then I1.end <= I2.start
        */

        Collections.sort(intervals, Comparator.comparingInt(i->i.start));
        
        for(int i = 1; i < intervals.size(); i++){
            Interval I1 = intervals.get(i-1);
            Interval I2 = intervals.get(i);

            if(I1.end > I2.start){
                return false;
            }
        }

        return true;

    }
}
