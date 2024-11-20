package uni.aed.trees.softwarestore;

public class Node<E> {
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
    
    
}
