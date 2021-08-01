package ca.neu;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        graph.addEdge(one, two, 33);
        graph.addEdge(one, six, 100);
        graph.addEdge(one, four, 2);
        graph.addEdge(two, three, 22);
        graph.addEdge(two, four, 5);
        graph.addEdge(three, five, 10);
        graph.addEdge(four, three, 1);
        graph.addEdge(four, six, 90 );
        graph.addEdge(six, seven, 110);
        graph.addEdge(seven, five, 280);

        //Dijkstra.run(one, five, false, false);
        Dijkstra.run(one, five, true, false);
        Dijkstra.run(one, five, true, true);
        MST.kruskalMST(graph);

    }
}
