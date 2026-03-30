class Solution {
    // public int[] dailyTemperatures(int[] temperatures) {

    //     //Brute force : calculate for each element
    //     int days = temperatures.length;
    //     int [] res = new int[days];
        
    //     for(int i=0; i<days; i++){
    //         for(int j=i+1; j<days; j++){
    //             if(temperatures[j] > temperatures[i]){
    //                 break;
    //             }
                
    //         }
    //         res[i] = count;
    //     }

    //     return res;
        
    // }

    public int[] dailyTemperatures(int[] temperatures) {
        //Using Stack that will contains the value waiting for its warmer day
        int n = temperatures.length;
        int res[] = new int[n];

        Deque<int[]> stack = new ArrayDeque<>(); //Pair <temp{index}, index>

        for(int i=0; i<n; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                int [] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i}); //push equal too
        }

        return res;
        
    }
}
