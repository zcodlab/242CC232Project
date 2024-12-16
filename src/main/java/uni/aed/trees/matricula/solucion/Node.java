/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.trees.matricula.solucion;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author OTI-FC24
 */
public class Node<E>{
    E key;
    int filePosition;
    Node left;
    Node right;

    public Node(E key, int filePosition) {
        this.key = key;
        this.filePosition = filePosition;
        this.left=null;
        this.right=null;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setFilePosition(int filePosition) {
        this.filePosition = filePosition;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public E getKey() {
        return key;
    }

    public int getFilePosition() {
        return filePosition;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    private void print(StringBuilder buffer, 
        String prefix,String childrenPrefix){
        LinkedList<Node> children=new LinkedList<>();
        children.add(left);
        children.add(right);
        
        buffer.append(prefix);
        buffer.append("("+key.toString()+")");
        buffer.append('\n');
        
        for(Iterator<Node> it=children.iterator();it.hasNext();){
            Node next=it.next();
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
