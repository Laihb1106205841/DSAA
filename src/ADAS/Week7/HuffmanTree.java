package ADAS.Week7;

import java.util.*;

// 大树 保证顺序
//

class Tree{
    CityNode root;
}


// 定义城市节点
class CityNode implements Comparable<CityNode>{
    int cost;
    int index;
    int num;
    int isRoot;
    ArrayList<Integer> priority;
    CityNode left;
    CityNode right;

    public CityNode(int cost, int index) {
        this.cost = cost;
        this.index = index;// is City or not
        this.num = 1;
        this.left = null;
        this.right = null;
        priority = new ArrayList<>();
        this.isRoot=0;
    }
    public CityNode(int cost, int index, int num) {
        this.cost = cost;
        this.index = index;// is City or not
        this.num = num;
        this.left = null;
        this.right = null;
        priority = new ArrayList<>();
        this.isRoot = 0;
    }

    public void AddPriority(int nodeIndex){
        priority.add(nodeIndex);
    }

    @Override
    public int compareTo(CityNode o) {
        if(o.isRoot == 1){
            return -1;
        }
        if(priority.contains(o.index)){ // o 在node 前面
            return 1;
        }
        return o.cost-cost;
    }
}

public class HuffmanTree {
    int TotalCost;
    int Time;
    public HuffmanTree(){
        TotalCost = 0;
        Time = 0;
    }

    // 构建哈夫曼树
    public CityNode buildHuffmanTree(int[] costs, PriorityQueue<CityNode> pq) {


        while (pq.size() > 1) {
            CityNode left = pq.poll();
            CityNode right = pq.poll();
            CityNode parent = new CityNode((left.cost + right.cost)/left.num+ right.num, -1,left.num+ right.num);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }

        return pq.poll(); // 返回哈夫曼树的根节点
    }

    // 哈夫曼树遍历
    public void preorderTraversal(CityNode root) {
        if (root == null) return;

        if(root.index>=0){
            System.out.print(root.index+1 + " "); // 输出节点编号
            TotalCost += root.cost * root.index;
            Time += 1;
        }

        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public static void swap(int a,int b){
        int c = a;
        a = b;
        b = c;
    }

//    public static int[] building(int[] costs){}

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int node1 = scanner.nextInt();

        int[] costs = new int[n];

        for(int i=0;i<n;i++){
            costs[i] = scanner.nextInt();
        }

        HuffmanTree huffmanTree = new HuffmanTree();
        ArrayList<CityNode> acn = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            acn.add(new CityNode(costs[i], i));
        }

        for(int i=0;i<n-1;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            acn.get(x-1).AddPriority(y-1);
        }

        PriorityQueue<CityNode> pq = new PriorityQueue<>(acn);

        // 构建哈夫曼树
        CityNode root = huffmanTree.buildHuffmanTree(costs, pq);

        // 先序遍历哈夫曼树
        System.out.println("Preorder Traversal:");
        huffmanTree.preorderTraversal(root);
        System.out.println();
        System.out.println(huffmanTree.TotalCost);
    }
}
