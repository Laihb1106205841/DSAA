package ADAS.Week6.B;



import java.util.*;

class Edge {
    int to, cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
class PrimMSTDirected {
    static int INF = 1000000007;



    static int primMST(int n, List<List<Edge>> graph,int start) {
        int minCost = 0;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.offer(new Edge(start, 0)); // Start from node start

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.to;
            int cost = edge.cost;

//            if (visited[u]) continue;
            visited[u] = true;
            minCost += cost;

            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.to;
                int c = neighbor.cost;
                if (c < minDist[v]) {
                    minDist[v] = c;
                    pq.offer(new Edge(v, c));
                }
            }
        }

        return minCost;
    }

//    public static void main(String[] args) {
//        int n = 5; // Number of nodes
//        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        // Add directed edges to the graph
//        graph.get(0).add(new Edge(1, 1));
//        graph.get(0).add(new Edge(2, 2));
//        graph.get(1).add(new Edge(3, 3));
//        graph.get(1).add(new Edge(4, 4));
//        graph.get(2).add(new Edge(3, 5));
//        graph.get(2).add(new Edge(4, 6));
//        graph.get(3).add(new Edge(0, 7));
//        graph.get(3).add(new Edge(1, 8));
//        graph.get(4).add(new Edge(0, 9));
//        graph.get(4).add(new Edge(2, 10));
//
//        int minCost = primMST(n, graph);
//        System.out.println("Minimum cost of Minimum Spanning Forest: " + minCost);
//    }
}
public class Main {
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

            Edge edge = new Edge(des,cost);
            graph.get(start).add(edge);
        }
        int mini = Integer.MAX_VALUE;
        int key = 0;

        int imp = 0;

        for(int i =0;i<N;i++){
            int min = PrimMSTDirected.primMST(N,graph,i);
            if(min == -1){
                imp+=1;
                continue;
            }
            if(min < mini){
                mini = min;
                key = i;
            }
        }

        if(imp == N){
            System.out.println("impossible");
        }else {
            System.out.println(mini+" "+key);
        }
    }
}


