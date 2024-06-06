//package ADAS.Week6.A;
//
//import java.util.*;
//
//class Edge {
//    int from, to, cost;
//
//    public Edge(int from, int to, int cost) {
//        this.from = from;
//        this.to = to;
//        this.cost = cost;
//    }
//}
//
//public class ZhuLiuAlgorithm {
//
//    static int INF = 1000000007;
//
//    static int solve(int n, ArrayList<Edge> edges, int root) {
//        int res = 0;
//        int[] in = new int[n];
//        int[] pre = new int[n];
//        int[] id = new int[n];
//
//        while (true) {
//            Arrays.fill(in, INF);
//            for (Edge e : edges) {
//                if (e.from != e.to && e.cost < in[e.to]) {
//                    pre[e.to] = e.from;
//                    in[e.to] = e.cost;
//                }
//            }
//
//            int cnt = 0;
//            Arrays.fill(id, -1);
//            Arrays.fill(in, INF);
//
//            for (int i = 0; i < n; ++i) {
//                res += in[i];
//                int u = i;
//                while (id[u] == -1 && u != root && u != i) {
//                    id[u] = cnt;
//                    u = pre[u];
//                }
//                if (u != root && id[u] == -1) {
//                    for (int v = pre[u]; v != u; v = pre[v]) {
//                        id[v] = cnt;
//                    }
//                    ++cnt;
//                }
//            }
//            if (cnt == 0) break;
//            for (int i = 0; i < n; ++i) {
//                if (id[i] == -1) id[i] = cnt++;
//            }
//            for (Edge e : edges) {
//                int v = e.to;
//                e.from = id[e.from];
//                e.to = id[e.to];
//                if (e.from != e.to) e.cost -= in[v];
//            }
//            n = cnt;
//            root = id[root];
//        }
//
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int n = 5; // Number of vertices
//        int root = 0; // Root vertex index
//        ArrayList<Edge> edges = new ArrayList<>();
//        edges.add(new Edge(0, 1, 1));
//        edges.add(new Edge(0, 2, 2));
//        edges.add(new Edge(1, 3, 3));
//        edges.add(new Edge(1, 4, 4));
//        edges.add(new Edge(2, 3, 5));
//        edges.add(new Edge(2, 4, 6));
//        edges.add(new Edge(3, 0, 7));
//        edges.add(new Edge(3, 1, 8));
//        edges.add(new Edge(4, 0, 9));
//        edges.add(new Edge(4, 2, 10));
//
//        int minCost = solve(n, edges, root);
//        System.out.println("Root node index: " + root);
//        System.out.println("Minimum cost: " + minCost);
//    }
//}
//
