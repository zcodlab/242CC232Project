package uni.aed.trees;

public class BSTMain {
    public static void main(String[] args){
        BSTMain bSTMain=new BSTMain();
        bSTMain.insertBST();
    }
    
    private void insertBST(){        
        StringBuilder str=new StringBuilder();
        BST tree=new BST();
        tree.insert(15);
        tree.insert(4);
        tree.insert(20);
        tree.insert(17);
        tree.insert(19);
        
        System.out.println("Realizando una llamada inorder:LVR");
        tree.inorder(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando una llamada preorder:VLR");
        str.setLength(0);
        tree.preorder(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando una llamada postorder:LRV");
        str.setLength(0);
        tree.postorder(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando recorrido primero en amplitud");
        str.setLength(0);
        tree.breadthFirst(str);
        System.out.println(str.toString());
        
        System.out.println("Realizando la busqueda del nodo 17");
        str.setLength(0);
        tree.visit(tree.search(17), str);
        System.out.println(str.toString());
        
        System.out.println("Realizando la eliminacion por copiado 1F: nodo hoja 19");
        str.setLength(0);
        int result=tree.deleteByCopying(19);
        if(result!=1)
            System.out.println("El valor a eliminar no se ubico o el arbol esta vacio");
        tree.inorder(str);
        System.out.println(str.toString());
    }
}
