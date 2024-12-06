package uni.aed.trees.experimentalTBT.end;

public class BSTManager {
    private BST bst;

    public BSTManager(boolean balanceado) {
        this.bst = new BST(balanceado);
    }

    public void setBst(BST bst) {
        this.bst = bst;
    }

    public BST getBst() {
        return bst;
    }
    
    // Inserta un valor en el árbol binario de búsqueda
    public void insertar(long valor) {
        bst.setRaiz(insertarRecursivo(bst.getRaiz(), valor));
    }

    private Nodo insertarRecursivo(Nodo nodo, long valor) {
        // Si el nodo está vacío, se inserta el nuevo valor
        if (nodo == null)
            nodo=new Nodo(valor);            
        else{        
            // Insertar en el subárbol izquierdo o derecho
            if (valor < nodo.getValor())
                nodo.setIzquierda(insertarRecursivo(nodo.getIzquierda(), valor));
            else if (valor > nodo.getValor())
                nodo.setDerecha(insertarRecursivo(nodo.getDerecha(), valor));
        }
        if (!bst.AVL) return nodo; else return balancearArbol(nodo);
    }

    // Eliminar un nodo simétricamente (reemplazando con el sucesor inorden)
    public void eliminarSimetrico(long valor) {
        bst.setRaiz(eliminarSimetricoRecursivo(bst.getRaiz(), valor));
    }

    private Nodo eliminarSimetricoRecursivo(Nodo nodo, long valor) {
        if (nodo == null) return null;        
        if (valor < nodo.getValor())
            nodo.setIzquierda(eliminarSimetricoRecursivo(nodo.getIzquierda(), valor));
        else if (valor > nodo.getValor())
            nodo.setDerecha(eliminarSimetricoRecursivo(nodo.getDerecha(), valor));
        else {
            if (nodo.getIzquierda() == null)
                return nodo.getDerecha();
            else if (nodo.getDerecha() == null)
                return nodo.getIzquierda();
            nodo.setValor(obtenerMinimo(nodo.getDerecha()).getValor());
            nodo.setDerecha(eliminarSimetricoRecursivo(nodo.getDerecha(), nodo.getValor()));
        }
        if (!bst.AVL) return nodo; else return balancearArbol(nodo);
    }

    // Eliminar un nodo asimétricamente (reemplazando con el único hijo si lo tiene)
    public void eliminarAsimetrico(long valor) {
        bst.setRaiz(eliminarAsimetricoRecursivo(bst.getRaiz(), valor));
    }

    private Nodo eliminarAsimetricoRecursivo(Nodo nodo, long valor) {
        if (nodo == null) return null;        
        if (valor < nodo.getValor())
            nodo.setIzquierda(eliminarAsimetricoRecursivo(nodo.getIzquierda(),valor));
        else if (valor > nodo.getValor())
            nodo.setDerecha(eliminarAsimetricoRecursivo(nodo.getDerecha(), valor));
        else {
            // Eliminar el nodo sin considerar el balanceo estricto
            if (nodo.getIzquierda() != null)
                return nodo.getIzquierda();  // Solo reemplazar por el hijo izquierdo si existe
            else
                return nodo.getDerecha();  // O por el hijo derecho si existe            
        }
        if (!bst.AVL) return nodo; else return balancearArbol(nodo);
    }

    // Calcular la Longitud de Ruta Interna (IPL)
    public long calcularIPL() {
        return calcularIPLRecursivo(bst.getRaiz(), 0);
    }

    private long calcularIPLRecursivo(Nodo nodo, long nivel) {
        if (nodo == null) return 0;        
        return nivel + calcularIPLRecursivo(nodo.getIzquierda(), nivel + 1) + calcularIPLRecursivo(nodo.getDerecha(), nivel + 1);
    }

