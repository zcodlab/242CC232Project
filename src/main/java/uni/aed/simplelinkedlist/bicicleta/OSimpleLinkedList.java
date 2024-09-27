package uni.aed.simplelinkedlist.bicicleta;

public class OSimpleLinkedList {
    private static final int OUT_OF_LIMIT = -1;
    private static final int NOT_FOUND = -1;
    private static final int EXITO = 1;
    private ONodo head;
    private int lenght=0;
    
    //el metodo permite añadir un nodo en la parte frontal de la lista enlazada
    public void addFirst(Object data){
        ONodo newNodo=new ONodo(data);//se crea el nuevo nodo, indicado el valor
        newNodo.setNext(head);//se enlaza el nuevo nodo con el nodo al que apunta el head
        head=newNodo;//el head ahora apunta al nuevo nodo
        lenght++;//se incrementa el contador de nodos de la lista 
    }
    public void addLast(Object data){
        ONodo newNodo=new ONodo(data);
        if(head==null){
            head=newNodo;
            lenght++;
            return;
        }
        ONodo current=head;
        while(current.getNext()!=null)
            current=current.getNext();
        current.setNext(newNodo);
        lenght++;        
    }
    public void remove(Object data){
        if(head==null)
            return;
        //si el elemento a eliminar es el primer nodo
        if(((Comparable)head.getData()).compareTo(data)==0){
            head=head.getNext();
            lenght--;
            return;
        }
        //si el elemento a eliminar NO es el primer nodo
        ONodo current=head;
        while(current.getNext()!=null &&                
              ((Comparable)current.getNext().getData()).compareTo(data)!=0)
            current=current.getNext();
        //asumiendo que salio del bucle por que encontro el valor a eliminar
        if(current.getNext()!=null){
            current.setNext(current.getNext().getNext());
            lenght--;
        }
    }
    public int search(Object data){
        ONodo temp=head;
        boolean isFound=false;
        int index=0;
        while ((temp!=null) && isFound==false){
            if(((Comparable)temp.getData()).compareTo(data)==0)
                isFound=true;
            else{
                temp=temp.getNext();
                index++;
            }               
        }
        if(isFound)
            return index;
        else
            return NOT_FOUND;
                
    }
    public void clear(){
        head=null;
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
        ONodo current=head;
        while(current!=null){
            if(!str.isEmpty())
                str.append("->");
            str.append(current.getData().toString());
            current=current.getNext();
        }
        return str.toString();
    }
    //Resuelve Cap16-Ej7
    public String searchDuplicados(Object data){
        ONodo temp=head;
        StringBuilder str=new StringBuilder();
        int index=0;
        while (temp!=null){//mientras haya nodos en la lista
            if(((Comparable)temp.getData()).compareTo(data)==0){
                if(!str.isEmpty())
                    str.append(",");
                str.append(index);
            }            
            temp=temp.getNext();
            index++;            
        }
        if(str.isEmpty())
            str.append(NOT_FOUND);  //indicar de que no se ubico propietario con ese nombre      
        return str.toString();//retorna la lista de posiciones         
    }
}
