package uni.aed.sort;

import uni.aed.doublelinkedlist.DoubleLinkedList;
import uni.aed.doublelinkedlist.DNodo;

public class SortLinkedList {
    public static void heapsort(DoubleLinkedList lista){
        int n=lista.size();
        //construir el heap
        for(int i=n/2 -1; i>=0;i--)
            heapify(lista,n,i);
        //Extraer elementos uno a uno
        for(int i=n-1;i>0;i--){
            intercambio(lista,0,i);
            heapify(lista,i,0);
        }
    }
    private static void heapify(DoubleLinkedList lista, int n, int i){
        DNodo raiz=lista.getNodo(i);
        int mayor=i;
        int izquierda =2*i+1;
        int derecha =2*i+2;
        if(izquierda<n 
          && lista.getNodo(izquierda).getData()>raiz.getData())
            mayor=izquierda;
        if(derecha<n 
          && lista.getNodo(derecha).getData()>
                lista.getNodo(mayor).getData())
            mayor=derecha;
        if(mayor!=i){
            intercambio(lista,i,mayor);
            heapify(lista,n,mayor);
        }
            
    }
    
    private static void intercambio(DoubleLinkedList lista, int i, int j){
        DNodo nodoI=lista.getNodo(i);
        DNodo nodoJ=lista.getNodo(j);
        int temp=nodoI.getData();
        nodoI.setData(nodoJ.getData());
        nodoJ.setData(temp);
    }
    
}
