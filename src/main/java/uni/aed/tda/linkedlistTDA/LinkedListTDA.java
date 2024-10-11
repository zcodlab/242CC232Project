package uni.aed.tda.linkedlistTDA;

import uni.aed.tda.listTDA.IteratorTDA;
import uni.aed.tda.listTDA.ListTDA;

public class LinkedListTDA<E> implements ListTDA<E> {
    private Nodo<E> head;
    private Nodo<E> cola;
    private int count;

    public LinkedListTDA() {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        head=null;
        cola=null;
        count=0;                
    }

    @Override
    public boolean contain(E data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(E data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public E delete(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(E data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E modify(int index, E data) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        IteratorTDA it=new Iterador(head);
        while(it.hasNext()){
            if(!str.isEmpty())
                str.append("->");
            str.append(it.next().toString());                        
        }
        return str.toString();
    }
    
    
}
