package DSAA.Week13;

import java.util.ArrayList;
import java.util.List;

public class BFS {
    class Node{
        private List<Node> adjacentList;
        private int num;
        private boolean visited;
    }
    class Graph{
        private List<Node> vertex;
    }
    public int bfs(Graph graph, Node start){
        ArrayList<Node> visitedVertex = new ArrayList<>();

        visitedVertex.add(start);
        int max = start.num;
        start.visited = true;

        while (!visitedVertex.isEmpty()){
            Node point = visitedVertex.get(0);
            max = Math.max(point.num,max);
            visitedVertex.remove(0);

            for(Node node: point.adjacentList){
                if(!node.visited){
                    visitedVertex.add(node);
                    node.visited = true;
                }
            }
        }

        return max;

    }

}
