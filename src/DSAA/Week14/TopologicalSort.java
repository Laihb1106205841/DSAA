package DSAA.Week14;

import java.util.*;

public class TopologicalSort {

    private static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        boolean[] inStack = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, visited, inStack, stack)) {
                    return Arrays.asList(-1);
                }
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited,
                               boolean[] inStack, Stack<Integer> stack) {
        visited[node] = true;
        inStack[node] = true;

        if (graph.containsKey(node)) {//has son
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    if (!dfs(graph, neighbor, visited, inStack, stack)) {
                        return false;
                    }
                } else if (inStack[neighbor]) {
                    return false; // Cycle detected
                }
            }
        }

        inStack[node] = false;
        stack.push(node);

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int vi = scanner.nextInt();
            int vj = scanner.nextInt();
            graph.computeIfAbsent(vi, k -> new ArrayList<>()).add(vj);
        }

        List<Integer> result = topologicalSort(graph, M);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}

