class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while(true){
            int res = 0;
            while(n != 0){
                res = res + (n%10)*(n%10);
                n = n/10;
            }
            if(res == 1){
                return true;
            }
            else if(set.contains(res)){
                return false;
            }
            set.add(res);
            n = res;
        }
    }
}
