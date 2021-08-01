package ca.neu;

import java.lang.reflect.Array;
import java.util.*;

public class Dijkstra {

    public static void run(Node start, Node end, Boolean monotonic, Boolean reversed) {
        String typeOfMonotonicity = "";
        HashMap<Node, Node> changedAt = new HashMap<>();
        changedAt.put(start, null);

        HashMap<Node, Integer> shortestPathMap = new HashMap<>();
        List<Edge> allEdges = new ArrayList<>();

        for (Node node : Graph.nodes) {
            if (node == start) {
                shortestPathMap.put(start, 0);
            } else {
                //shortestPathMap.put(node, 1000);
                shortestPathMap.put(node, 1000);
            }
            allEdges.addAll(node.edges);
        }

        if (monotonic) {
            Collections.sort(allEdges);
            if (reversed) {
                Collections.reverse(allEdges);
                typeOfMonotonicity = " reversed";
            }
            findMonotonicPath(start, end, typeOfMonotonicity, changedAt, shortestPathMap, allEdges);
            return;
        }

        for (Edge edge : start.edges) {
            shortestPathMap.put(edge.destination, edge.weight);
            changedAt.put(edge.destination, start);
        }

        start.visit();

        while (true) {
            Node currentNode = nearestUnvisitedNode(shortestPathMap);
            if (currentNode == null) {
                throw new RuntimeException("There's no path between those two nodes");
            }

            if (currentNode == end) {
                System.out.println("The path with the smallest weight between " + start.id + " and " + end.id + " is: ");

                Node child = end;
                String path = String.valueOf(end.id);
                while (true) {
                    Node parent = changedAt.get(child);
                    if (parent == null) {
                        break;
                    }

                    path = parent.id + " " + path;
                    child = parent;
                }
                System.out.println("The total path cost is: " + shortestPathMap.get(end));
                System.out.println(path);
                return;
            }
            currentNode.visit();

            for (Edge edge : currentNode.edges) {
                if (edge.destination.isVisited())
                    continue;

                if (shortestPathMap.get(currentNode) + edge.weight < shortestPathMap.get(edge.destination)) {
                    shortestPathMap.put(edge.destination, shortestPathMap.get(currentNode) + edge.weight);
                    changedAt.put(edge.destination, currentNode);
                }
            }
        }
    }

    private static void findMonotonicPath(Node start, Node end, String typeOfMonotonicity, HashMap<Node, Node> changedAt, HashMap<Node, Integer> shortestPathMap, List<Edge> allEdges) {
        // TODO: Complete the method
        if (typeOfMonotonicity=="reversed")
        {
            return;
        }
        else
        {
            for (int i=0; i<shortestPathMap.size(); i++)
            {
                for (Edge edge_i : start.edges)
                {
                    //int weight=0;
                    if ( edge_i.destination.visited) continue;
                    edge_i.destination.visit();
                    if (edge_i.weight>shortestPathMap.get(edge_i.destination) || shortestPathMap.get(edge_i.destination)==1000)
                    {
                        shortestPathMap.put(edge_i.destination,edge_i.weight);
                    }
                    start=edge_i.destination;
                }

            }
        }

    }

    private static Node nearestUnvisitedNode(HashMap<Node, Integer> shortestPathMap) {
        // TODO: Complete the method
        int min=-1;
        Node res;
        Iterator<Node> iter1 = shortestPathMap.keySet().iterator();
        while(iter1.hasNext())
        {
            if (shortestPathMap.get(iter1)<min)
            {
                min=shortestPathMap.get(iter1);
                res=iter1.
            }
        }

        return null;
    }

    private static void edgerelax(Edge e, Integer[] distTo, Edge[] edgeTo)
    {
        Node v=e.source;
        Node w=e.destination;
        if (distTo[w.id]>distTo[v.id]+e.weight)
        {
            distTo[w.id]=distTo[v.id]+e.weight;
            edgeTo[w.id]=e;
        }
    }
    /*
    private static void vertexrelax(Edge e, Integer[] distTo, Edge[] edgeTo, Node v)
    {
        for (Edge e_i:v.edges)
        {
            Node w=e_i.destination;
            if (distTo[w.id]>distTo[v.id]+e.weight)
            {
                distTo[w.id]=distTo[v.id]+e.weight;
                edgeTo[w.id]=e;
            }
        }
    }

     */

}
