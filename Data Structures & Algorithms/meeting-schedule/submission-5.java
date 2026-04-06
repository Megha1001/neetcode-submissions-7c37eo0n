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
//TC : O(NlogN), SC : O(1)
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        /*
        To attend the meeting intervals shouldnot overlap
        */
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));//O(NlogN)
        for(int i = 1; i < intervals.size(); i++){ //O(N)
            if(intervals.get(i-1).end > intervals.get(i).start){
                return false;
            }
        }

        return true;

    }
}
