/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    /*
    DFS with preorder traversal
    */
    private String SEP = ",";
    private String NIL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    private void build(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NIL).append(SEP);
            return;
        }
        //NLR
        sb.append(root.val).append(SEP);
        build(root.left, sb);
        build(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(SEP)));
        return parse(q);
    }

    private TreeNode parse(Deque<String> q){
        String t = q.removeFirst();
        if(t.equals(NIL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(t));
        root.left = parse(q);
        root.right = parse(q);
        return root;
    }
}
