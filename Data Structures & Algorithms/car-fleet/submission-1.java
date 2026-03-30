class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //Using Stack
        int [][] pairs = new int[position.length][2]; //<Pair<Position, speed>>
        
        for(int i=0; i<position.length; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        //sort in decending order of position
        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for(int [] p : pairs){
            stack.push((double)(target - p[0])/p[1]); //time when it reach the target

            //check for adjancent if it collid --> note : Its only one if not while
            //If the current car reaches the target earlier than the car infront of it, it will catchup -> they form one fleet
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            } 
        }

        return stack.size();

    }
}
