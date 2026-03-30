class Solution {
    public static int CHAR = 26;

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int count[] = new int[26];

            for(char c : s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i: count){
                key.append(i).append("#");
            }

            map.computeIfAbsent(key.toString(), k-> new ArrayList<>()).add(s);

        }
        return new ArrayList<>(map.values());

    }
    // public List<List<String>> groupAnagrams(String[] strs) {

    //     List<List<String>> res = new ArrayList<>();
        
    //     res = populateAnagrams(strs, strs.length);
    //     return res;
    // }

    // public static List<List<String>> populateAnagrams(String [] strs, int n){

    //     if(strs.length==0){
    //         return List.of();
    //     }

    //     List<List<String>> res = new ArrayList<>();
    //     List<String> list = new ArrayList<>();

    //     boolean[] alreadyConsidered = new boolean[n];
    //     boolean isPresent=false;
    //     for(int i=0; i<n; i++){
    //         if (alreadyConsidered[i]) continue;
    //         list = new ArrayList<>();
    //         list.add(strs[i]);
    //         alreadyConsidered[i] = true;
    //         for(int j=i+1; j<n; j++){
    //             if(!alreadyConsidered[j] && isAnagrams(strs[i], strs[j])){
    //                 list.add(strs[j]);
    //                 alreadyConsidered[j] = true;
    //             }
    //         }

    //         res.add(list);
    //     }
    //     return res;
    // }
    
    // public static boolean isAnagrams(String input, String target){

    //     if(input.length() != target.length()){
    //         return false;
    //     }

    //     int alphabet[] = new int[CHAR];
    //     for(int i=0; i<input.length(); i++){
    //         alphabet[input.charAt(i)- 'a']++;
    //         alphabet[target.charAt(i)- 'a']--;
    //     }

    //     for(int i=0; i<CHAR; i++){
    //         if(alphabet[i]!=0){
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}