package ca.neu;

import java.util.LinkedList;

public class Node{

    protected int id;
    protected boolean visited;

    protected LinkedList<Edge> edges;

    public Node(int id) {
        this.id = id;
        this.visited = false;
        this.edges = new LinkedList<>();
    }

    protected boolean isVisited() {
        return visited;
    }

    protected void visit() {
        visited = true;
    }

}
