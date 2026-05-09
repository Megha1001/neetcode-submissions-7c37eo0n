class WordDictionary {
    static class TrieNode{
        TrieNode children[] = new TrieNode[26];
        boolean eow;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode crawler = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(crawler.children[index] == null){
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.eow = true;

    }

    public boolean search(String word) {
        return searchUtil(root, word, 0);
    }

    private boolean searchUtil(TrieNode root, String word, int idx){
        TrieNode crawler = root;

        for(int i = idx; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(int j = 0; j < 26; j++){
                    if(crawler.children[j] != null){
                        if(searchUtil(crawler.children[j], word, i+1)){
                            return true;
                        }
                    }
                }
                return false;
            }else if(crawler.children[ch - 'a'] == null){
                return false;
            }
            crawler = crawler.children[ch - 'a'];
        }

        return crawler != null && crawler.eow;
    }
}
