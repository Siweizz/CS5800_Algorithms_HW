package ca.neu;

public class Node {

    protected int id;
    protected boolean visited;

    Node(int id) {
        this.id = id;
        this.visited = false;
    }

    protected void visit() {
        visited = true;
    }

    protected void unvisit() {
        visited = false;
    }
    
}
