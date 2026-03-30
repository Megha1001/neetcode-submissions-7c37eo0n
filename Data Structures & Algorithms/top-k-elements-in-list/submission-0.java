class Solution {
    //Iterate through each entry of map 
    /*
    List index will be count of times the values occurred the value will be the list
    For Example [1,2,2,2,100,100], n = 6
    Map : 
        1, 1
        2, 3
        100, 2

    Arraylist : 
            value -> _  [1]    [100]       [2]
            Index -> 0,  1,     2,          3,     4,    5
    It says 1 occurred 1 times
    100 occurred 2 times
    2 occurred 3 times

    traverse in reverse and get not null values
    */
    public int[] topKFrequent(int[] nums, int k) {

        ArrayList<Integer>result = new ArrayList<>();

        //Store the key, frequency in HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        ArrayList<ArrayList<Integer>> occurrence = new ArrayList<>();

        for(int i=0; i<20000; i++){
            occurrence.add(new ArrayList<>());
        }

 
        for(Map.Entry<Integer, Integer>entry : map.entrySet()){
            //store the count as index and values as list
            occurrence.get(entry.getValue()).add(entry.getKey());
        }


        //traverse in reverse and get not null values
        for(int i= occurrence.size()-1; i>=0 && k!=0; i--){
            if(occurrence.get(i).size()>0){
                occurrence.get(i).forEach(e -> result.add(e));
                k -= occurrence.get(i).size();
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
