package ca.neu;

import java.util.*;

public class Graph {

    private static HashMap<Node, LinkedList<Node>> adjVertices;

    public static HashMap<Node, LinkedList<Node>> getAdjVertices() {
        return adjVertices;
    }

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(Node vertex) {
        adjVertices.putIfAbsent(vertex, new LinkedList<>());
    }

    public void addEdge(Node src, Node dest) {
        adjVertices.get(src).add(dest);
    }

}
