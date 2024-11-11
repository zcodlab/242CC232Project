package uni.aed.trees;

import java.util.Iterator;
import java.util.LinkedList;

public class BSTNode {
    private int key;
    private BSTNode left,right;

    public BSTNode() {
        left=right=null;
    }

    public BSTNode(int key) {
        this.key = key;
        this.left=null;
        this.right=null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }
    
    private void print(StringBuilder buffer, 
        String prefix,String childrenPrefix){
        LinkedList<BSTNode> children=new LinkedList<>();
        children.add(left);
        children.add(right);
        
        buffer.append(prefix);
        buffer.append(key);
        buffer.append('\n');
        
        for(Iterator<BSTNode> it=children.iterator();it.hasNext();){
            BSTNode next=it.next();
            if(next==null)
                continue;
            if(it.hasNext())
                next.print(buffer,childrenPrefix+"---",
                        childrenPrefix+"|   ");
            else
                next.print(buffer,childrenPrefix+"+++",
                        childrenPrefix+"   ");
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer=new StringBuilder();
        print(buffer,"","");
        return buffer.toString();
    }
    
}
