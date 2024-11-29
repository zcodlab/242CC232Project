package uni.aed.graphs.drozdek.experimental;
/*
En este ejemplo, el grafo se representa mediante una matriz de adyacencia graph. Cada elemento graph[i][j] representa el peso de la arista entre los nodos i y j. El valor 0 indica que no hay arista entre los nodos.
El algoritmo de Dijkstra se aplica para encontrar las distancias mínimas desde un nodo fuente hasta todos los demás nodos del grafo. La implementación utiliza un arreglo dist para almacenar las distancias mínimas y un arreglo visited para marcar los nodos visitados durante el proceso. En cada iteración, se selecciona el nodo con la distancia mínima no visitado y se actualizan las distancias de los nodos adyacentes si es necesario.
Al final, se imprime la lista de distancias mínimas desde el nodo fuente especificado.
Es importante tener en cuenta que este programa asume que el grafo no contiene aristas con peso negativo.
*/
public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE;

    public void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        // Inicializar distancias y visitados
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            visited[i] = false;
        }
        // La distancia del nodo fuente hacia sí mismo es 0
        dist[source] = 0;
        // Aplicar el algoritmo de Dijkstra
        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        // Imprimir las distancias mínimas desde el nodo fuente
        System.out.println("Distancias mínimas desde el nodo fuente " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        // Convertir el grafo no dirigido a dirigido
        int[][] directedGraph = convertToDirectedGraph(graph);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(directedGraph, 0);
    }

    private static int[][] convertToDirectedGraph(int[][] graph) {
        int n = graph.length;
        int[][] directedGraph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                directedGraph[i][j] = graph[i][j];
                directedGraph[j][i] = graph[i][j];
            }
        }

        return directedGraph;
    }
}
