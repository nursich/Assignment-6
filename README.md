# Assignment-6
# Graph Search Algorithms

This project implements two graph search algorithms, Breadth-First Search (BFS) and Dijkstra's algorithm, to find paths in a weighted graph. 
The code is written in Java and provides a `Search` class as the base class, `BreadthFirstSearch` class that extends `Search` for BFS, and 
`DijkstraSearch` class that extends `Search` for Dijkstra's algorithm.

## Features

- Breadth-First Search (BFS): It explores all the vertices of a graph in breadth-first order and determines if a path exists between two given vertices.
- Dijkstra's Algorithm: It finds the shortest path between two vertices in a weighted graph by considering the weights of the edges.

## Usage

1. Import the project into your Java IDE.
2. Create a `WeightedGraph` object and add vertices and weighted edges using the `addVertex` and `addEdge` methods.
3. Create an instance of `BreadthFirstSearch` or `DijkstraSearch`, passing the `WeightedGraph` object to the constructor.
4. Use the `pathExist` method to check if a path exists between two vertices.
5. Use the `findShortestPath` method to find the shortest path between two vertices.

## Example

Here's an example usage of the graph search algorithms:

```java
WeightedGraph<String> graph = new WeightedGraph<>();
// Add vertices and edges to the graph
BreadthFirstSearch<String> bfsSearch = new BreadthFirstSearch<>(graph);
DijkstraSearch<String> dijkstraSearch = new DijkstraSearch<>(graph);
boolean pathExists = bfsSearch.pathExist("A", "E");
List<String> shortestPath = bfsSearch.findShortestPath("A", "E");
if (pathExists) {
    System.out.println("Path exists!");
    System.out.println("Shortest path: " + shortestPath);
} else {
    System.out.println("Path does not exist!");
}
