package DSAA.Week10;

import java.util.Scanner;

public class AVLT {

    // AVL树的节点
    private class Node {
        int val;  // 节点的值
        int height;  // 节点的高度
        Node left;  // 左子树
        Node right;  // 右子树

        public Node(int val) {
            this.val = val;
            height = 1;  // 新建节点的高度为1
        }
    }

    private Node root;  // 根节点

    /**
     * 获取节点的高度
     * @param node 节点
     * @return 节点的高度，若节点为空则返回0
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获取节点的平衡因子
     * @param node 节点
     * @return 节点的平衡因子，左子树的高度减去右子树的高度
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 更新节点的高度
     * @param node 节点
     */
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * 右旋操作
     * @param y 不平衡节点
     * @return 旋转后的根节点
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     * 左旋操作
     * @param y 不平衡节点
     * @return 旋转后的根节点
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;
        x.left = y;
        y.right = t2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     * 插入节点
     * @param root 根节点
     * @param val 节点的值
     * @return 插入后的根节点
     */
    private Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        // 更新节点的高度
        updateHeight(root);
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(root);
                // 平衡维护
                // LL情况：左左子树过深
        if (balanceFactor > 1 && getBalanceFactor(root.left) >= 0) {
            return rightRotate(root);
        }
        // RR情况：右右子树过深
        if (balanceFactor < -1 && getBalanceFactor(root.right) <= 0) {
            return leftRotate(root);
        }
        // LR情况：左右子树过深
        if (balanceFactor > 1 && getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // RL情况：右左子树过深
        if (balanceFactor < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    /**
     * 在AVL树中插入节点
     * @param val 节点的值
     */
    public void insert(int val) {
        root = insert(root, val);
    }

    /**
     * 中序遍历AVL树
     * @param root 根节点
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * 中序遍历AVL树
     */
    public void inOrder() {
        inOrder(root);
    }

    public static void main(String[] args) {
        AVLT avl = new AVLT();
        Scanner scan = new Scanner(System.in);

        //Insert
        int insert = scan.nextInt();
        for(int i=0;i<insert;i++){
            int num = scan.nextInt();
            avl.insert(num);
        }

        //Delete
        int delete = scan.nextInt();
        for(int i=0;i<delete;i++){
            int num = scan.nextInt();
//            avl.delete(num);
        }

        //Print
        avl.inOrder(avl.root);

    }
}