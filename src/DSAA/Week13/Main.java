package DSAA.Week13;

import java.util.*;

class Graph {
    private int vertices;
    private Map<Integer, List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new HashMap<>();
        for (int i = 1; i <= vertices; i++) {
            adjList.put(i, new LinkedList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Graph graph = new Graph(N);

        int sourceNode = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            int vi = scanner.nextInt();
            int vj = scanner.nextInt();
            graph.addEdge(vi, vj);
        }

        int vy = scanner.nextInt();
        int vz = scanner.nextInt();

        printPath(graph, sourceNode, vy);
        printPath(graph, sourceNode, vz);
    }

    private static void printPath(Graph graph, int s, int v) {
        Map<Integer, Integer> parent = bfs(graph, s);
        List<Integer> path = new ArrayList<>();
        int current = v;

        while (current != -1) {
            path.add(current);
            current = parent.get(current);
        }

        if (path.get(path.size() - 1) != s) {
            System.out.println("-1");
        } else {
            Collections.reverse(path);
            System.out.println(String.join(" ", path.stream().map(String::valueOf).toArray(String[]::new)));
        }
    }

    private static Map<Integer, Integer> bfs(Graph graph, int s) {
        Map<Integer, String> color = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= graph.getAdjList().size(); i++) {
            color.put(i, "white");
            parent.put(i, -1);
        }

        color.put(s, "gray");
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph.getAdjList().get(u)) {
                if (color.get(v).equals("white")) {
                    color.put(v, "gray");
                    parent.put(v, u);
                    queue.add(v);
                }
            }

            color.put(u, "black");
        }

        return parent;
    }
}
