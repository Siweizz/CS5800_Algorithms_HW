package ca.neu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DFSIterative {

    protected static void dfsWithoutRecursion(Node start, HashMap<Node, LinkedList<Node>> adjVertices) {
        // TODO: Implement iterative DFS

        Stack<Node> stack = new Stack<Node>();
        stack.push(start);

        while (!stack.isEmpty()) {
            // pop and visit
            Node current = stack.pop();

            if (!current.visited) {
                current.visit();
                DFSUtils.printVisited(current.id);
            }
            // push neighbors to the stack
            for (Node dest : adjVertices.get(current)) {
                if (!dest.visited) {
                    stack.push(dest);
                }
            }
        }
    }
}
