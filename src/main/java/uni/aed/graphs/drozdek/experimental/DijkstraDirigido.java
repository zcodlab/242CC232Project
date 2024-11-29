package uni.aed.graphs.drozdek.experimental;
/*
Este programa es similar al ejemplo anterior, pero no se necesita convertir el grafo a un grafo dirigido, ya que el grafo de entrada graph es un grafo dirigido. La diferencia principal radica en cómo se exploran los nodos adyacentes en el bucle principal del algoritmo de Dijkstra. En este caso, se verifica la existencia de una arista del nodo actual (u) al nodo adyacente (v) y se actualiza la distancia mínima solo si es menor que la distancia actual. La función minDistance también se modifica ligeramente para manejar el caso de grafo dirigido.
Al ejecutar el programa, se imprimirán las distancias mínimas desde el nodo fuente especificado en el grafo dirigido.
*/
public class DijkstraDirigido {   
    private static final int INF = Integer.MAX_VALUE;
    
    public void dijkstra(int[][] graph, int source) {
        int n = graph.length; int[] dist = new int[n]; boolean[] visited = new boolean[n];
        // Inicializar distancias y visitados
        for (int i = 0; i < n; i++) { dist[i] = INF; visited[i] = false;}
        // La distancia del nodo fuente hacia sí mismo es 0
        dist[source] = 0;
        // Aplicar el algoritmo de Dijkstra
        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited); visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];}}}
        // Imprimir las distancias mínimas desde el nodo fuente
        System.out.println("Distancias mínimas desde el nodo fuente " + source + ":");
        for (int i = 0; i < n; i++)
            System.out.println(i + "\t\t" + dist[i]);}
    private int minDistance(int[] dist, boolean[] visited) {
        int min = INF; int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i]; minIndex = i;
            }}
        return minIndex;}

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {0, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 0, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 0, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 0, 0, 10, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 6},
            {0, 0, 0, 0, 0, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 0);
    }
}
