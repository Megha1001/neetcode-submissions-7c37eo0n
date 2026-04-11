/*
Use BFS level order traversal, to find the shortest distance
For each word , try changing all the characters from a to x
if the generated new string exists in the wordList then add it to queue and remove from list
BFS gurantees to find the shortest distance if we reach the word
TC : O(N*L*L), SC : O(N)
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList); //for fast lookup

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();

                if(curr.contains(endWord)){
                    return steps;
                }

                char [] arr = curr.toCharArray();

                for(int j = 0; j < arr.length; j++){
                    char original = arr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        arr[j] = ch;
                        String newString = new String(arr);
                        if(set.contains(newString)){
                            q.offer(newString);
                            set.remove(newString);
                        }
                    }
                    arr[j] = original;
                }
            }
            ++steps;
        }


        return 0;
        
    }
}
