package ADAS.Week10;


import java.util.*;

class Edge {
    int a, b;
    double v, p;

    public Edge(int a, int b, double v, double p) {
        this.a = a;
        this.b = b;
        this.v = v;
        this.p = p;
    }
}

public class QA {
    // weight = V - MP
//     对于每一个中间的比值 (R)，BF检查是否存在一个正权重的循环。
//     如果存在这样的循环，说明当前的 (R) 是可行的，我们应该尝试更高的 (R) 值。
//     如果不存在，我们应降低 (R) 值。
    static boolean hasPositiveCycle(int n, ArrayList<Edge> edges, double R) {
        double[] dist = new double[n + 1];

        // SPFA
        boolean[] inQueue = new boolean[n + 1];
        int[] count = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(dist, Double.NEGATIVE_INFINITY);
        for (int i = 1; i <= n; i++) {
            queue.add(i);
            inQueue[i] = true;
            dist[i] = 0;
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQueue[u] = false;
            for (Edge edge : edges) {
                if (edge.a == u) {
                    double w = edge.v - R * edge.p;
                    if (dist[u] + w > dist[edge.b]) {
                        dist[edge.b] = dist[u] + w;
                        if (!inQueue[edge.b]) {
                            queue.add(edge.b);
                            inQueue[edge.b] = true;
                            count[edge.b]++;
                            if (count[edge.b] > n) return true; // Found a positive cycle
                        }
                    }
                }
            }
        }
        return false;
    }

    static double findMaxRatio(int n, ArrayList<Edge> edges) {
        double left = 0, right = 200, bestRatio = -1;
        while (right - left > 1e-2) {
            double mid = (left + right) / 2;
            if (hasPositiveCycle(n, edges, mid)) {
                bestRatio = mid;
                left = mid;
            } else {
                right = mid;
            }
        }
        return bestRatio;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            double v = scanner.nextDouble();
            edges.add(new Edge(a, b, v, 0)); // Temporarily store v
        }
        for (int i = 0; i < m; ++i) {
            edges.get(i).p = scanner.nextDouble(); // Now read p
        }

        double maxRatio = findMaxRatio(n,  edges);

        if (maxRatio == -1)
            System.out.println("-1");
        else
            System.out.printf("%.1f\n", maxRatio);
        scanner.close();
    }
}
