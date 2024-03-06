package DSAA.Week8;

import java.util.Scanner;
import java.util.Stack;



public class ExpressionTree {

    private static class TreeNode {
        char value;
        TreeNode left, right;

        public TreeNode(char value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    public static TreeNode buildTree(String expression) {
        Stack<TreeNode> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(new TreeNode(c));
            } else if (isOperator(c)) {
                TreeNode node = new TreeNode(c);
                node.left = stack.pop();
                node.right = stack.pop();
                stack.push(node);
            }
        }

        return stack.pop();
    }
//    public static Main.Node BuildTree(char[] par){
//
//        int tail=0;
//        int head=0;
//
//        Main.stack stack = new Main.stack();
//
//        int length = par.length;
//        Main.Node[] Nqueue = new Main.Node[length];
//
//        Main.Node root = new Main.Node(par[0]);
//        Nqueue[tail++] = root;
//        stack.push2st(root);
//
//        for (int cnt=1;cnt<length;cnt++){
//
//            if(Character.isLetter(par[cnt])){
//
//            }
//            if(par[cnt]=='+'||par[cnt]=='-'||par[cnt]=='*'||par[cnt]=='/'){
//                Main.Node n = new Main.Node(par[cnt]);
//                n.left=stack.pop2st();
//                n.right=stack.pop2st();
//            }
//
//            //add left node
//            char l = par[cnt];
//            cnt++;
//            Main.Node leftNode = new Main.Node(l);
//
//            Nqueue[head].left = leftNode;
//            Nqueue[tail] =leftNode;
////            Nqueue[tail].father = Nqueue[head];
//            tail++;
//
//            //add right node
//            char r = par[cnt];
//            cnt++;
//            Main.Node rightNode= new Main.Node(r);
//
//            Nqueue[head].right =rightNode;
//            Nqueue[tail] =rightNode;
////            Nqueue[tail].father = Nqueue[head];
//            tail++;
//
//            head++;
//        }
//        return root;
//    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value);
            inorderTraversal(root.right);
        }
    }

    public static void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.value);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public static void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.value);
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        // input
        Scanner scan = new Scanner(System.in);
        String inputExpression = scan.next();

        // build
        TreeNode root = buildTree(inputExpression);

        // output
        inorderTraversal(root);
        System.out.println();
        preorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }
}

