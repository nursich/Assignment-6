import java.util.*;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {

    private Map<Vertex, Vertex> parentMap;

    public BreadthFirstSearch(WeightedGraph<Vertex> graph) {
        super(graph);
        parentMap = new HashMap<>();
    }

    public List<Vertex> findShortestPath(Vertex source, Vertex destination) {
        parentMap = new HashMap<>();

        if (!pathExist(source, destination)) {
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

    @Override
    public boolean pathExist(Vertex source, Vertex destination) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.equals(destination)) {
                return true;
            }

            List<Edge<Vertex>> adjacentEdges = getGraph().getAdjacentEdges(current);
            for (Edge<Vertex> edge : adjacentEdges) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.offer(neighbor);

                }
            }
        }
        return false;
    }
}