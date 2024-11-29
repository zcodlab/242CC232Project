package uni.aed.graphs.drozdek.experimental;
/*
En este programa, el grafo se representa utilizando una lista de adyacencia donde cada índice de la lista representa un nodo y contiene una lista de sus nodos adyacentes. El algoritmo de BFS utiliza una cola para almacenar los nodos que se visitarán. Comenzando desde el nodo fuente, se marca como visitado y se agrega a la cola. Luego, mientras la cola no esté vacía, se extrae un nodo de la cola, se imprime y se agregan sus nodos adyacentes no visitados a la cola. Este proceso se repite hasta que no quedan nodos por visitar.
Al ejecutar el programa, se imprimirá el recorrido primero en amplitud (BFS) del grafo, comenzando desde el nodo fuente especificado (en este caso, el nodo 0).
*/
import java.util.*;

public class BFS {

    public void bfs(List<List<Integer>> graph, int source) {
        int n = graph.size();
        boolean[] visited = new boolean[n];

        // Crear una cola para almacenar los nodos a visitar
        Queue<Integer> queue = new LinkedList<>();

        // Marcar el nodo fuente como visitado y agregarlo a la cola
        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            // Obtener el siguiente nodo de la cola
            int node = queue.poll();
            System.out.print(node + " ");

            // Obtener los nodos adyacentes del nodo actual
            List<Integer> neighbors = graph.get(node);

            // Recorrer los nodos adyacentes no visitados
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 7; // Número de nodos en el grafo

        // Crear el grafo utilizando una lista de adyacencia
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Agregar las aristas al grafo (grafo no dirigido)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(5);
        graph.get(2).add(6);

        BFS bfs = new BFS();
        System.out.println("Recorrido primero en amplitud (BFS):");
        bfs.bfs(graph, 0);
    }
}

