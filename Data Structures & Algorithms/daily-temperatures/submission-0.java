class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        //Brute force : calculate for each element
        int days = temperatures.length;
        int [] res = new int[days];
        
        for(int i=0; i<days; i++){
            for(int j=i+1; j<days; j++){
                if(temperatures[j] > temperatures[i]){
                    res[i] = j-i;
                    break;
                }
                
            }
        }

        return res;
        
    }
}
