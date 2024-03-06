package LeetcodePractice.Node;

public class leftnode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }
    int k=0;
    public int sumOfLeftLeaves(TreeNode root) {

        count(root,false);
        return k;
    }
    private void count(TreeNode node, boolean tr){
//        if(node.left!=null){
//            count(node.left,true);
//        }
//        if(tr){k+=node.val;}
//        if(node.right!=null){
//            count(node.right,false);
//        }
        if(node == null){return;}
        if(node.left!=null){
            count(node.left,true);
        }
        if (node.left != null && node.left.left == null && node.left.right ==     null) {
            k += node.left.val;
        }
        if(node.right!=null){
            count(node.right,false);
        }
    }


}
