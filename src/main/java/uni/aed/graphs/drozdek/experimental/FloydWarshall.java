package uni.aed.graphs.drozdek.experimental;
/*
En este ejemplo, se representa el grafo mediante una matriz de adyacencia. Los valores INF indican que no hay conexión directa entre los nodos. El algoritmo de Floyd-Warshall se encarga de encontrar las distancias mínimas entre todos los pares de nodos y actualiza la matriz de distancias dist en el proceso. Al final, se imprime la matriz de distancias mínimas resultante.
Es importante destacar que este código asume que no hay ciclos de peso negativo en el grafo, ya que el algoritmo de Floyd-Warshall no funciona correctamente en ese caso.
*/
public class FloydWarshall {

    public static final int INF = Integer.MAX_VALUE;

    public void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // Inicializar matriz de distancias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir las distancias mínimas
        System.out.println("Matriz de distancias mínimas:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*int[][] graph = {
            {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };*/
        int[][] graph = {
            {0, 2, INF, -4, INF},
            {INF, 0, -2, 1, 3},
            {INF, INF, 0, INF , 1},
            {INF, INF, INF, 0, 4},
            {INF, INF, INF, INF,0}
        };

        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(graph);
    }
}
