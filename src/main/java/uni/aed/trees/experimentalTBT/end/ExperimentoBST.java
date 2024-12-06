package uni.aed.trees.experimentalTBT.end;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase para ejecutar experimentos con árboles binarios de búsqueda.
 * Solucionario 4PC
 */
public class ExperimentoBST {

    public static final int ALEATORIO_LIMITE = 1000; // Límite superior para valores aleatorios
    public static final int NCOMBINACIONES = 8;     // Número de combinaciones
    public static final int NOPERACIONES = 1;      // Número de operaciones a realizar        
    private static final int[] ALTURAS = {4,8,16}; // Alturas objetivo para los árboles
    private static Scanner scr = new Scanner(System.in);
    private BSTManager bstMgr;
    private List<Resultado> tabla=new LinkedList<>();        
    
    public static void main(String[] args) {
        ExperimentoBST exp=new ExperimentoBST();
        exp.Menu();        
    }
    
    public void Menu() {        
        boolean salir = false;
        while (!salir) {            
            tabla.clear();
            System.out.println("\nMenu de Operaciones");
            System.out.println("1. Operaciones en Arbol BST");
            System.out.println("2. Operaciones en Arbol AVL");                        
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scr.nextInt();

            switch (opcion) {
                case 1:
                    subMenu(false);
                    break;
                case 2:
                    subMenu(true);
                    break;                
                case 3:
                    scr.close();
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }        
    }

    public void subMenu(boolean balanceado) {        
        boolean salir = false;        
        tabla.clear();
        while (!salir) {
            System.out.println("\nSubMenu de Operaciones");
            System.out.println("1. Crear bstMgr aleatorio de altura h");
            System.out.println("2. Alternar inserciones y eliminaciones");
            System.out.println("3. Ejecutar combinaciones y registrar resultados");
            System.out.println("4. Visualizar bstMgr y parametros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scr.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la altura deseada: ");
                    int h = scr.nextInt();
                    bstMgr = new BSTManager(balanceado);
                    crearArbolCompletoAleatorio(bstMgr, h);                    
                    break;
                case 2:
                    alternarOperaciones(balanceado);
                    break;
                case 3:
                    ejecutarCombinaciones(balanceado);
                    break;
                case 4:
                    visualizarResultados(bstMgr);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }        
    }

    public void crearArbolCompletoAleatorio(BSTManager bstMgr, int hRequerida) {
        long totalNodos = (long) Math.pow(2, hRequerida) - 1; // Número total de nodos en un árbol completo        

        for (long i = 0; i < totalNodos; i++) {            
            long valor= random(i,ALEATORIO_LIMITE);
            bstMgr.insertar(valor);
        }
        
        setInitParametrosTree(bstMgr,hRequerida);
        setFinalParametrosTree(bstMgr);
        actualizarTabla(bstMgr);
        visualizarResultados(bstMgr);
    }
    
    private long random(long low, long high) {
        return (long) Math.floor(Math.random() * (high - low + 1)) + low;
    }

    public void alternarOperaciones(boolean balanceado) {
        Random random1 = new Random();
        Random random2 = new Random();
        alternarOperacionesAleatorias(bstMgr,balanceado,random1,random2);
        setFinalParametrosTree(bstMgr);     
        actualizarTabla(bstMgr);
        visualizarResultados(bstMgr);
    }
    
    private void alternarOperacionesAleatorias(BSTManager bstMgr,boolean balanceado,Random random1,Random random2 ) {
        // Alternar inserciones y eliminaciones aleatorias
        // Realizar combinaciones de operaciones
        for (int combinacion = 0; combinacion < NCOMBINACIONES; combinacion++) {
            System.out.printf("\n--- Combinacion %d ---\n", combinacion + 1);
            for (int i = 0; i < NOPERACIONES; i++) {
                if (i % 2 == 0) { // Inserción
                    int valor = (combinacion % 2 == 0) ? random1.nextInt(ALEATORIO_LIMITE) : random2.nextInt(ALEATORIO_LIMITE);
                    bstMgr.insertar(valor);
                    System.out.printf("Insertado: %d%n", valor);
                } else { // Eliminación
                    long valorEliminar = (combinacion % 2 == 0) ? random2.nextInt(ALEATORIO_LIMITE) : random1.nextInt(ALEATORIO_LIMITE);                        
                    if(random2.nextBoolean()){
                        bstMgr.eliminarSimetrico(valorEliminar);
                        System.out.printf("Eliminado Simetrico: %d%n", valorEliminar);
                    }
                    else{
                        bstMgr.eliminarAsimetrico(valorEliminar);                        
                        System.out.printf("Eliminado Asimetrico: %d%n", valorEliminar);
                    }
                }
            }
        }
    }

    public void ejecutarCombinaciones(boolean balanceado) {
        Random random1 = new Random();
        Random random2 = new Random();        
        tabla.clear();
        for (int altura : ALTURAS) {
            System.out.println("\n--- Ejecutando combinaciones para altura: " + altura + " ---");
            BSTManager bstMgr = new BSTManager(balanceado);
            crearArbolCompletoAleatorio(bstMgr, altura);
            // Obtener parámetros iniciales
            setInitParametrosTree(bstMgr,altura); 
            // Realizar combinaciones de operaciones
            alternarOperacionesAleatorias(bstMgr,balanceado,random1,random2);
            // Obtener parámetros finales
            setFinalParametrosTree(bstMgr);
            actualizarTabla(bstMgr);
            System.out.println(bstMgr.toString());
        }        
        visualizarTabla();
    }

    public void visualizarResultados(BSTManager bstMgr) {
        // Visualización de la estructura del árbol
        if(bstMgr==null) return;
        System.out.println("\nEstructura del bstMgr:");
        System.out.println(bstMgr.toString());   
        visualizarTabla();
    }

    private void setInitParametrosTree(BSTManager bstMgr,int hRequerida){
        // Registrar los parámetros iniciales del árbol        
        bstMgr.getBst().sethRequerida(hRequerida);
        bstMgr.getBst().setInitialHeight(bstMgr.calculateHeight());
        bstMgr.getBst().setInitialIPL(bstMgr.calcularIPL());
        bstMgr.getBst().setInitialNodeCount(bstMgr.countNodes());
        bstMgr.getBst().setInitialBalance(bstMgr.isBalanced());        
    }
    private void setFinalParametrosTree(BSTManager bstMgr){
        // Registrar los parámetros iniciales del árbol
        bstMgr.getBst().setFinalHeight(bstMgr.calculateHeight());
        bstMgr.getBst().setFinalIPL(bstMgr.calcularIPL());
        bstMgr.getBst().setFinalNodeCount(bstMgr.countNodes());
        bstMgr.getBst().setFinalBalance(bstMgr.isBalanced());        
    }
    private void actualizarTabla(BSTManager bstMgr){ 
        tabla.add(new Resultado(bstMgr.getBst().getRaiz(),bstMgr.getBst().gethRequerida(),bstMgr.getBst().getInitialHeight(), 
                bstMgr.getBst().getInitialIPL(), bstMgr.getBst().getInitialNodeCount(), bstMgr.getBst().isInitialBalance(),
                bstMgr.getBst().getFinalHeight(), bstMgr.getBst().getFinalIPL(), bstMgr.getBst().getFinalNodeCount(), 
                bstMgr.getBst().isFinalBalance())
        );
    }
    private void visualizarTabla(){        
        for(Resultado r:tabla){
            System.out.println("bstMgr de h inicial:" + r.getInitialHeight());
            r.getRaiz().toString();
        }
         // Imprime los encabezados de la tabla para los resultados
        System.out.printf("%-10s %-10s %-12s %-12s %-15s %-10s %-12s %-12s %-15s\n",
                "h-requerida","h-inicial", "IPL-inicial", "n-nodos-inicial", "balance-inicial",
                "h-final", "IPL-final", "n-nodos-final", "balance-final");        

        // Imprimir los resultados en formato de tabla
        for(Resultado r:tabla)
            System.out.printf("%-10d %-10d %-12d %-12d %-15s %-10d %-12d %-12d %-15s\n",
        r.gethRequerida(), r.getInitialHeight(), r.getInitialIPL(), r.getInitialNodeCount(), r.isInitialBalance(),
        r.getFinalHeight(), r.getFinalIPL(), r.getFinalNodeCount(), r.isFinalBalance());
    }
}

