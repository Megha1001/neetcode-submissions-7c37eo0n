class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<List<Integer>> res = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               int start = Math.max(firstList[i][0], secondList[j][0]);
               int end = Math.min(firstList[i][1], secondList[j][1]);

               if(start <= end){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
               }

               if(firstList[i][1] < secondList[j][0]){
                    break;
               }
            }
        }

        return res.stream()
        .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
        
    }
}