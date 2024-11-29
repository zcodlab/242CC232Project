package uni.aed.graphs.drozdek.experimental;
/*
árbol de recubrimiento máximo - algoritmo de Edmonds
En este programa, creamos un grafo y agregamos aristas con pesos utilizando el método addEdge(). Luego, utilizamos el método findMaximumSpanningTree() para encontrar el árbol de recubrimiento máximo utilizando el algoritmo de Edmonds. El árbol de recubrimiento máximo se almacena en una lista de objetos Edge, donde cada objeto Edge representa una arista en el árbol.
Finalmente, imprimimos las aristas del árbol de recubrimiento máximo.
Es importante tener en cuenta que el algoritmo de recubrimiento máximo es más complejo que el algoritmo de recubrimiento mínimo, y puede tener múltiples soluciones óptimas. La implementación anterior es una de las muchas formas de implementar el algoritmo de recubrimiento máximo, y puede adaptarse según las necesidades específicas.
*/

import java.util.*;

class Graph {
    private int vertices;
    private List<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        edges.add(edge);
    }

    public List<Edge> findMaximumSpanningTree() {
        List<Edge> maximumSpanningTree = new ArrayList<>();

        // Sort edges in descending order by weight
        Collections.sort(edges, Comparator.comparingInt(Edge::getWeight).reversed());

        // Create a parent array for disjoint set
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            int sourceParent = find(parent, edge.getSource());
            int destinationParent = find(parent, edge.getDestination());

            if (sourceParent != destinationParent) {
                maximumSpanningTree.add(edge);
                union(parent, sourceParent, destinationParent);
            }
        }

        return maximumSpanningTree;
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

public class MaximumSpanningTree {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        List<Graph.Edge> maximumSpanningTree = graph.findMaximumSpanningTree();

        System.out.println("Maximum Spanning Tree:");
        for (Graph.Edge edge : maximumSpanningTree) {
            System.out.println(edge.getSource() + " -- " + edge.getDestination() + " : " + edge.getWeight());
        }
    }
}
