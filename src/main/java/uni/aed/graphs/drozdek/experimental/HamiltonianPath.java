package uni.aed.graphs.drozdek.experimental;
/*
algoritmo de camino hamiltoniano en grafos utilizando la técnica de vuelta atrás (backtracking):
En este programa, creamos una clase HamiltonianPath que toma como entrada una matriz de adyacencia graph que representa el grafo. Utilizamos el algoritmo de vuelta atrás (backtracking) para encontrar un camino hamiltoniano en el grafo.
El método findHamiltonianPath() inicia la búsqueda del camino hamiltoniano desde el primer vértice y llama al método hamiltonianPathUtil() para explorar las posibles combinaciones de vértices. Si se encuentra un camino hamiltoniano, se devuelve la lista de vértices que forman el camino. En caso contrario, se devuelve una lista vacía.
El método isSafe() verifica si un vértice v puede ser agregado al camino en la posición pos. Comprueba si el vértice no ha sido visitado anteriormente y si existe una arista entre el último vértice del camino y v.
En el método main(), creamos una instancia de HamiltonianPath con un grafo de ejemplo representado por una matriz de adyacencia. Luego llamamos a findHamiltonianPath() para encontrar un camino hamiltoniano y mostramos el resultado por consola.
Ten en cuenta que el algoritmo de camino hamiltoniano es NP-completo y no existe una solución eficiente para grafos grandes. El programa anterior proporciona una implementación básica y puede no ser eficiente para grafos de gran tamaño.
*/
import java.util.*;

public class HamiltonianPath {
    private int[][] graph;
    private int numVertices;
    private boolean[] visited;
    private List<Integer> path;

    public HamiltonianPath(int[][] graph) {
        this.graph = graph;
        this.numVertices = graph.length;
        this.visited = new boolean[numVertices];
        this.path = new ArrayList<>();
    }

    public List<Integer> findHamiltonianPath() {
        path.clear();
        Arrays.fill(visited, false);

        // Start from the first vertex
        path.add(0);
        visited[0] = true;

        if (hamiltonianPathUtil(1)) {
            return path;
        }

        // No Hamiltonian path found
        return Collections.emptyList();
    }

    private boolean hamiltonianPathUtil(int pos) {
        if (pos == numVertices) {
            // All vertices have been visited
            // Check if the last vertex is adjacent to the starting vertex
            int lastVertex = path.get(path.size() - 1);
            if (graph[lastVertex][0] == 1) {
                return true;  // Hamiltonian path found
            } else {
                return false; // Hamiltonian path not found
            }
        }

        // Try all vertices as the next vertex in the path
        for (int v = 1; v < numVertices; v++) {
            if (isSafe(v, pos)) {
                path.add(v);
                visited[v] = true;

                if (hamiltonianPathUtil(pos + 1)) {
                    return true;  // Hamiltonian path found
                }

                // Backtrack
                path.remove(path.size() - 1);
                visited[v] = false;
            }
        }

        return false; // Hamiltonian path not found
    }

    private boolean isSafe(int v, int pos) {
        // Check if vertex v can be added to the path
        // - It should not have been visited before
        // - There should be an edge between the last vertex in the path and v
        if (!visited[v] && graph[path.get(pos - 1)][v] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };

        HamiltonianPath hamiltonianPath = new HamiltonianPath(graph);
        List<Integer> path = hamiltonianPath.findHamiltonianPath();

        if (!path.isEmpty()) {
            System.out.println("Hamiltonian Path: " + path);
        } else {
            System.out.println("No Hamiltonian Path found");
        }
    }
}

