package ca.neu;

import java.util.HashMap;
import java.util.LinkedList;

public class DFSRecursive {

    protected static void dfsRecursive(Node node, HashMap<Node, LinkedList<Node>> adjVertices) {
        node.visit();
        DFSUtils.printVisited(node.id);
        
        LinkedList<Node> allNeighbors = adjVertices.get(node);
        if (allNeighbors == null)
            return;

        for (Node neighbor : allNeighbors) {
            if (!neighbor.visited)
                dfsRecursive(neighbor, adjVertices);
        }
    }

}
