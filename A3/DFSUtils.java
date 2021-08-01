package ca.neu;

public class DFSUtils {

    protected static void printVisited(int value) {
        System.out.print(" " + value);
    }
    
    
    protected static void runDFS(Character type, Node start, Graph graph){
        switch (type) {
            case 'I':
                DFSIterative.dfsWithoutRecursion(start, graph.getAdjVertices());
                break;
            case 'R':
                DFSRecursive.dfsRecursive(start, graph.getAdjVertices());
                break;
            case 'B':
                BFS.bfs(start, graph.getAdjVertices());
                break;
            default:
                System.out.println("No such option!");
                break;
        }
    }
}
