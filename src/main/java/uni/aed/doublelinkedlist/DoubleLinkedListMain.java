package uni.aed.doublelinkedlist;

import java.util.Scanner;
import uni.aed.sort.SortLinkedList;

public class DoubleLinkedListMain {
    public static void main(String[] args){
        DoubleLinkedListMain lista=new DoubleLinkedListMain();
        lista.testDoubleLinkedList();        
        //lista.Cap16E22();
    }   

    private void testDoubleLinkedList(){
        DoubleLinkedList lista=new DoubleLinkedList();
        lista.addLast(4);
        lista.addLast(1);
        lista.addLast(9);
        lista.addLast(3);

        System.out.println("La lista contiene "+lista.size()+" elementos");
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());    

//        System.out.println("Eliminando el elemento: 20");
//        lista.remove(20);    

//        System.out.println("La lista contiene "+lista.size()+" elementos");
//        System.out.println("Visualizando el contenido de la lista");
//        System.out.println(lista.toString());
        
        System.out.println("Ordenando la lista");
        SortLinkedList.heapsort(lista);
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
        
    }
    private void Cap16E22(){
        Scanner scr=new Scanner(System.in).useDelimiter("\n");
        DoubleLinkedList lista=new DoubleLinkedList();
        System.out.println("Ingrese numeros enteros, para salir ingrese -1");
        int data=scr.nextInt();
        while(data!=-1){
            lista.addFirst(data);
            data=scr.nextInt();
        }
        System.out.println("La lista contiene "+lista.size()+" elementos");
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
    }
}
