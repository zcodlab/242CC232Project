package uni.aed.trees.experimentalTBT.start;

import java.util.Random;

public class ExperimentoArbolBinario {
    public static final int ALEATORIO_LIMITE=1000;
    public static final int NCOMBINACIONES=8;
    public static final int NOPERACIONES=10;
    public static void main(String[] args) {
        Random random1 = new Random();  
        Random random2 = new Random();  

        int[] alturas = {500, 1000, 1500, 2000};
        int numOperaciones = NOPERACIONES;
        
        for (int altura : alturas) {
            System.out.println("Ejecutando para altura: " + altura);
            ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
            crearArbolCompletoAleatorio(arbol, altura);            
            for (int combinacion = 0; combinacion < NCOMBINACIONES; combinacion++) {
                System.out.println("\nCombinación " + (combinacion + 1));                
                for (int i = 0; i < numOperaciones; i++) {                    
                    if (i % 2 == 0){
                        int valor = (combinacion % 2 == 0) ? random1.nextInt(altura * 2) : random2.nextInt(altura * 2);  // Alterna entre random1 y random2                    
                        arbol.insertar(valor);}
                    else {                        
                        int valorEliminar=(combinacion % 2 == 0) ? random2.nextInt(altura * 2) : random1.nextInt(altura * 2);                        
                        arbol.eliminarSimetrico(valorEliminar);                        
                    }                    
                    int ipl = arbol.calcularIPL();
                    System.out.println("Longitud de Ruta Interna (IPL): " + ipl);
                }
            }            
        }
    }
    
    public static void crearArbolCompletoAleatorio(ArbolBinarioBusqueda arbol, int alturaObjetivo) {     
        int totalNodos = (int) Math.pow(2, alturaObjetivo) - 1;
        for (int i = 0; i < totalNodos; i++) {
            int valor = (int) (Math.random() * ALEATORIO_LIMITE);
            arbol.insertar(valor);
        }
        System.out.println("Árbol completo aleatorio creado con altura: " + alturaObjetivo);
    }
}

