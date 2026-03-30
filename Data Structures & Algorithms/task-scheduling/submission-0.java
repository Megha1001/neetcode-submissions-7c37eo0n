class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        Intuition : Consider the high freq characters first to make the tasks completion time minimum
        To have high freq chars use maxHeap, and to keep tracks of remaining part of task and its next scheduled time use Queue
        */

        int count [] = new int[26];

        for(char task : tasks){
            ++count[task - 'A'];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //to create maxHeap, by default its minHeap

        for(int cnt : count){
            if(cnt > 0){
                maxHeap.offer(cnt);
            }
        }

        int time = 0;
        Queue<int []> q = new ArrayDeque<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            ++time;

            if(maxHeap.isEmpty()){
                time = q.peek()[1]; //optimization
            }
            else {
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0){
                    q.offer(new int[]{cnt, time + n}); // remaining task, next scheduled time
                }
            }

            //check if in queue we have task that can be scheduled
            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.offer(q.poll()[0]);
            }
        }

        return time;
        
    }
}
