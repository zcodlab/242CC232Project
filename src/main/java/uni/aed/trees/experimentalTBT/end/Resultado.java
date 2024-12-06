/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.trees.experimentalTBT.end;
/**
 *
 * Clase con la estructura para registrar resultados
 */
public class Resultado {    
    private Nodo raiz;
    private long hRequerida;
    private long initialHeight;
    private long initialIPL;
    private long initialNodeCount;
    private boolean initialBalance;
    private long finalHeight;
    private long finalIPL;
    private long finalNodeCount;
    private boolean finalBalance;

    public Resultado(Nodo raiz, long hRequerida, long initialHeight, long initialIPL, long initialNodeCount, boolean initialBalance, long finalHeight, long finalIPL, long finalNodeCount, boolean finalBalance) {
        this.raiz = raiz;
        this.hRequerida = hRequerida;
        this.initialHeight = initialHeight;
        this.initialIPL = initialIPL;
        this.initialNodeCount = initialNodeCount;
        this.initialBalance = initialBalance;
        this.finalHeight = finalHeight;
        this.finalIPL = finalIPL;
        this.finalNodeCount = finalNodeCount;
        this.finalBalance = finalBalance;
    }    

    public Nodo getRaiz() {
        return raiz;
    }   

    public long gethRequerida() {
        return hRequerida;
    }

    public long getInitialHeight() {
        return initialHeight;
    }

    public long getInitialIPL() {
        return initialIPL;
    }

    public long getInitialNodeCount() {
        return initialNodeCount;
    }

    public boolean isInitialBalance() {
        return initialBalance;
    }

    public long getFinalHeight() {
        return finalHeight;
    }

    public long getFinalIPL() {
        return finalIPL;
    }

    public long getFinalNodeCount() {
        return finalNodeCount;
    }

    public boolean isFinalBalance() {
        return finalBalance;
    }

    @Override
    public String toString() {
        return raiz.toString();
    }
    
    
}
