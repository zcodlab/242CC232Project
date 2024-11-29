package uni.aed.graphs.drozdek.experimental;
/*
En este programa, el grafo dirigido se representa utilizando una lista de adyacencia donde cada índice de la lista 
representa un nodo y contiene una lista de sus nodos adyacentes. El algoritmo de ordenamiento topológico 
utiliza un enfoque basado en el grado de entrada de los nodos. Se realiza un recuento del grado de entrada 
para cada nodo y se coloca en una cola aquellos nodos que no tienen dependencias 
(grado de entrada igual a 0). Luego, se va extrayendo un nodo de la cola, se agrega al resultado 
y se reduce el grado de entrada de sus nodos adyacentes. Este proceso se repite 
hasta que se visitan todos los nodos o se detecta un ciclo en el grafo.
Al ejecutar el programa, se imprimirá el orden topológico de los nodos del grafo, 
si no se encuentra ningún ciclo. 
En caso de que exista un ciclo en el grafo, se imprimirá un mensaje indicándolo.
*/

import java.util.*;

public class TopologicalSort {

    public List<Integer> topologicalSort(List<List<Integer>> graph) {
        int n = graph.size();

        // Contador de grado de entrada de los nodos
        int[] inDegree = new int[n];
        for (List<Integer> neighbors : graph) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        // Cola para almacenar los nodos sin dependencias
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // Reducir el grado de entrada de los nodos adyacentes
            List<Integer> neighbors = graph.get(node);
            for (int neighbor : neighbors) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Verificar si existe un ciclo en el grafo
        if (result.size() != n) {
            System.out.println("El grafo contiene un ciclo");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 7; // Número de nodos en el grafo

        // Crear el grafo utilizando una lista de adyacencia
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Agregar las aristas al grafo (grafo dirigido)
        /*graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(5);
        graph.get(4).add(5);*/
        
        graph.get(0).add(2);
        graph.get(0).add(3);
        graph.get(1).add(4);
        graph.get(2).add(3);
        graph.get(2).add(5);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        graph.get(4).add(6);

        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> sortedOrder = topologicalSort.topologicalSort(graph);

        System.out.println("Orden topológico:");
        for (int node : sortedOrder) {
            System.out.print(node + " ");
        }
    }
}
