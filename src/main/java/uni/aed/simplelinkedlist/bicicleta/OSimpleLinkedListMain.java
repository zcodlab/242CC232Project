package uni.aed.simplelinkedlist.bicicleta;

import java.util.Scanner;
import uni.aed.model.Bicicleta;

public class OSimpleLinkedListMain {
    public static void main(String[] args){
        OSimpleLinkedListMain lista=new OSimpleLinkedListMain();
        lista.testOSimpleLinkedList();
    }
    
    private void testOSimpleLinkedList(){
        Scanner scr=new Scanner(System.in).useDelimiter("\n");
        Bicicleta b;
        String nombre;               
        OSimpleLinkedList olista=new OSimpleLinkedList();
        Bicicleta b1=new Bicicleta("Sonya Smith");
        Bicicleta b2=new Bicicleta("Barack Obama");
        Bicicleta b3=new Bicicleta("Kamala Harris");
        Bicicleta b4=new Bicicleta("Dina Boluarte");
        
        olista.addLast(b1);
        olista.addLast(b2);
        olista.addLast(b3);
        olista.addLast(b4);
        
        System.out.println("Visualizando el contenido de la lista de Bicicletas:"+ olista.size());
        System.out.println(olista.toString());
        
        System.out.println("Eliminando un elemento de la lista");
        System.out.println("Consigne el nombre del propietario de la bicicleta a eliminar");
        nombre=scr.next();
        b=new Bicicleta(nombre);
        olista.remove(b);
        
        System.out.println("Visualizando el contenido de la lista de Bicicletas:"+ olista.size());
        System.out.println(olista.toString());
        
        System.out.println("Consigne el nombre del propietario de la bicicleta a buscar");
        nombre=scr.next();
        b=new Bicicleta(nombre);        
        System.out.println("El nombre del propietario de la bicicleta se ubico en la posicion:" + olista.search(b));        
    }
}
