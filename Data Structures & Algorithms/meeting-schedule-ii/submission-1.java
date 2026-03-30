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

        // Solution -1 Using TreeMap
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(Interval interval : intervals){
            map.put(interval.start, map.getOrDefault(interval.start, 0)+1);
            map.put(interval.end, map.getOrDefault(interval.end, 0)-1);
        }

        int curr = 0;
        int res = 0;

        for(int value : map.values()){
            curr += value;
            res = Math.max(curr, res);
        }

        return res;
    }
}
