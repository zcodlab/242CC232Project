package uni.aed.tda.linkedlistTDA;

import uni.aed.tda.listTDA.IteratorTDA;
import uni.aed.tda.listTDA.ListTDA;

public class LinkedListTDA<E> implements ListTDA<E> {
    public static final int NO_ENCONTRADO=-1;
    private Nodo<E> head;
    private Nodo<E> cola;
    private int count;

    public LinkedListTDA() {
        clear();
    }

    @Override
    public void add(E data) {
        Nodo<E> newNodo=new Nodo<>(data);
        if(count==0)
            head=cola=newNodo;
        else{
            cola.setNext(newNodo);
            cola=newNodo;
        }
        count++;
    }

    @Override
    public void add(int index, E data) throws IndexOutOfBoundsException {
        revisaPosInsercion(index);
        Nodo apt=head;
        Nodo newNodo= new Nodo(data);
        if(index==0){
            newNodo.setNext(head);
            head=newNodo;
        }else{
            for(int i=1;i<index;i++)
                apt=apt.getNext();
            newNodo.setNext(apt.getNext());
            apt.setNext(newNodo);
        }
        if(index==count)
            cola=newNodo;
        count++;
    }
    
    protected void revisaPosInsercion(int index){
        if(index<0)
            throw new IndexOutOfBoundsException("Indice ingresado es invalido");
        else if(index>size())
            throw new IndexOutOfBoundsException("Indice es mayor al tamaño de la lista");            
    }
    private void revisaPosAcceso(int index){
        if(size()==0)
            throw new IndexOutOfBoundsException("Indice "+ index+" es invalido. Lista vacia");
        else if(index<0)
            throw new IndexOutOfBoundsException("Indice negativo de "+ index+" es invalido.");
        else if(index>size())
            throw new IndexOutOfBoundsException("Indice "+ index+ " es mayor que limite superior valido "+ size());        
    }
            

    @Override
    public void clear() {
        head=null;
        cola=null;
        count=0;
    }

    @Override
    public boolean contain(E data) {
        boolean resultado=true;
        int index=indexOf(data);
        if(index==NO_ENCONTRADO)
            resultado=false;
        return resultado;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        E data=null;
        Nodo apt=head;
        for(int i=0;i<index;i++)
            apt=apt.getNext();
        data=(E)apt.getData();
        return data;
    }

    @Override
    public int indexOf(E data) {
        int index=0;
        Nodo apt=head;
        while(index<count && !apt.getData().equals(data)){
            index++;
            apt=apt.getNext();
        }
        if(index==count)
            index=NO_ENCONTRADO;
        return index;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        Nodo nodoDelete;
        Nodo apt=head;        
        if(index==0){
            nodoDelete=apt;
            head=head.getNext();
            if(head==null)
                cola=null;            
        }
        else{
            for(int i=1;i<index;i++)
                apt=apt.getNext();
            nodoDelete=apt.getNext();
            apt.setNext(nodoDelete.getNext());
            if(apt.getNext()==null)
                cola=apt;
        }
        count--;        
        return (E)nodoDelete.getData();
    }

    @Override
    public boolean delete(E data) {
        boolean resultado=false;
        Nodo apt=head;
        Nodo huella=null;
        while(apt!=null && !apt.getData().equals(data)){
            huella=apt;
            apt=apt.getNext();
        }
        if(apt!=null){
            if(huella==null){
                head=head.getNext();
                if(head==null)
                    cola=null;
            }else{
                huella.setNext(apt.getNext());
                if(huella.getNext()==null)
                    cola=huella;
            }
        count--;
        resultado=true;        
        }
        return resultado;
    }

    @Override
    public E modify(int index, E data) throws IndexOutOfBoundsException {
        revisaPosAcceso(index);
        Nodo apt=head;
        for(int i=0;i<index;i++)
            apt=apt.getNext();
        E anterior=(E)apt.getData();
        apt.setData(data);
        return anterior;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Object[] toArray() {
        IteratorTDA it=new Iterador(head);
        Object[] newArray= new Object[size()];
        
        int i=0;
        while(it.hasNext())
            newArray[i++]= (Object)it.next();
        
        return newArray;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        IteratorTDA<E> it=new Iterador<>(head);
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append("->");
            str.append(it.next().toString());                        
        }
        return str.toString();
    }
    
    @Override
    public String toString(String patron) {
        StringBuilder str=new StringBuilder();
        IteratorTDA<E> it=new Iterador<>(head);
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append(patron);
            str.append(it.next().toString());                        
        }
        return str.toString();
    }
}
