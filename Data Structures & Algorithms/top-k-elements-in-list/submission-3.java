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
    // public int[] topKFrequent(int[] nums, int k) {

    //     ArrayList<Integer>result = new ArrayList<>();

    //     //Store the key, frequency in HashMap
    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     for(int i : nums){
    //         map.put(i, map.getOrDefault(i,0)+1);
    //     }

    //     ArrayList<ArrayList<Integer>> occurrence = new ArrayList<>(nums.length+1); // 0 to maxOccurrence of element(=size) 

    //     for(int i=0; i<nums.length+1; i++){
    //         occurrence.add(new ArrayList<>());
    //     }

 
    //     for(Map.Entry<Integer, Integer>entry : map.entrySet()){
    //         //store the count as index and values as list
    //         occurrence.get(entry.getValue()).add(entry.getKey());
    //     }


    //     //traverse in reverse and get not null values
    //     for(int i= occurrence.size()-1; i>=0 && k!=0; i--){
    //         if(occurrence.get(i).size()>0){
    //             occurrence.get(i).forEach(e -> result.add(e));
    //             k -= occurrence.get(i).size();
    //         }
    //     }

    //     return result.stream().mapToInt(Integer::intValue).toArray();
        
    // }

     public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();

        List<Integer>[] freq = new List[nums.length+1]; // maximum length when all numbers are same so count == length, +1 is for zero as array is zero indexed;

        //initialize freq
        for(int i=0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        //populate HashMap
        for(int i:nums){
            count.put(i, count.getOrDefault(i, 0) + 1);
        }


        //use Map to populate list-> where value will be index and key will be value added as list
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }


        //traverse from last for k elements
        int res[] = new int[k];
        int index = 0;

        for(int i=freq.length-1; i>0 && index <k; i--){ //no need to execute for zero since no element occurs 0 times ;)
            for(int j : freq[i]){//for positions that are not empty
                res[index++] = j;
                if(index == k){
                    return res;
                }
            }

        }
        return res;

    }
}
