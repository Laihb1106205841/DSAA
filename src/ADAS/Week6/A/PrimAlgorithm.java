package ADAS.Week6.A;

import java.util.*;

class PrimMST {
    static int INF = 1000000007;

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int primMST(int n, ArrayList<ArrayList<Edge>> graph) {
        int minCost = 0;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.offer(new Edge(0, 0)); // Start from node 0

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.to;
            int cost = edge.cost;

            if (visited[u]) continue;
            visited[u] = true;
            minCost += cost;

            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.to;
                int c = neighbor.cost;
                if (!visited[v] && c < minDist[v]) {
                    minDist[v] = c;
                    pq.offer(new Edge(v, c));
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new Edge(1, 1));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 3));
        graph.get(1).add(new Edge(4, 4));
        graph.get(2).add(new Edge(3, 5));
        graph.get(2).add(new Edge(4, 6));
        graph.get(3).add(new Edge(0, 7));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(0, 9));
        graph.get(4).add(new Edge(2, 10));

        int minCost = primMST(n, graph);
        System.out.println("Minimum cost of MST: " + minCost);
    }
}
