package LeetcodePractice.Node;

import java.util.HashSet;

/**
 * @author admin
 */
public class SumOfTwo {
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){return false;}
        if(set.contains(k-root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
