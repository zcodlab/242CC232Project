package uni.aed.trees.experimentalTBT.end;

public class BST {
    private static final int LONGITUD_CADENA=250000;
    protected boolean AVL=false;
    protected Nodo raiz;
    private long hRequerida;
    private long initialHeight;
    private long initialIPL;
    private long initialNodeCount;
    private boolean initialBalance;
    private long finalHeight;
    private long finalIPL;
    private long finalNodeCount;
    private boolean finalBalance;

    public BST(boolean avl) {
        this.AVL=avl;
    }

    public void sethRequerida(long hRequerida) {
        this.hRequerida = hRequerida;
    }
    
    public void setInitialHeight(long initialHeight) {
        this.initialHeight = initialHeight;
    }

    public void setInitialIPL(long initialIPL) {
        this.initialIPL = initialIPL;
    }

    public void setInitialNodeCount(long initialNodeCount) {
        this.initialNodeCount = initialNodeCount;
    }

    public void setInitialBalance(boolean initialBalance) {
        this.initialBalance = initialBalance;
    }

    public void setFinalHeight(long finalHeight) {
        this.finalHeight = finalHeight;
    }

    public void setFinalIPL(long finalIPL) {
        this.finalIPL = finalIPL;
    }

    public void setFinalNodeCount(long finalNodeCount) {
        this.finalNodeCount = finalNodeCount;
    }

    public void setFinalBalance(boolean finalBalance) {
        this.finalBalance = finalBalance;
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
    
    public Nodo getRaiz() {
        return raiz;
    }
    
    public void clear(){
        raiz=null;
    }
    
    @Override
    public String toString() {
        return raiz.toString();
    }
   
}
