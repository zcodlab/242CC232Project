package uni.aed.graphs.drozdek.experimental;
/*
Árboles de Recubrimiento de Grafos utilizando el algoritmo de Kruskal:
En este programa, creamos un grafo y agregamos aristas con pesos utilizando el método addEdge(). Luego, utilizamos el método findMinimumSpanningTree() para encontrar el árbol de recubrimiento mínimo utilizando el algoritmo de Kruskal. El árbol de recubrimiento mínimo se almacena en una lista de objetos Edge, donde cada objeto Edge representa una arista en el árbol.
Finalmente, imprimimos las aristas del árbol de recubrimiento mínimo.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class GraphMinSpanningTree {
    private int vertices;
    private List<Edge> edges;

    public GraphMinSpanningTree(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        edges.add(edge);
    }

    public List<Edge> findMinimumSpanningTree() {
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Sort edges in ascending order by weight
        Collections.sort(edges, Comparator.comparingInt(Edge::getWeight));

        // Create a parent array for disjoint set
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int edgesAdded = 0;
        int index = 0;

        // Iterate through all edges and add to minimum spanning tree if it doesn't form a cycle
        while (edgesAdded < vertices - 1) {
            Edge edge = edges.get(index++);
            int sourceParent = find(parent, edge.getSource());
            int destinationParent = find(parent, edge.getDestination());

            if (sourceParent != destinationParent) {
                minimumSpanningTree.add(edge);
                union(parent, sourceParent, destinationParent);
                edgesAdded++;
            }
        }

        return minimumSpanningTree;
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int source, int destination) {
        parent[source] = destination;
    }

    static class Edge {
        private int source;
        private int destination;
        private int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }
    }
}

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int vertices = 6;
        GraphMinSpanningTree graph = new GraphMinSpanningTree(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        List<GraphMinSpanningTree.Edge> minimumSpanningTree = graph.findMinimumSpanningTree();

        System.out.println("Minimum Spanning Tree:");
        for (GraphMinSpanningTree.Edge edge : minimumSpanningTree) {
            System.out.println(edge.getSource() + " -- " + edge.getDestination() + " : " + edge.getWeight());
        }
    }
}
