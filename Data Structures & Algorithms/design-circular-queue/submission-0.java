class MyCircularQueue {
    private int[] buffer;
    private int head; //read;
    private int tail; //write
    private int size;

    public MyCircularQueue(int k) {
        if(k <= 0){
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.buffer = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        buffer[tail] = value;
        tail = (tail + 1)% buffer.length;
        ++size;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        int value = buffer[head];
        head = (head + 1) % buffer.length;
        --size;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return buffer[head];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }

        int rearIndex = (tail - 1 + buffer.length) % buffer.length;
        return buffer[rearIndex];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == buffer.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */