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
        bst.raiz = insertarRecursivo(bst.raiz, valor);        
    }

    private Nodo insertarRecursivo(Nodo nodo, long valor) {
        // Si el nodo está vacío, se inserta el nuevo valor
        if (nodo == null)
            nodo=new Nodo(valor);
            //return new Nodo(valor);
        else{        
            // Insertar en el subárbol izquierdo o derecho
            if (valor < nodo.valor)
                nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
            else if (valor > nodo.valor)
                nodo.derecha = insertarRecursivo(nodo.derecha, valor);            
        }
        if (!bst.AVL) return nodo; else return balancearArbol(nodo);
    }

    // Eliminar un nodo simétricamente (reemplazando con el sucesor inorden)
    public void eliminarSimetrico(long valor) {
        bst.raiz  = eliminarSimetricoRecursivo(bst.raiz , valor);
    }

    private Nodo eliminarSimetricoRecursivo(Nodo nodo, long valor) {
        if (nodo == null) return null;
        
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
        if (!bst.AVL) return nodo; else return balancearArbol(nodo);
    }

    // Eliminar un nodo asimétricamente (reemplazando con el único hijo si lo tiene)
    public void eliminarAsimetrico(long valor) {
        bst.raiz = eliminarAsimetricoRecursivo(bst.raiz, valor);
    }

    private Nodo eliminarAsimetricoRecursivo(Nodo nodo, long valor) {
        if (nodo == null) return null;        
        if (valor < nodo.valor)
            nodo.izquierda = eliminarAsimetricoRecursivo(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = eliminarAsimetricoRecursivo(nodo.derecha, valor);
        else {
            // Eliminar el nodo sin considerar el balanceo estricto
            if (nodo.izquierda != null)
                return nodo.izquierda;  // Solo reemplazar por el hijo izquierdo si existe
            else
                return nodo.derecha;  // O por el hijo derecho si existe            
        }
        if (!bst.AVL) return nodo; else return balancearArbol(nodo);
    }

    // Calcular la Longitud de Ruta Interna (IPL)
    public long calcularIPL() {
        return calcularIPLRecursivo(bst.raiz, 0);
    }

    private long calcularIPLRecursivo(Nodo nodo, long nivel) {
        if (nodo == null) return 0;        
        return nivel + calcularIPLRecursivo(nodo.izquierda, nivel + 1) + calcularIPLRecursivo(nodo.derecha, nivel + 1);
    }

    // Función para obtener el nodo con el valor mínimo
    private Nodo obtenerMinimo(Nodo nodo) {
        while (nodo.izquierda != null)
            nodo = nodo.izquierda;        
        return nodo;
    }
    public long calculateHeight() {
        return calculateHeightRecursivo(bst.raiz);
    }
    // Método para calcular la altura del árbol de manera recursiva
    private long calculateHeightRecursivo(Nodo node) {
        if (node == null) return 0; // Si el nodo es nulo, su altura es 0
        // Retorna la altura máxima entre el subárbol izquierdo y derecho
        return 1 + Math.max(calculateHeightRecursivo(node.izquierda), calculateHeightRecursivo(node.derecha));
    }
   
    public long countNodes() {
        return countNodesRecursivo(bst.raiz);
    }
    // Método para contar el número total de nodos en el árbol
    private long countNodesRecursivo(Nodo node) {
        if (node == null) return 0; // Si el nodo es nulo, no hay nodos
        // Retorna 1 (el nodo actual) más el conteo de los nodos en los subárboles izquierdo y derecho
        return 1 + countNodesRecursivo(node.izquierda) + countNodesRecursivo(node.derecha);
    }
    
    public boolean isBalanced() {
        return isBalancedRecursivo(bst.raiz);
    }
    // Método para verificar si el árbol está balanceado
    private boolean isBalancedRecursivo(Nodo node) {
        if (node == null) return true; // Si el nodo es nulo, el árbol es balanceado
        // Compara las alturas de los subárboles izquierdo y derecho
        long leftHeight = calculateHeightRecursivo(node.izquierda);
        long rightHeight = calculateHeightRecursivo(node.derecha);
        // El árbol está balanceado si la diferencia de alturas no es mayor a 1 y ambos subárboles son balanceados
        return Math.abs(rightHeight-leftHeight) <= 1 && isBalancedRecursivo(node.izquierda) && isBalancedRecursivo(node.derecha);
    }
    
    ///balancea el arbol usando como root el nodo parametro
    private Nodo balancearArbol(Nodo root) {
        updateHeight(root);                
        long balance = updateFb(root);        
        if (balance > 1) {            
            if (Balance(root.derecha) < 0) {                
                root.derecha = rotateRight(root.derecha);
                return rotateLeft(root);
            } else
                return rotateLeft(root);            
        }
        if (balance < -1) {
            if (Balance(root.izquierda) > 0) {                
                root.izquierda = rotateLeft(root.izquierda);
                return rotateRight(root);
            } else
                return rotateRight(root);            
        }
        return root;
    }

    private void updateHeight(Nodo key) {
        key.height = Math.max(Height(key.izquierda), Height(key.derecha)) + 1;
    }

    //devuelve la altura desde el nodo key
    private long Height(Nodo key) {
        if (key == null)
            return 0;
        else
            return key.height;
    }

    //devuelve la diferencia de alturas entre 2 nodos
    private long Balance(Nodo key) {
        if (key == null)
            return 0;
        else
            return (Height(key.derecha) - Height(key.izquierda));
    }
    //metodo que actualiza el factor de balance
    private long updateFb(Nodo key) {
        key.fb = Balance(key);
        return key.fb; 
    }

    //rota hacia la izquierda desde el Nodo x
    private Nodo rotateLeft(Nodo x) {
        Nodo y = x.derecha;
        Nodo z = y.izquierda;
        y.izquierda = x;
        x.derecha = z;
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
        Nodo x = y.izquierda;
        Nodo z = x.derecha;
        x.derecha = y;
        y.izquierda = z;
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
        return bst.raiz.toString();
    }
}
