class LRUCache {

    private class Node{
        int key, value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    
    private void markAsMRU(Node node){
        remove(node);
        insertAtFront(node);
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            markAsMRU(node);
            return node.value;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            markAsMRU(node);
            return;
        }else{
            Node node = new Node(key, value);
            cache.put(key, node);
            insertAtFront(node);
            --capacity;
        }

        if(capacity < 0){
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
            ++capacity;
        }
        
    }
}
