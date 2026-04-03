//TC : O(M+N), SC : O(1)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;

        int m = firstList.length;
        int n = secondList.length;

        List<int[]> res = new ArrayList<>();

        while(i < m && j < n){
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            //intersect
            if(start <= end){
                res.add(new int[]{start, end});
            }

            //what to increment
            if(firstList[i][1] < secondList[j][1]){
                ++i;
            }else{
                ++j;
            }
        }


        return res.toArray(new int[res.size()][]);
        
    }
}