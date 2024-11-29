package uni.aed.graphs.drozdek.experimental;
/*
En este programa, el grafo se representa utilizando una lista de adyacencia donde cada índice de la lista representa un nodo y contiene una lista de sus nodos adyacentes. El algoritmo de DFS utiliza la recursión para visitar los nodos en profundidad. Comenzando desde el nodo fuente, se marca como visitado, se imprime y se realiza una llamada recursiva para visitar todos sus nodos adyacentes no visitados. Este proceso se repite hasta que no quedan nodos por visitar.
Al ejecutar el programa, se imprimirá el recorrido primero en profundidad (DFS) del grafo, comenzando desde el nodo fuente especificado (en este caso, el nodo 0).
*/

import java.util.*;

public class DFS {

    public void dfs(List<List<Integer>> graph, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");

        List<Integer> neighbors = graph.get(source);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public void dfsTraversal(List<List<Integer>> graph, int source) {
        int n = graph.size();
        boolean[] visited = new boolean[n];

        System.out.println("Recorrido primero en profundidad (DFS):");
        dfs(graph, source, visited);
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

        DFS dfs = new DFS();
        dfs.dfsTraversal(graph, 0);
    }
}
