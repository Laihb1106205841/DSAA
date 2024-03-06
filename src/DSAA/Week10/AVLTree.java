package DSAA.Week10;



import java.util.Scanner;

class Node{
    Node left;
    Node right;
    int height;
    int val;
    public Node(int val){
        this.val = val;

        height = 1;
    }

}

public class AVLTree {

    private Node root;
    public AVLTree(){
        root = null;
    }
    // get height
    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    // get node's balance
    private int getBalance(Node node) {
        if (node == null) {return 0;}
        return getHeight(node.left)-getHeight(node.right);
    }

    // update the height of the node
    private void updateHeight(Node node) {

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

    }

    public void Insert(int val){
        root = Insert(root,val);
    }

    private Node Insert(Node node, int key) {

        if(node == null){
            return new Node(key);
        }

        //smaller, so go left
        if (key < node.val) {
            node.left = Insert(node.left, key);
        }
        //bigger, so go right
        else if (key > node.val) {
            node.right = Insert(node.right, key);
        } else {
            // Duplicate keys
            return node;
        }

        updateHeight(node);
        int balance = getBalance(node);

        // when balance is -1,0,1, nothing happens;
        // if not, Rotate!

        // insert on the left
        if(balance > 1){
            //LL, so rightRotate
            if (key >= node.left.val) {
                //LR, so first left then right
                node.left = LeftRotate(node.left);
            }
            return RightRotate(node);
        }

        // insert on the right
        if(balance < -1){
            //RR, so leftRotate
            if (key <= node.right.val) {
                //RL, so first right then left
                node.right = RightRotate(node.right);
            }
            return LeftRotate(node);
        }

        return node;
    }

    private Node LeftRotate(Node p) {

        Node RightChild = p.right;
        p.right = RightChild.left;
        RightChild.left = p;

        updateHeight(p);
        updateHeight(RightChild);

        return RightChild;
    }


    private Node RightRotate(Node p) {

        Node LeftChild = p.left;
        p.left = LeftChild.right;
        LeftChild.right = p;

        updateHeight(p);
        updateHeight(LeftChild);

        return LeftChild;
    }


    // delete node
    public void Delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            // 找到要删除的节点
            if (root.left == null || root.right == null) {
                // 如果只有一个子树或无子树
                // copy children to root
                root = (root.left != null) ? root.left : root.right;
            } else {
                // if we have two subtree, find the least node on the left of the right
                Node temp = findMin(root.right);
                root.val = temp.val;
                root.right = delete(root.right, temp.val);
            }
        }

        if (root == null) return null;

        // 更新节点的高度
        updateHeight(root);

        // 获取节点的平衡因子
        int balance = getBalance(root);

        // 进行平衡维护
        if (balance > 1) {
            if (getBalance(root.left) < 0) {
                // 左右情况，先左旋后右旋
                root.left = LeftRotate(root.left);
            }  // 左左情况，进行右旋操作

            return RightRotate(root);
        }

        if (balance < -1) {
            if (getBalance(root.right) > 0) {
                // 右左情况，先右旋后左旋
                root.right = RightRotate(root.right);
            }  // 右右情况，进行左旋操作

            return LeftRotate(root);
        }

        return root;
    }

    // 查找最小值节点
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);

            System.out.print(node.val+" ");

            inOrder(node.right);
        }
    }



    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        Scanner scan = new Scanner(System.in);

        //Insert
        int insert = scan.nextInt();
        for(int i=0;i<insert;i++){
            int num = scan.nextInt();
            avl.Insert(num);
        }

        //Delete
        int delete = scan.nextInt();
        for(int i=0;i<delete;i++){
            int num = scan.nextInt();
            avl.Delete(num);
        }

        //Print
        inOrder(avl.root);

    }
}
