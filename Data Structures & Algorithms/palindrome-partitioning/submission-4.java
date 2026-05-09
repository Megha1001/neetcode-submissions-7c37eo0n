//TC : O(N^2 * 2^N)
//SC : O(N)
class Solution {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> part = new ArrayList<>();
        backTrack(0, s, part);
        return result;
    }

    private void backTrack(int i, String s, List<String>part){
        if(i == s.length()){
            result.add(new ArrayList<>(part));
            return;
        }
        //TC : part or not part -> 2^(n-1)
        /*
        Between every pair of characters, you either:
        cut
        or don’t cut
        */

        for(int j = i; j < s.length(); j++){ //--> TC : O(N)
            if(isPalindrome(s, i, j)){ //--> TC : O(N)
                part.add(s.substring(i, j+1));
                backTrack(j+1, s, part);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int h){
        while(l < h){
            if(s.charAt(l) != s.charAt(h)){
                return false;
            }
            ++l;
            --h;
        }

        return true;
    }
}