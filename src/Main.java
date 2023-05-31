import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "D", 2);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 4);

        BreadthFirstSearch<String> bfsSearch = new BreadthFirstSearch<>(graph);
        DijkstraSearch<String> dijkstraSearch = new DijkstraSearch<>(graph);

        System.out.println("Path from A to E exists (BFS): " + bfsSearch.pathExist("A", "E"));
        System.out.println("Path from A to E exists (Dijkstra): " + dijkstraSearch.pathExist("A", "E"));

        List<String> bfsShortestPath = bfsSearch.findShortestPath("A", "E");
        List<String> dijkstraShortestPath = dijkstraSearch.findShortestPath("A", "E");

        if (bfsShortestPath != null) {
            System.out.println("Shortest path from A to E (BFS): " + bfsShortestPath);
        } else {
            System.out.println("Path from A to E does not exist (BFS)");
        }

        if (dijkstraShortestPath != null) {
            System.out.println("Shortest path from A to E (Dijkstra): " + dijkstraShortestPath);
        } else {
            System.out.println("Path from A to E does not exist (Dijkstra)");
        }
    }
}