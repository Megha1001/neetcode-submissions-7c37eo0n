class LRUCache {
    
    private static class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null){
            node.val = value;
            moveToFront(node);
            return;
        }

        if(cache.size() == capacity){
            Node lru = tail.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }

        Node curr = new Node(key, value);
        cache.put(key, curr);
        addToFront(curr);
    }

    private void moveToFront(Node node){
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */