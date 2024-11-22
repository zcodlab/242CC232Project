package uni.aed.trees.experimentalTBT.start;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Nodo {
    int valor;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
    private void print(StringBuilder buffer, 
        String prefix, String childrenPrefix){
        List<Nodo> children =new LinkedList<>();
        children.add(izquierda);
        children.add(derecha); 
        
        buffer.append(prefix);
        buffer.append(valor);
        buffer.append('\n');
        
        for (Iterator<Nodo> it=children.iterator();it.hasNext();){
            Nodo next=it.next();
            if(next==null)
                continue;
            if(it.hasNext())
                next.print(buffer, childrenPrefix+ "---", 
                        childrenPrefix+ "|   ");
            else
                next.print(buffer, childrenPrefix+ "+++", 
                        childrenPrefix+"   ");
        }
    }
    @Override
    public String toString(){
        StringBuilder buffer=new StringBuilder(50000);
        print(buffer,"","");
        return buffer.toString();
    }  
}
