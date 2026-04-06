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
        // Approach - 1
        // TreeMap<Integer, Integer> map = new TreeMap<>();

        // for(int i = 0; i < intervals.size(); i++){
        //     map.put(intervals.get(i).start, map.getOrDefault(intervals.get(i).start, 0) + 1);
        //     map.put(intervals.get(i).end, map.getOrDefault(intervals.get(i).end, 0) - 1);
        // }

        // int count = 0, res = 0;
        // for(int val : map.values()){
        //     count += val;
        //     res = Math.max(count, res);
        // }

        // return res;

        //Approach - 2 : Two Pointers
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        
        int count = 0, res = 0, s = 0, e = 0;
        while(s < n){
            if(start[s] < end[e]){
                ++count;
                ++s;
            }else{
                --count;
                ++e;
            }
            res = Math.max(res, count);
        }

        return res;

    }
}
