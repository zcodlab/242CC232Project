package uni.aed.trees.experimentalTBT.end;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Nodo {
    private static final int LONGITUD_CADENA=250000;
    long valor;    
    long height;
    long fb;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(long valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
    private void print(StringBuilder buffer, 
        String prefix, String childrenPrefix){
        List<Nodo> children =new LinkedList<>();
        children.add(izquierda);
        children.add(derecha); 
        
        buffer.append(prefix);
        buffer.append(valor + " (fb:"+fb+")");
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
        StringBuilder buffer=new StringBuilder(LONGITUD_CADENA);
        print(buffer,"","");
        return buffer.toString();
    }  
}
