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
    public int minMeetingRooms(List<Interval> intervals) {

        /*
         Same as maximum guest meeting
        */
        TreeMap<Integer, Integer> map = new TreeMap<>(); //arranged by time
        
        for(Interval interval : intervals){
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }

        int res = 0;
        int curr = 0;
        for(int val : map.values()){
            curr += val;
            res = Math.max(curr, res);
        }

        return res;

    }
}
