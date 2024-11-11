package uni.aed.trees;
public class BST {
    public static final int NOT_FOUND=-1;
    public static final int IS_EMPTY=0;
    public static final int FOUND=1;
            
    private BSTNode root;

    public BST() {
        this.root=null;
    }
    
    public void insert(int data){
        BSTNode p=root,prev=null;
        while(p!=null){
            prev=p;
            if(p.getKey()<data)
                p=p.getRight();
            else
                p=p.getLeft();                
        }
        if(root==null)
            root=new BSTNode(data);
        else if(prev.getKey()<data)
            prev.setRight(new BSTNode(data));
        else
            prev.setLeft(new BSTNode(data));
    }    
        
    public void visit(BSTNode p,StringBuilder str){
        if(p==null)
            str.append(NOT_FOUND);
        if(!str.isEmpty())
            str.append(",");
        str.append(p.getKey());
    }
    
    //LVR
    public void inorder(StringBuilder str){
        inorder(root,str);
    }
    private void inorder(BSTNode p,StringBuilder str){
        if(p!=null){
            inorder(p.getLeft(),str);
            visit(p,str);
            inorder(p.getRight(),str);
        }
    }
    
}
