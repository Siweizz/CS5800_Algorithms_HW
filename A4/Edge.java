package ca.neu;

public class Edge implements Comparable<Edge> {

    protected Node source;
    protected Node destination;
    protected int weight;

    public Edge(Node s, Node d, int w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

    public int compareTo(Edge otherEdge) {
        return this.weight > otherEdge.weight ? 1 : -1;
    }
}
