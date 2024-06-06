package ADAS.Week11;

import java.util.*;

public class A {
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int to, flow, capacity;
        Edge residual;//反向边

        public Edge(int to, int capacity) {
            this.to = to;
            this.capacity = capacity;
        }
    }

    static List<List<Edge>> graph;

    static void addEdge(int from, int to, int capacity) {
        Edge e1 = new Edge(to, capacity);
        Edge e2 = new Edge(from, 0);
        e1.residual = e2;
        e2.residual = e1;
        graph.get(from).add(e1);
        graph.get(to).add(e2);
    }

    static int maxFlow(int source, int sink) {
        int flow = 0;
        while (true) {
            boolean[] visited = new boolean[graph.size()];
            int newFlow = dfs(source, sink, INF, visited);
            if (newFlow == 0) break;
            flow += newFlow;
        }
        return flow;
    }

    static int dfs(int node, int sink, int flow, boolean[] visited) {
        if (node == sink) return flow;
        visited[node] = true;
        List<Edge> edges = graph.get(node);
        for (Edge edge : edges) {
            if (!visited[edge.to] && edge.capacity > 0) {
                int minFlow = dfs(edge.to, sink, Math.min(flow, edge.capacity), visited);
                if (minFlow > 0) {
                    edge.capacity -= minFlow;
                    edge.residual.capacity += minFlow;
                    return minFlow;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 水库数量
        int m = scanner.nextInt(); // 水流数量
        int s = scanner.nextInt(); // 初始大水库编号 start
        int t = scanner.nextInt(); // 备用大水库编号 end

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(u, v, w);
        }

        int maxFlow = maxFlow(s, t);
        System.out.println(maxFlow);
    }
}

