class LFUCache {

    class Node{
        int key;
        int val;
        int freq;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node>nodeMap;
    private Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return - 1;
        }

        Node node = nodeMap.get(key);
        increaseFreq(node);
        return node.val;        
    }

    private void increaseFreq(Node node){
        int oldFreq = node.freq;
        LinkedHashSet<Integer> oldSet = freqMap.get(oldFreq);
        oldSet.remove(node.key);
        if(oldSet.isEmpty()){
            freqMap.remove(oldFreq);
            if(oldFreq == minFreq){
                ++minFreq;
            }
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node.key);
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }

        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            increaseFreq(node);
            return;
        }

        if(nodeMap.size() == capacity){
            LinkedHashSet<Integer> minSet = freqMap.get(minFreq);
            int evictKey = minSet.iterator().next();
            minSet.remove(evictKey);
            if(minSet.isEmpty()){
                freqMap.remove(minFreq);
            }
            nodeMap.remove(evictKey);
        }

        Node node = new Node(key, value);
        nodeMap.put(key, node);
        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */