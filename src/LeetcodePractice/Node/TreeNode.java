package LeetcodePractice.Node;

public class TreeNode {
    /* 基本的二叉树节点 */
    int val;//当前节点的值
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void traverse(TreeNode root) {
        //前序位置
        traverse(root.left);
        // 中序位置
        traverse(root.right);
        // 后序位置
    }
    // N叉树
//    class TreeNode {
//        int val;
//        TreeNode[] children;
//    }
//
//    void traverse(TreeNode root) {
//        for (TreeNode child : root.children)
//            traverse(child);
//    }

}
