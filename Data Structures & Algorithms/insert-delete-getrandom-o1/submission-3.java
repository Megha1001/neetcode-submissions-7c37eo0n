class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map; //val, index;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
        
    }
    
    //tricky
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int index = map.get(val); //return index;
        int lastElement = list.get(list.size() - 1);

        //override present element -> a kind of swapping
        list.set(index, lastElement);
        map.put(lastElement, index);
        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */