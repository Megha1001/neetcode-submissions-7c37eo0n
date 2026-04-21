class Solution {
    public String foreignDictionary(String[] words) {
        // TOPOLOGICAL SORT
        Map<Character, Set<Character>>graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        //1. Build vertices
        for(String w : words){
            for(char ch : w.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        //2. Build edges
        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length() > w2.length() && w1.startsWith(w2)){
                return "";//invalid
            }
            int len = Math.min(w1.length(), w2.length());
            for(int j = 0; j < len; j++){
                char a = w1.charAt(j);
                char b = w2.charAt(j);
                if(a != b){
                    // a->b
                    if(graph.get(a).add(b)){
                        indegree.put(b, indegree.get(b) + 1);
                    }
                    break; // only first differing char matters
                }
            }
        }

        //3. Topo sort(Kahn)
        Deque<Character> q = new ArrayDeque<>();
        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0){
                q.offer(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()){
            char curr = q.poll();
            result.append(curr);

            for(char nei : graph.get(curr)){
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0){
                    q.offer(nei);
                }
            }
        }

        // if cycle exist not all the characters processed
        return result.length() == indegree.size() ? result.toString() : "";
      
    }
}
