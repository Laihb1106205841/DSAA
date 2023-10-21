package LeetcodePractice.Node;

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null){return true;}
        TreeNode p= root.left;
        TreeNode q= root.right;
        return isSymeTree(p,q);
    }

    public boolean isSymeTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){return true;}
        if(p==null || q==null||p.val != q.val ){return false;}
        boolean is = isSymeTree(p.left,q.right);
        boolean is2= isSymeTree(p.right,q.left);
        return is && is2;
    }
}
