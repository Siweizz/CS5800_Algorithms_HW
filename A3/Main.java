package ca.neu;

import java.util.Scanner;

public class Main {

    private static Graph graph = new Graph();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        graph.addVertex(zero);
        graph.addVertex(one);
        graph.addVertex(two);
        graph.addVertex(three);
        graph.addVertex(four);
        graph.addVertex(five);
        graph.addVertex(six);
        graph.addVertex(seven);
        graph.addVertex(eight);

        graph.addEdge(one,zero);
        graph.addEdge(three,one);
        graph.addEdge(two,seven);
        graph.addEdge(two,four);
        graph.addEdge(five,two);
        graph.addEdge(five,zero);
        graph.addEdge(six,five);
        graph.addEdge(six,three);
        graph.addEdge(six,eight);
        graph.addEdge(seven,five);
        graph.addEdge(seven,six);
        graph.addEdge(seven,eight);
        System.out.println("Recursive (R) or Iterative (I) or BFS (B)?");
        DFSUtils.runDFS(reader.next(".").charAt(0), seven, graph);
        
    }

}
