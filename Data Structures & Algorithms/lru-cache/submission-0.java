class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}


class LRUCache {
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        //point to each other
        this.left.next = right;
        this.right.prev = left;
        
    }

    public void insert(Node node){
        //insert at MRU
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        right.prev = node;
        node.next = right;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            //make most recent
            remove(curr);
            insert(curr);
            return curr.val;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > cap){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}
