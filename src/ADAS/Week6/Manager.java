package ADAS.Week6;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, cost;

    public Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }

    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

public class Manager {

    // 最大问题：只能解决无向图的问题
    public static int primMST(List<List<Edge>> graph, int V, int startVertex) {
        int[] minDist = new int[V]; // To store weights of edges
        int[] parent = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] mstSet = new boolean[V]; //有没有遇到过这个点

        PriorityQueue<Edge> FrontierEdge = new PriorityQueue<>();

        minDist[startVertex] = 0; // Start from the first vertex
        FrontierEdge.offer(new Edge(-1, startVertex, 0));

        while (!FrontierEdge.isEmpty()) {
            Edge minEdge = FrontierEdge.poll();
            int newVertex = minEdge.dest; // dest vertex

            if (mstSet[newVertex]){//我们走过这个点了
                // 哈哈，this is the problem
                continue;
            }

            mstSet[newVertex] = true; // 走过

            for (Edge edge : graph.get(newVertex)) {
                int v = edge.dest;
                int weight = edge.cost;
                if (weight < minDist[v]) { //没有遇到 或者 遇到的比之前小
                    minDist[v] = weight;
                    parent[v] = newVertex;
                    FrontierEdge.offer(new Edge(newVertex, v, weight)); // 目标 目标的边
                }
            }
        }

        int minCost = 0;
        for (int i = 1; i < V; i++) {
            if(mstSet[i]){
                minCost += minDist[i];
            }else {return -1;}
        }

        return minCost;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            int start = scan.nextInt();
            int des = scan.nextInt();
            int cost = scan.nextInt();
            Edge edge = new Edge(start, des, cost);
            graph.get(start).add(edge);
        }
        int mini = Integer.MAX_VALUE;
        int key = 0;

        int imp = 0;

        for(int i =0;i<N;i++){
            int min = primMST(graph,N,i);
            if(min == -1){
                imp+=1;
                continue;
            }
            if(min < mini){
                mini = min;
                key = i;
            }
        }

        if(imp == N || mini == Integer.MAX_VALUE){
            System.out.println("impossible");
        }else {
            System.out.println(mini+" "+key);
        }

    }
}

//        for(int i=0;i<N;i++){
//            Point p = new Point(i);
//            pointList.put(i,p);
//
////            SuperPoint superPoint = new SuperPoint(i);
////            superPoint.addPoint(pointList.get(i));
////            superPointList.add(superPoint);
//        }
//        for(int i=0;i<M;i++){
//            int outPoint = scan.nextInt();
//            int inPoint = scan.nextInt();
//            int Cost = scan.nextInt();
//            Edge edge = new Edge(outPoint,inPoint,Cost);
//
//            Point out = pointList.remove(outPoint);
//            out.addOutEdge(edge);
//            pointList.put(out.index,out);
//
//        }
