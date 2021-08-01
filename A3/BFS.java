package ca.neu;

import java.util.HashMap;
import java.util.LinkedList;

public class BFS {

    protected static void bfs(Node node, HashMap<Node, LinkedList<Node>> adjVertices) {
        // TODO: Implement your BFS method
        if (node == null)
            return;

        // Creating the queue, and adding the first node (step 1)
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentFirst = queue.removeFirst();

            if (currentFirst.visited)
                continue;

            // Mark the node as visited
            currentFirst.visit();
            System.out.print(currentFirst.id + " ");

            LinkedList<Node> allNeighbors = adjVertices.get(currentFirst);


            if (allNeighbors == null)
                continue;

            for (Node neighbor : allNeighbors) {
                // We only add unvisited neighbors
                if (!neighbor.visited) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
