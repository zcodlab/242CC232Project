package uni.aed.doublelinkedlist;
public class DoubleLinkedList {
    private DNodo head;
    private DNodo ultimo;
    private int lenght=0;

    public DNodo getNodo(int pos) {
        DNodo current=head;
        for(int i=0;i<pos;i++)
            current=current.getNext();
        return current;
    }
    
    
    //añadir elemento en la parte frontal de la lista
    public void addFirst(int data){
        DNodo newNodo=new DNodo(data);
        if(head==null){
            head=newNodo;
            ultimo=newNodo;
        }else{
            newNodo.setNext(head);
            head.setPrev(newNodo);
            head=newNodo;            
        }
        lenght++;
    }
    public void addLast(int data){
        DNodo newNodo=new DNodo(data);
        if(ultimo==null){
            head=newNodo;
            ultimo=newNodo;
        }else{
            newNodo.setPrev(ultimo);
            ultimo.setNext(newNodo);
            ultimo=newNodo;
        }
        lenght++;
    }
    public void remove(int data){
        DNodo current=head;
        //buscando el elemento a eliminar
        while(current!=null && current.getData()!=data)
            current=current.getNext();
        //encontro la data a eliminar
        if(current!=null){
            if(current==head){//si el nodo a eliminar es el primero de la lista
                head=head.getNext();
                if(head!=null)
                    head.setPrev(null);
                else
                    ultimo=null;
            }else if(current==ultimo){//si el nodo a eliminar es el ultimo de la lista
                ultimo=current.getPrev();
                ultimo.setNext(null);
            }else{//si el nodo a eliminar se encuentra en el cuerpo de la lista
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());                
            }
            lenght--;            
        }
    }
    public void clear(){
        head=null;
        ultimo=null;
        lenght=0;
    }
    public boolean isEmpty(){
        return(lenght==0);
    }
    public int size(){
        return lenght;
    }
    
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        DNodo current=head;
        while(current!=null){
            if(!str.isEmpty())
                str.append("<->");
            str.append(current.getData());
            current=current.getNext();
        }
        return str.toString();
    }
    
}
