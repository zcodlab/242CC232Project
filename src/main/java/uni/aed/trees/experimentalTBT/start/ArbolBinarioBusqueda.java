package uni.aed.trees.experimentalTBT.start;

public class ArbolBinarioBusqueda {
    private Nodo raiz;
    
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {        
        if (nodo == null)
            return new Nodo(valor);
        
        if (valor < nodo.valor)
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertarRecursivo(nodo.derecha, valor);        

        return nodo;
    }
    
    public void eliminarSimetrico(int valor) {
        raiz = eliminarSimetricoRecursivo(raiz, valor);
    }

    private Nodo eliminarSimetricoRecursivo(Nodo nodo, int valor) {
        if (nodo == null)
            return null;
        
        if (valor < nodo.valor)
            nodo.izquierda = eliminarSimetricoRecursivo(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = eliminarSimetricoRecursivo(nodo.derecha, valor);
        else {
            if (nodo.izquierda == null)
                return nodo.derecha;
            else if (nodo.derecha == null)
                return nodo.izquierda;
            
            nodo.valor = obtenerMinimo(nodo.derecha).valor;
            nodo.derecha = eliminarSimetricoRecursivo(nodo.derecha, nodo.valor);
        }
        return nodo;
    }
    
    public void eliminarAsimetrico(int valor) {
        raiz = eliminarAsimetricoRecursivo(raiz, valor);
    }

    private Nodo eliminarAsimetricoRecursivo(Nodo nodo, int valor) {
        if (nodo == null)
            return null;        
        if (valor < nodo.valor)
            nodo.izquierda = eliminarAsimetricoRecursivo(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = eliminarAsimetricoRecursivo(nodo.derecha, valor);
        else {            
            if (nodo.izquierda != null)
                return nodo.izquierda;
            else
                return nodo.derecha;
        }
        return nodo;
    }
    
    public int calcularIPL() {
        return calcularIPLRecursivo(raiz, 0);
    }

    private int calcularIPLRecursivo(Nodo nodo, int nivel) {
        if (nodo == null)
            return 0;        
        return nivel + calcularIPLRecursivo(nodo.izquierda, nivel + 1) + calcularIPLRecursivo(nodo.derecha, nivel + 1);
    }
    
    private Nodo obtenerMinimo(Nodo nodo) {
        while (nodo.izquierda != null)
            nodo = nodo.izquierda;        
        return nodo;
    }

    @Override
    public String toString() {
        return raiz.toString();
    }
    
}
