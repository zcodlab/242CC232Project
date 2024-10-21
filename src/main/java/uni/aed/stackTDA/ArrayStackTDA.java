package uni.aed.stackTDA;

public class ArrayStackTDA<E> implements StackTDA<E>{
    private static final int TAM_DEFINIDO=10;
    private E[] elementos;
    private int count;

    public ArrayStackTDA() {
        this(TAM_DEFINIDO);
    }

    public ArrayStackTDA(int tamanio) {
        if(tamanio<=0)
            throw new IllegalArgumentException("Capacidad del array debe ser mayor a cero");
        elementos=(E[])new Object[tamanio];        
    }

    @Override
    public void push(E elemento) {
        if(count==elementos.length)
            expande();
        elementos[count++]=elemento;
    }
    
    private void expande(){
        int newLength=(int)(1.5*elementos.length);
        E[] temp=(E[]) new Object[newLength];
        for(int i=0;i<elementos.length;i++)
            temp[i]=elementos[i];
        elementos=temp;
    }

    @Override
    public E pop() throws StackEmptyExceptionTDA {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E peek() throws StackEmptyExceptionTDA {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        for(int i=0;i<count;i++)
            elementos[i]=null;
        count=0;
    }

    @Override
    public boolean isEmpty() {
        return(count==0);
    }
    
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        int current=count-1;
        while(current>=0){
            if(!str.isEmpty())
                str.append(",");
            str.append(elementos[current].toString());
            current--;
        }
        return str.toString();
    }
    
}
