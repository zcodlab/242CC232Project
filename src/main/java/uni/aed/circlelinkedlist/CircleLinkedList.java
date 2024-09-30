package uni.aed.circlelinkedlist;
import uni.aed.simplelinkedlist.Nodo;
public class CircleLinkedList {
    private Nodo head;
    private int lenght=0;
    
    public void addLast(int data){
        Nodo newNodo=new Nodo(data);
        if(head==null){
            head=newNodo;
            head.setNext(head);
            lenght++;
            return;
        }
        Nodo current=head;
        while(current.getNext()!=head)//considerando que se trata de una lista circular
            current=current.getNext();
        current.setNext(newNodo);
        newNodo.setNext(head);//aquie se esta enlazando con la cebecera de la lista, como resultado se tiene una lista circular
        lenght++;
    }
    public boolean search(int data){
        if(head==null)
            return false;
        Nodo current=head;
        do{
            if(current.getData()==data)
                return true;
            current=current.getNext();
        }while(current!=head);
        return false;
    }
    public void remove(int data){
        if(head==null)
            return;
        if(head.getData()==data){
            Nodo current=head;
            while(current.getNext()!=head)
                current=current.getNext();
            head=head.getNext();
            current.setNext(head);
            lenght--;
            return;
        }
        //asumiendo que el nodo a eliminar se encuentra en el cuerpo de la lista
        Nodo current=head;
        while(current.getNext()!=head
            && current.getNext().getData()!=data)
            current=current.getNext();
        //salio del bucle anterior porque encontro la data
        if(current.getNext()!=head){
            current.setNext(current.getNext().getNext());
            lenght--;
        }
        
    }
    public void clear(){
        head=null;
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
        Nodo current=head;
        do{
            if(!str.isEmpty())
                str.append("->");
            str.append(current.getData());
            current=current.getNext();
        }
        while(current!=head);                
        return "->"+str.toString()+"->";
    }
    
}
