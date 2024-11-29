package uni.aed.graphs.drozdek.experimental;
/*
El problema del cartero chino es un problema de optimización que busca encontrar el recorrido más corto en un grafo dirigido o no dirigido, visitando cada arista al menos una vez.
Programa en Java que implementa el algoritmo de camino hamiltoniano para resolver el problema del cartero chino en un grafo no dirigido
Este programa utiliza una matriz de adyacencia para representar el grafo. 
Puedes ajustar la matriz grafo en el método main para adaptarlo a tu problema específico. 
El programa imprimirá la ruta óptima que el cartero debe seguir para recorrer todas las aristas al menos una vez.
*/
import java.util.ArrayList;
import java.util.List;

public class CarteroChinoHamiltoniano {
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        int[][] grafo = {
                {0, 10, 0, 30, 0},
                {10, 0, 20, 5, 10},
                {0, 20, 0, 0, 15},
                {30, 5, 0, 0, 20},
                {0, 10, 15, 20, 0}
        };

        List<Integer> rutaOptima = encontrarRutaOptima(grafo);
        System.out.println("Ruta óptima: " + rutaOptima);
    }

    public static List<Integer> encontrarRutaOptima(int[][] grafo) {
        int n = grafo.length;
        int[][] matrizRecorrido = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizRecorrido[i][j] = grafo[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrizRecorrido[i][k] + matrizRecorrido[k][j] < matrizRecorrido[i][j]) {
                        matrizRecorrido[i][j] = matrizRecorrido[i][k] + matrizRecorrido[k][j];
                    }
                }
            }
        }

        int[] grados = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grafo[i][j] != 0 && grafo[i][j] != INF) {
                    grados[i]++;
                    grados[j]++;
                }
            }
        }

        List<Integer> verticesImpares = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (grados[i] % 2 != 0) {
                verticesImpares.add(i);
            }
        }

        List<Integer> rutaOptima = new ArrayList<>();
        if (verticesImpares.size() > 0) {
            int inicio = verticesImpares.get(0);
            encontrarRutaHamiltoniana(matrizRecorrido, inicio, rutaOptima);
        } else {
            encontrarRutaHamiltoniana(matrizRecorrido, 0, rutaOptima);
        }

        return rutaOptima;
    }

    private static boolean encontrarRutaHamiltoniana(int[][] matrizRecorrido, int v, List<Integer> rutaOptima) {
        rutaOptima.add(v);

        if (rutaOptima.size() == matrizRecorrido.length) {
            return true;
        }

        for (int i = 0; i < matrizRecorrido.length; i++) {
            if (matrizRecorrido[v][i] != 0) {
                matrizRecorrido[v][i] = 0;
                matrizRecorrido[i][v] = 0;

                if (encontrarRutaHamiltoniana(matrizRecorrido, i, rutaOptima)) {
                    return true;
                }

                matrizRecorrido[v][i] = 1;
                matrizRecorrido[i][v] = 1;
            }
        }

        rutaOptima.remove(rutaOptima.size() - 1);
        return false;
    }
}
