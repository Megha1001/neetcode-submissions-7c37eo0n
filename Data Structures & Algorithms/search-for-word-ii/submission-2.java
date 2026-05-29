//TC : O(W.L + M.N.3^L)
//SC : O(W.L)
class Solution {
    private int m;
    private int n;
    private List<String> result = new ArrayList<>();
    private int [][]directions = {{0,1},{0,-1},{1,0},{-1,0}};


    class TrieNode{
        boolean eow;
        TrieNode [] children = new TrieNode[26];
        String word;
    }

    private TrieNode getNode(){
        return new TrieNode();
    }

    public List<String> findWords(char[][] board, String[] words) {

        //Trie
        m = board.length;
        n = board[0].length;

        TrieNode root = getNode();

        for(String word : words){
            insert(root, word);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                findWords(board, i, j, root);
            }
        }
        return result;
    }

    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(root.children[word.charAt(i) - 'a'] == null){
                root.children[word.charAt(i) - 'a'] = getNode();
            }
            root = root.children[word.charAt(i) - 'a'];
        }
        root.eow = true;
        root.word = word;
    }

    private void findWords(char board[][], int i, int j, TrieNode root){
        if(i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        if(board[i][j] == '#' || root.children[board[i][j] - 'a'] == null){
            return;
        }

        root = root.children[board[i][j] - 'a'];
        if(root.eow){
            result.add(root.word);
            root.eow = false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        for(int [] dir : directions){
            findWords(board, i + dir[0], j + dir[1], root);
        }


        board[i][j] = temp;
    }
}
