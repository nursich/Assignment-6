import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        validateVertex(source);
        validateVertex(destination);

        Edge<Vertex> edge = new Edge<>(source, destination, weight);
        adjacencyList.get(source).add(edge);
    }

    private void validateVertex(Vertex vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is not in the graph");
        }
    }

    public List<Edge<Vertex>> getAdjacentEdges(Vertex vertex) {
        validateVertex(vertex);
        return adjacencyList.get(vertex);
    }

    public Set<Vertex> getVertices() {
        return adjacencyList.keySet();
    }

}