class Solution {
    // public int carFleet(int target, int[] position, int[] speed) {
    //     //Using Stack
    //     int [][] pairs = new int[position.length][2]; //<Pair<Position, speed>>
        
    //     for(int i=0; i<position.length; i++){
    //         pairs[i][0] = position[i];
    //         pairs[i][1] = speed[i];
    //     }

    //     //sort in decending order of position
    //     Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));

    //     Stack<Double> stack = new Stack<>();

    //     for(int [] p : pairs){
    //         stack.push((double)(target - p[0])/p[1]); //time when it reach the target

    //         //check for adjancent if it collid --> note : Its only one if not while
    //         //If the current car reaches the target earlier than the car infront of it, it will catchup -> they form one fleet
    //         if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
    //             stack.pop();
    //         } 
    //     }

    //     return stack.size();

    // }

    public int carFleet(int target, int[] position, int[] speed) {
        //Iterative solution
        int n = position.length;
        int [][]pair = new int[n][2]; // <position, speed>

        for(int i=0; i<n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        //sort in decending order of position
        Arrays.sort(pair, (a, b)-> Integer.compare(b[0], a[0]));

        int fleet = 1;
        double prevTime = (double)(target - pair[0][0])/pair[0][1];

        for(int i=1; i<n; i++){
            double currTime = (double)(target - pair[i][0])/pair[i][1];

            //it will create a new fleet and becomes the front of the new fleet
            if(currTime > prevTime){
                ++fleet;
                prevTime = currTime;
            }
        }

        return fleet;

    }
}
