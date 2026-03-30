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
        // TreeMap<Integer, Integer> map = new TreeMap<>();

        // for(Interval interval : intervals){
        //     map.put(interval.start, map.getOrDefault(interval.start, 0)+1);
        //     map.put(interval.end, map.getOrDefault(interval.end, 0)-1);
        // }

        // int curr = 0;
        // int res = 0;

        // for(int value : map.values()){
        //     curr += value;
        //     res = Math.max(curr, res);
        // }

        // return res;

        //Solution -2 Two Pointer
        //Maintain two sorted start and end time array and compare

        // int n = intervals.size();
        // int start[] = new int[n];
        // int end[] = new int[n];

        // for(int i = 0; i < n; i++){
        //     start[i] = intervals.get(i).start;
        //     end[i] = intervals.get(i).end;
        // }

        // Arrays.sort(start);
        // Arrays.sort(end);

        // int s = 0, e = 0, count = 0, res = 0;

        // while(s < n){
        //     if(start[s] < end[e]){
        //         ++count;
        //         ++s;
        //     }else{
        //         --count;
        //         ++e;
        //     }

        //     res = Math.max(res, count);
        // }

        // return res;

        //Solution - 3 : PriorityQueue

        if(intervals.size() == 0){
            return 0;
        }
        Collections.sort(intervals, (a, b)-> (a.start- b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //to save end time

        for(Interval interval : intervals){
            //if meeting ended, free space
            if(!pq.isEmpty() && pq.peek() <= interval.start){ // = since (0,8),(8,10) is NOT considered a conflict at 8.
                pq.poll();
            }
            pq.offer(interval.end); //storing end this is imp;
        }

        return pq.size();
    }
}