    // Función para obtener el nodo con el valor mínimo
    private Nodo obtenerMinimo(Nodo nodo) {
        while (nodo.getIzquierda() != null)
            nodo = nodo.getIzquierda();        
        return nodo;
    }
    public long calculateHeight() {
        return calculateHeightRecursivo(bst.getRaiz());
    }
    // Método para calcular la altura del árbol de manera recursiva
    private long calculateHeightRecursivo(Nodo node) {
        if (node == null) return 0; // Si el nodo es nulo, su altura es 0
        // Retorna la altura máxima entre el subárbol izquierdo y derecho
        return 1 + Math.max(calculateHeightRecursivo(node.getIzquierda()), calculateHeightRecursivo(node.getDerecha()));
    }
   
    public long countNodes() {
        return countNodesRecursivo(bst.getRaiz());
    }
    // Método para contar el número total de nodos en el árbol
    private long countNodesRecursivo(Nodo node) {
        if (node == null) return 0; // Si el nodo es nulo, no hay nodos
        // Retorna 1 (el nodo actual) más el conteo de los nodos en los subárboles izquierdo y derecho
        return 1 + countNodesRecursivo(node.getIzquierda()) + countNodesRecursivo(node.getDerecha());
    }
    
    public boolean isBalanced() {
        return isBalancedRecursivo(bst.getRaiz());
    }
    // Método para verificar si el árbol está balanceado
    private boolean isBalancedRecursivo(Nodo node) {
        if (node == null) return true; // Si el nodo es nulo, el árbol es balanceado
        // Compara las alturas de los subárboles izquierdo y derecho
        long leftHeight = calculateHeightRecursivo(node.getIzquierda());
        long rightHeight = calculateHeightRecursivo(node.getDerecha());
        // El árbol está balanceado si la diferencia de alturas no es mayor a 1 y ambos subárboles son balanceados
        return Math.abs(rightHeight-leftHeight) <= 1 && isBalancedRecursivo(node.getIzquierda()) && isBalancedRecursivo(node.getDerecha());
    }
    
    ///balancea el arbol usando como root el nodo parametro
    private Nodo balancearArbol(Nodo root) {
        updateHeight(root);                
        long balance = updateFb(root);        
        if (balance > 1) {            
            if (Balance(root.getDerecha()) < 0) {                
                root.setDerecha(rotateRight(root.getDerecha()));
                return rotateLeft(root);
            } else
                return rotateLeft(root);            
        }
        if (balance < -1) {
            if (Balance(root.getIzquierda()) > 0) {                
                root.setIzquierda(rotateLeft(root.getIzquierda()));
                return rotateRight(root);
            } else
                return rotateRight(root);            
        }
        return root;
    }

    private void updateHeight(Nodo key) {
        key.setHeight(Math.max(Height(key.getIzquierda()), Height(key.getDerecha())) + 1);
    }

    //devuelve la altura desde el nodo key
    private long Height(Nodo key) {
        if (key == null)
            return 0;
        else
            return key.getHeight();
    }

    //devuelve la diferencia de alturas entre 2 nodos
    private long Balance(Nodo key) {
        if (key == null)
            return 0;
        else
            return (Height(key.getDerecha()) - Height(key.getIzquierda()));
    }
    //metodo que actualiza el factor de balance
    private long updateFb(Nodo key) {
        key.setFb(Balance(key));
        return key.getFb(); 
    }

    //rota hacia la izquierda desde el Nodo x
    private Nodo rotateLeft(Nodo x) {
        Nodo y = x.getDerecha();
        Nodo z = y.getIzquierda();
        y.setIzquierda(x);
        x.setDerecha(z);
        //actualiza las alturas
        updateHeight(x);
        updateHeight(y);
        //actualiza el factor de balance
        updateFb(x);
        updateFb(y);
        return y;
    }
    //rota hacia la derecha desde el Nodo y
    private Nodo rotateRight(Nodo y) {
        Nodo x = y.getIzquierda();
        Nodo z = x.getDerecha();
        x.setDerecha(y);
        y.setIzquierda(z);
        //actualiza las alturas
        updateHeight(y);
        updateHeight(x);
        //actualiza el factor de balance
        updateFb(y);
        updateFb(x);
        return x;
    }
    
    @Override
    public String toString() {
        return bst.getRaiz().toString();
    }
}
