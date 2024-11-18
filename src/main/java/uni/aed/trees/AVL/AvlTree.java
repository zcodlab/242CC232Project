package uni.aed.trees.AVL;

public class AvlTree {
    AvlTreeNode root;
    
    public void add(int key){
        if(findAvlTreeNode(root,key)==null)
            root=BSTInsert(root,key);        
    }
    private AvlTreeNode BSTInsert(AvlTreeNode root,int key){
        if(root==null)
            return new AvlTreeNode(key);
        else if(key<root.key)
            root.left=BSTInsert(root.left,key);
        else
            root.right=BSTInsert(root.right,key);
        //validar el estado del arbol, si se encuentra balanceado o no
        return balanceTree(root);
    }
    private AvlTreeNode findAvlTreeNode(AvlTreeNode root,int key){
        if(root==null || key==root.key)
            return root;
        if(key<root.key)
            return findAvlTreeNode(root.left,key);
        else
            return findAvlTreeNode(root.right,key);
            
    }
    private AvlTreeNode balanceTree(AvlTreeNode root){
        updateHeight(root);
        int balance=Balance(root);
        if(balance>1){
            if(Balance(root.right)<0){
                root.right=rotateRight(root.right);
                return rotateLeft(root);
            }else
                return rotateLeft(root);
        }
        if(balance<-1){
            if(Balance(root.left)>0){
                root.left=rotateLeft(root.left);
                return rotateRight(root);
            }else
                return rotateRight(root);
        }
        return root;
    }
    private void updateHeight(AvlTreeNode key){
        key.height=Math.max(Height(key.left), Height(key.right))+1;
    }
    private int Height(AvlTreeNode key){
        if(key==null)
            return 0;
        else
            return key.height;
    }
    private int Balance(AvlTreeNode key){
        if(key==null)
            return 0;
        else
            return (Height(key.right)-Height(key.left));
    }
    private AvlTreeNode rotateLeft(AvlTreeNode x){
        AvlTreeNode y=x.right;
        AvlTreeNode z=y.left;
        y.left=x;
        x.right=z;
        updateHeight(x);
        updateHeight(y);
        return y;
    }
    private AvlTreeNode rotateRight(AvlTreeNode y){
        AvlTreeNode x=y.left;
        AvlTreeNode z=x.right;
        x.right=y;
        y.left=z;        
        updateHeight(y);
        updateHeight(x);            
        return x;
    }
    public String preOrder(AvlTreeNode node){//VLR
        StringBuilder tree=new StringBuilder();
        if(node!=null){
            tree.append(node.key);
            tree.append(",");
            tree.append(preOrder(node.left));
            tree.append(preOrder(node.right));
        }
        return tree.toString();            
    }
    public int search(int key){
        if(findAvlTreeNode(root,key)==null)
            return 0;
        else
            return 1;
    }
    public void delete(int key){
        if(findAvlTreeNode(root,key)!=null)
            root=Remove(root,key);
    }
    private AvlTreeNode Remove(AvlTreeNode root,int key){
        if(root==null)
            return root;
        else if(key<root.key)
            root.left=Remove(root.left,key);
        else if(key>root.key)
            root.right=Remove(root.right,key);
        else{
            if(root.right==null)
                root=root.left;
            else if(root.left==null)
                root=root.right;
            else{
                AvlTreeNode temp=Succesor(root.right);
                root.key=temp.key;
                root.right=Remove(root.right,root.key);
            }   
        }
        if(root==null)
            return root;
        else
            return balanceTree(root);                
    }
    private AvlTreeNode Succesor(AvlTreeNode root){
        if(root.left!=null)
            return Succesor(root.left);
        else
            return root;
    }
            
}
