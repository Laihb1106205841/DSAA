package DSAA.Week9;

import java.util.Scanner;

public class Main {


    public static class stack {
        public Node[] st;
        public boolean bracketsIsNull;
        public boolean brackets;
        int pointer;

        public stack(){
            st = new Node[10];
            pointer =0;
            bracketsIsNull = true;
            brackets       = true;
        }
        public void push2st(Node val){
            st[pointer] = val;
            if(pointer == st.length-1){
                Node[] st2 = new Node[st.length+10];
                System.arraycopy(st, 0, st2, 0, st.length);
                st = st2;
            }
            pointer++;
            bracketsIsNull = false;
        }
        public Node pop2st(){
            Node result;
            result = st[pointer-1];
            st[pointer] = null;
            pointer--;
            if(pointer == 0){
                bracketsIsNull = true;
            }
            return result;
        }
    }

    public static void InOrder(Node q){
        if(q != null){
            InOrder(q.left);
            System.out.print(q.val);
            InOrder(q.right);
        }
    }

    public static void infixOrder(Node node) {

        if (node != null) {
            //is letter
            if (node.left != null || node.right != null) {
                System.out.print("(");
            }
            infixOrder(node.left);

            System.out.print(node.val);

            infixOrder(node.right);

            if (node.left != null || node.right != null) {
                System.out.print(")");
            }
        }
    }
    public static void PreOrder(Node q){
        if(q != null){
            System.out.print(q.val);
            PreOrder(q.left);
            PreOrder(q.right);
        }
    }
    public static void PostOrder(Node q){
        if(q != null){
            PostOrder(q.left);
            PostOrder(q.right);
            System.out.print(q.val);
        }
    }

    public static class Node{
        Node left;
        Node right;
//        Node father;
        char val;
        public Node(char val){
            this.val = val;
        }
    }

    public static Node buildTree(String expression) {
        stack stack = new stack();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c=='+'||c=='-'||c=='*'||c=='/') {
                Node node = new Node(c);
                node.left = stack.pop2st();
                node.right = stack.pop2st();
                stack.push2st(node);
            } else if (Character.isLetter(c)){
                stack.push2st(new Node(c));
            }
        }
        return stack.pop2st();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] par = s.toCharArray();

        Node root = buildTree(s);

        infixOrder(root);
        System.out.println();
        PreOrder(root);
        System.out.println();
        PostOrder(root);

    }

}
