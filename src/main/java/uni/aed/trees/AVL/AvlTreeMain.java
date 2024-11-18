package uni.aed.trees.AVL;

public class AvlTreeMain {
    public static void main(String[] args){
        AvlTree tree=new AvlTree();
        System.out.println("Construyendo el arbol");
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(25);
        System.out.println("Visualizando el arbol");
        System.out.println(tree.root.toString());
        System.out.println("Realizando el recorrido preOrder");
        System.out.println(tree.preOrder(tree.root));
        System.out.println("Eliminando nodos en el arbol");
        tree.delete(20);
        System.out.println("Despues de Eliminar: Visualizando el arbol");
        System.out.println(tree.root.toString());
        System.out.println("Despues de Eliminar: Realizando el recorrido preOrder");
        System.out.println(tree.preOrder(tree.root));
    }
    
}
