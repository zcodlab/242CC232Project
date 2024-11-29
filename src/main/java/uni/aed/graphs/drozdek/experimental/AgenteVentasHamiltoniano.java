package uni.aed.graphs.drozdek.experimental;
/*

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgenteVentasHamiltoniano {

    private static int[][] grafo;
    private static int numNodos;
    private static List<Integer> rutaOptima;
    private static boolean[] visitado;

    public static void main(String[] args) {
        numNodos = 4;
        grafo = new int[numNodos][numNodos];
        visitado = new boolean[numNodos];
        rutaOptima = new ArrayList<>();

        // Inicializar grafo
        grafo[0][1] = 10;
        grafo[0][2] = 15;
        grafo[0][3] = 20;
        grafo[1][0] = 10;
        grafo[1][2] = 35;
        grafo[1][3] = 25;
        grafo[2][0] = 15;
        grafo[2][1] = 35;
        grafo[2][3] = 30;
        grafo[3][0] = 20;
        grafo[3][1] = 25;
        grafo[3][2] = 30;

        // Inicializar visitado
        Arrays.fill(visitado, false);

        // Empezar en el nodo 0
        visitado[0] = true;
        rutaOptima.add(0);

        encontrarRutaOptima(0);

        System.out.println("Ruta óptima: " + rutaOptima);
    }

    private static void encontrarRutaOptima(int nodoActual) {
        if (rutaOptima.size() == numNodos) {
            // Se ha visitado todos los nodos, regresar al nodo inicial
            rutaOptima.add(0);
            return;
        }

        int siguienteNodo = -1;
        int distanciaMinima = Integer.MAX_VALUE;

        for (int i = 0; i < numNodos; i++) {
            if (!visitado[i] && grafo[nodoActual][i] != 0 && grafo[nodoActual][i] < distanciaMinima) {
                siguienteNodo = i;
                distanciaMinima = grafo[nodoActual][i];
            }
        }

        if (siguienteNodo != -1) {
            visitado[siguienteNodo] = true;
            rutaOptima.add(siguienteNodo);
            encontrarRutaOptima(siguienteNodo);
        } else {
            // No hay un siguiente nodo válido, regresar al nodo anterior
            rutaOptima.remove(rutaOptima.size() - 1);
            encontrarRutaOptima(rutaOptima.get(rutaOptima.size() - 1));
        }
    }
}
