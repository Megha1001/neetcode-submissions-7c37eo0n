class WordDictionary {

    class TrieNode{
        TrieNode [] children = new TrieNode[26];
        boolean eow;
    }
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    private TrieNode getNode(){
        return new TrieNode();
    }

    public void addWord(String word) {
        TrieNode crawler = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(crawler.children[idx] == null){
                crawler.children[idx] = getNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.eow = true;

    }

    private boolean searchUtils(TrieNode root, String word, int idx){
        TrieNode crawler = root;

        for(int i = idx; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(int j = 0; j < 26; j++){
                    if(crawler.children[j] != null){
                        if(searchUtils(crawler.children[j], word, i + 1)){
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

    public boolean search(String word) {
        return searchUtils(root, word, 0);
    }

    
}
