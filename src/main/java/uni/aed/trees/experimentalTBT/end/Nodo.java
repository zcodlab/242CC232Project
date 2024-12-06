package uni.aed.trees.experimentalTBT.end;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Nodo {
    private static final int LONGITUD_CADENA=250000;
    private long valor;    
    private long height;
    private long fb;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(long valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setFb(long fb) {
        this.fb = fb;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public long getValor() {
        return valor;
    }

    public long getHeight() {
        return height;
    }

    public long getFb() {
        return fb;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
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
