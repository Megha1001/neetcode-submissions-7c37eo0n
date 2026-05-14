class Solution {
    public int leastInterval(char[] tasks, int n) {
        //TC : O(N)
        //SC : log(size) = log(26) 
        //Max Heap
        //1. count the frequency
        int [] freq = new int[26];

        for(char c : tasks){
            ++freq[c - 'A'];
        }

        //2. build max Heap for storing freq
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq){
            if(f > 0){
                pq.offer(f);
            }
        }

        int time = 0;
        
        while(!pq.isEmpty()){
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            while(cycle -- > 0 && !pq.isEmpty()){
                int currFreq = pq.poll();
                if(currFreq > 1){
                    store.add(currFreq - 1);
                }
                ++taskCount;
            }
            store.forEach(pq::offer);
            time += pq.isEmpty() ? taskCount : n + 1;
        }



        return time;
        
    }
}
