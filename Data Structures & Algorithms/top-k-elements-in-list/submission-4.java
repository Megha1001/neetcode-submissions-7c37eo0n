//TC : O(n + mlogK)
//SC : O(m + k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Approach -1 HashMap and min Heap
        Map<Integer, Integer> freq = new HashMap<>(); // TC(m)where m is unique elements

        for(int num : nums){ //TC : O(n)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        //{frequency, count}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){ //TC : O(m) => total = O(m * logK)
            int val = entry.getKey();
            int count = entry.getValue();

            pq.offer(new int[]{count, val}); // TC : O(logK) where m is unique elements
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int res[] = new int[k];
        int idx  = 0;
        while(!pq.isEmpty()){ // TC : O(k)
            res[idx++] = pq.poll()[1];
        }

        return res;
    }
}
