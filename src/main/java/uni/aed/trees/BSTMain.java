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
    }
}
