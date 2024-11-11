package uni.aed.trees;

import uni.aed.queueTDA.LinkedQueueTDA;
import uni.aed.queueTDA.QueueTDA;

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
    //VLR
    public void preorder(StringBuilder str){
        preorder(root,str);
    }
    private void preorder(BSTNode p,StringBuilder str){
        if(p!=null){
            visit(p,str);
            preorder(p.getLeft(),str);            
            preorder(p.getRight(),str);
        }
    }
    //LRV
    public void postorder(StringBuilder str){
        postorder(root,str);
    }
    private void postorder(BSTNode p,StringBuilder str){
        if(p!=null){            
            postorder(p.getLeft(),str);            
            postorder(p.getRight(),str);
            visit(p,str);
        }
    }
    //recorrido primero en amplitud
    public void breadthFirst(StringBuilder str){
        BSTNode p=root;
        QueueTDA queue=new LinkedQueueTDA();
        if(p!=null){
            queue.enqueue(p);
            while(!queue.isEmpty()){
                p=(BSTNode)queue.dequeue();
                visit(p,str);
                if(p.getLeft()!=null)
                    queue.enqueue(p.getLeft());
                if(p.getRight()!=null)
                    queue.enqueue(p.getRight());
            }
        }
    }    
    public BSTNode search(int data){
        return search(root,data);
    }
    private BSTNode search(BSTNode p,int data){
        while(p!=null){
            if(p.getKey()==data)
                return p;
            else if(data<p.getKey())
                p=p.getLeft();
            else
                p=p.getRight();
        }
        return null;
    }
    
    public int deleteByCopying(int data){
        BSTNode tmp,node,p=root,prev=null,previous;
        //buscar el nodo a eliminar
        while(p!=null && p.getKey()!=data){
            prev=p;
            if(p.getKey()<data)
                p=p.getRight();
            else
                p=p.getLeft();                
        }
        node=p;
        if(p!=null && p.getKey()==data){//encontro el elemento a buscar
            if(node.getRight()==null)//no tiene hijo derecho
                node=node.getLeft();
            else if(node.getLeft()==null)//no tiene hijo izq
                node=node.getRight();
            else{//tiene 2 hijos
                tmp=node.getLeft();
                previous=node;
                while(tmp.getRight()!=null){//buscando el nodo del extremo derecho de la rama izq
                    previous=tmp;
                    tmp=tmp.getRight();
                }
                node.setKey(tmp.getKey());
                if(previous==node)
                    previous.setLeft(tmp.getLeft());
                else
                    previous.setRight(tmp.getLeft());
            }
            if(p==root)
                root=node;
            else if(prev.getLeft()==p)
                prev.setLeft(node);
            else
                prev.setRight(node);
        }
        else if(root!=null)
            return NOT_FOUND;//no encontro el elemento a eliminar
        else
            return IS_EMPTY;//arbol vacio
        return FOUND;
    }
    
    public int deleteByMerging(int data){
        BSTNode tmp,node,p=root,prev=null;
        //buscar el nodo a eliminar
        while(p!=null && p.getKey()!=data){
            prev=p;
            if(p.getKey()<data)
                p=p.getRight();
            else
                p=p.getLeft();                
        }
        node=p;
        if(p!=null && p.getKey()==data){
            if(node.getRight()==null)
                node=node.getLeft();
            else if(node.getLeft()==null)
                node=node.getRight();
            else{
                tmp=node.getLeft();
                while(tmp.getRight()!=null)
                    tmp=tmp.getRight();
                tmp.setRight(node.getRight());
                node=node.getLeft();                
            }
            if(p==root)
                root=node;
            else if(prev.getLeft()==p)
                prev.setLeft(node);
            else
                prev.setRight(node);
        }else if(root!=null)
            return NOT_FOUND;
        else
            return IS_EMPTY;
        return FOUND;
    }
    
}
