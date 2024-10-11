package uni.aed.tda.linkedlistTDA;

import uni.aed.model.Persona;

public class LinkedListTDAMain {
    public static void main(String[] args){
        LinkedListTDAMain lista=new LinkedListTDAMain();
        lista.testLinkedListTDAString();
        lista.testLinkedListTDAPersona();
        
    }
    private void testLinkedListTDAString(){
        LinkedListTDA<String> lista=new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos la lista tiene: " + lista.size());
        lista.add("Jose");
        lista.add("Beatriz");
        lista.add("Ana");
        System.out.println("N° elementos en la lista: " + lista.size());
        System.out.println("Visualizando la lista");
        System.out.println(lista.toString());        
    }
    private void testLinkedListTDAPersona(){
        LinkedListTDA<Persona> lista=new LinkedListTDA<>();
        System.out.println("Antes de añadir elementos la lista tiene: " + lista.size());
        Persona p1=new Persona("Kamala Harris",58,'F');
        Persona p2=new Persona("Barack Obama",60,'M');
        Persona p3=new Persona("Donald Trump",65,'M');        
        
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        
        System.out.println("N° elementos en la lista: " + lista.size());
        System.out.println("Visualizando la lista");
        System.out.println(lista.toString());        
    }
}
