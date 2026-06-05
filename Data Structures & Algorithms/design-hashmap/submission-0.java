class MyHashMap {

    private int[] values;
    private boolean[]used;

    public MyHashMap() {
        values = new int[1000001];
        used = new boolean[1000001];
    }
    
    public void put(int key, int value) {
        values[key] = value;
        used[key] = true;
    }
    
    public int get(int key) {
        if(used[key]){
            return values[key];
        }
        return -1;
    }
    
    public void remove(int key) {
        used[key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */