class Solution {
    public String reorganizeString(String s) {
        //Max Heap
        //1. count freq
        Map<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            int count = freq.getOrDefault(c, 0) + 1;

            if(count > (s.length() + 1)/2){
                return "";
            }
            freq.put(c, count);
        }

        //2. Max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(char c : freq.keySet()){
            pq.offer(new int[]{freq.get(c), c});
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2){
            int first[] = pq.poll();
            int second[] = pq.poll();

            sb.append((char)first[1]);
            sb.append((char)second[1]);

            --first[0];
            --second[0];

            if(first[0] > 0){
                pq.offer(first);
            }

            if(second[0] > 0){
                pq.offer(second);
            }
        }

        if(!pq.isEmpty()){//only one element
            int[]first = pq.poll();
            sb.append((char) first[1]);
        }

        return sb.toString();
        
    }
}