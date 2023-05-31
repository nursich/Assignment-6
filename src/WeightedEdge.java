public class WeightedEdge {

    private Vertex destination;
    private int weight;

    public WeightedEdge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}