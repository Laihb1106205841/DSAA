package LeetcodePractice.Node;


public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){return true;}
        if(p==null || q==null||p.val != q.val ){return false;}
        boolean is = isSameTree(p.left,q.left);
        boolean is2= isSameTree(p.right,q.right);
        return is && is2;
    }


}
