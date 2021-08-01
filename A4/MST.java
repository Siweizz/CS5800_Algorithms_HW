package ca.neu;

import java.util.*;

public class MST {

    public static void kruskalMST(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.numberOfEdgesInTheGraph(), Comparator.comparingInt(o -> o.weight));

        for (Node node : Graph.nodes) {
            for (Edge edge : node.edges) {
                pq.add(edge);
            }
        }

        Map<Node, Node> parent = new HashMap<>();
        for (Node node : Graph.nodes) {
            parent.put(node, node);
        }

        ArrayList<Edge> mst = new ArrayList<>();

        //TODO: Pick the edge. Check if including this edge in spanning tree will form a cycle.
        // If Yes then ignore it otherwise add it to spanning tree. Repeat the step 2 till spanning tree has V-1.
        for(Node a : Graph.nodes){
            for(Node b : Graph.nodes){
                union(parent, a, b);
            }
        }



        System.out.println("Minimum Spanning Tree has " + mst.size() + " edges: ");
        printMST(mst);
    }

    public static Node find(Map<Node, Node> parent, Node node) {
        // TODO: To find the set that a node belongs to, follow the node's parent chain upwards until the root node:


        return null;
    }

    public static void union(Map<Node, Node> parent, Node x, Node y) {
        // TODO: If the two nodes of an edge are in different sets, combine these two sets into one.
        if(x == y)
            return;
        for (Node n : Graph.nodes) {
            for (Edge e : n.edges) {
                if((e.source == x && e.destination == y)||(e.source == x && e.destination == y))
                    parent.put(x, y);
            }
        }
    }

    public static void printMST(ArrayList<Edge> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            System.out.println("Edge #" + (i + 1) + " source: " + edge.source.id +
                    " destination: " + edge.destination.id +
                    " weight: " + edge.weight);
        }
    }
}
