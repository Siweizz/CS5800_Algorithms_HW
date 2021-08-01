package ca.neu;

import java.util.*;

public class Graph {

    protected static Set<Node> nodes;

    public Graph() {
        nodes = new HashSet<>();
    }

    protected void addEdge(Node source, Node destination, int weight) {
        nodes.add(source);
        nodes.add(destination);

        checkForDuplicates(source, destination, weight);
    }

    private void checkForDuplicates(Node a, Node b, int weight) {
        for (Edge edge : a.edges) {
            if (edge.source == a && edge.destination == b) {
                edge.weight = weight;
                return;
            }
        }
        a.edges.add(new Edge(a, b, weight));
    }

    protected int numberOfEdgesInTheGraph() {
        int count = 0;
        for (Node node: nodes){
            count += node.edges.size();
        }
        return count;
    }

}