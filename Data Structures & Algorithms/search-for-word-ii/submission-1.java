class Solution {
    private List<String>result = new ArrayList<>();
    private int rows, cols;
    private int[][]directions = {{0,1},{0,-1},{1,0},{-1,0}};

    static class TrieNode{
        TrieNode []children = new TrieNode[26];
        boolean eow;
        String word = "";
    }

    private TrieNode getNode(){
        return new TrieNode();
    }

    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = getNode();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
        curr.word = word;
    }

    private void dfs(char[][]board, int r, int c, TrieNode root){
        if(r < 0 || r >= rows || c < 0 || c >= cols 
        || board[r][c] == '#'
        || root.children[board[r][c] - 'a'] == null){
            return;
        }
        
        root = root.children[board[r][c] - 'a'];

        if(root.eow){
            result.add(root.word);
            root.eow = false;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        for(int dir[] : directions){
            int r_ = r + dir[0];
            int c_ = c + dir[1];
            dfs(board, r_, c_, root);
        }

        board[r][c] = temp;

    }

    public List<String> findWords(char[][] board, String[] words) {
       //TRIE
       rows = board.length;
       cols = board[0].length;

       TrieNode root = getNode();
       for(String word : words){
            insert(root, word);
       }

       for(int r = 0; r < rows; r++){
        for(int c = 0; c < cols; c++){
            if(root.children[board[r][c] - 'a'] != null){
                dfs(board, r, c, root);
            }
        }
       }

       return result;

        
    }
}
