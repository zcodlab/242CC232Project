package uni.aed.graphs.drozdek.experimental;
/*
algoritmo de Paseo Euleriano
En este programa, creamos una clase EulerianPath que toma como entrada una matriz de adyacencia graph que representa el grafo. Utilizamos el algoritmo de búsqueda en profundidad (DFS) para encontrar un paseo euleriano en el grafo.
El método findEulerianPath() encuentra un vértice de inicio para el paseo euleriano y luego llama al método dfs() para realizar la búsqueda en profundidad. En cada paso, visitamos una arista y la eliminamos del grafo.
El método findStartVertex() encuentra un vértice con grado impar en el grafo. Si no hay vértices con grado impar, cualquier vértice se puede seleccionar como inicio.
En el método main(), creamos una instancia de EulerianPath con un grafo de ejemplo representado por una matriz de adyacencia. Luego llamamos a findEulerianPath() para encontrar un paseo euleriano y mostramos el resultado por consola.
Es importante tener en cuenta que este programa asume que el grafo tiene un paseo euleriano. Si el grafo no cumple con esta propiedad, el resultado será un paseo vacío. Además, el programa asume que el grafo es no dirigido.
*/
import java.util.*;

public class EulerianPath {
    private int[][] graph;
    private int numVertices;
    private List<Integer> path;

    public EulerianPath(int[][] graph) {
        this.graph = graph;
        this.numVertices = graph.length;
        this.path = new ArrayList<>();
    }

    public List<Integer> findEulerianPath() {
        path.clear();

        // Find a vertex with an odd degree (if any)
        int startVertex = findStartVertex();
        if (startVertex == -1) {
            // All vertices have even degree, find any vertex as the start
            startVertex = 0;
        }

        // Perform a depth-first search to find the Eulerian path
        dfs(startVertex);

        // If the path does not include all edges, return an empty list
        if (path.size() != numVertices + 1) {
            return Collections.emptyList();
        }

        return path;
    }

    private void dfs(int v) {
        for (int u = 0; u < numVertices; u++) {
            if (graph[v][u] > 0) {
                // Visit the edge (v, u)
                graph[v][u]--;
                graph[u][v]--;
                dfs(u);
            }
        }
        path.add(v);
    }

    private int findStartVertex() {
        for (int v = 0; v < numVertices; v++) {
            int degree = 0;
            for (int u = 0; u < numVertices; u++) {
                degree += graph[v][u];
            }
            if (degree % 2 != 0) {
                return v;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };

        EulerianPath eulerianPath = new EulerianPath(graph);
        List<Integer> path = eulerianPath.findEulerianPath();

        if (!path.isEmpty()) {
            System.out.println("Eulerian Path: " + path);
        } else {
            System.out.println("No Eulerian Path found");
        }
    }
}

