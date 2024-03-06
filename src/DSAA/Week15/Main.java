package DSAA.Week15;

import java.util.*;

class Node {
    int vertex;
    long distance;

    public Node(int vertex, long distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}

class Graph {
    private int V;
    private List<List<Node>> adjList;

    public Graph(int V) {
        this.V = V;
        this.adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, long w) {
        adjList.get(u).add(new Node(v, w));
        adjList.get(v).add(new Node(u, w)); // Assuming undirected graph
    }

    public List<Integer> dijkstra(int source, int destination) {
        long[] distance = new long[V];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingLong(node -> node.distance));
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            for (Node neighbor : adjList.get(currentNode.vertex)) {
                long newDistance = distance[currentNode.vertex] + neighbor.distance;

                if (newDistance < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDistance;
                    minHeap.add(new Node(neighbor.vertex, newDistance));
                }
            }
        }

        // Reconstruct the path
        List<Integer> path = new ArrayList<>();
        int currentVertex = destination;

        while (currentVertex != source) {
            path.add(currentVertex + 1); // Adding 1 to convert to 1-based indexing
            for (Node neighbor : adjList.get(currentVertex)) {
                if (distance[currentVertex] == distance[neighbor.vertex] + neighbor.distance) {
                    currentVertex = neighbor.vertex;
                    break;
                }
            }
        }

        path.add(source + 1); // Adding the source vertex to the path
        Collections.reverse(path);
        return path;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt() - 1; // Adjusting to 0-based indexing
            int v = scanner.nextInt() - 1;
            long w = scanner.nextLong();
            graph.addEdge(u, v, w);
        }

        int source = scanner.nextInt() - 1; // Adjusting to 0-based indexing
        int destination = scanner.nextInt() - 1;

        List<Integer> path = graph.dijkstra(source, destination);

        // Output the path
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
    }
}
