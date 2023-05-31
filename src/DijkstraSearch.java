import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private Map<Vertex, Integer> distance;
    private Map<Vertex, Vertex> parentMap;

    public DijkstraSearch(WeightedGraph<Vertex> graph) {
        super(graph);
    }

    public List<Vertex> findShortestPath(Vertex source, Vertex destination) {
        calculateShortestDistances(source);

        if (!distance.containsKey(destination)) {
            return null;
        }

        List<Vertex> path = new ArrayList<>();
        Vertex current = destination;
        while (!current.equals(source)) {
            path.add(0, current);
            current = parentMap.get(current);
        }
        path.add(0, source);

        return path;
    }

    private void calculateShortestDistances(Vertex source) {
        distance = new HashMap<>();
        parentMap = new HashMap<>();

        for (Vertex vertex : getGraph().getVertices()) {
            distance.put(vertex, Integer.MAX_VALUE);
        }

        distance.put(source, 0);
        parentMap.put(source, null);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            List<Edge<Vertex>> adjacentEdges = getGraph().getAdjacentEdges(current);
            for (Edge<Vertex> edge : adjacentEdges) {
                Vertex neighbor = edge.getDestination();
                int weight = (int) edge.getWeight();
                int newDistance = distance.get(current) + weight;

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    parentMap.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
    }
}