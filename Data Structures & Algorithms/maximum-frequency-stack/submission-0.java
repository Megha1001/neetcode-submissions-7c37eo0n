/*
 While have to map
 1. Map<Integer, Integer> freq //maintain the val, freq
 2. Map<Integer, Deque<Integer>> group // freq, stack of values
*/

class FreqStack {
    private final Map<Integer, Integer> freq;
    private final Map<Integer, Deque<Integer>> group;
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
        
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);

        group.computeIfAbsent(f, k -> new ArrayDeque<>()).push(val);
    }
    
    public int pop() {
        Deque<Integer> st = group.get(maxFreq);
        int val = st.pop();
        freq.put(val, freq.get(val) - 1);

        if(st.isEmpty()){
            group.remove(maxFreq);
            --maxFreq;
        }

        return val;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */