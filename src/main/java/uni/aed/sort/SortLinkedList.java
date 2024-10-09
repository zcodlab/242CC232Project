package uni.aed.sort;

import uni.aed.circlelinkedlist.CircleLinkedList;
import uni.aed.doublelinkedlist.DoubleLinkedList;
import uni.aed.doublelinkedlist.DNodo;
import uni.aed.simplelinkedlist.Nodo;

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
    
    //2PC: Metodo MergeSort con lista circular
    public static void mergeSort(CircleLinkedList lista){
        int n=lista.size();
        if(n<2) return; //n=1 -> ya llego al caso base
        int mid=n/2;
        CircleLinkedList left= new CircleLinkedList();
        CircleLinkedList right=new CircleLinkedList();
        Nodo current=lista.getNodo(0);
        for(int i=0;i<mid;i++)
            left.addLast(lista.getNodo(i).getData());
        for(int i=0;i<n;i++){
            if(i>=mid)
                right.addLast(lista.getNodo(i).getData());
        }
        mergeSort(left);
        mergeSort(right);
        merge(lista,left,right);     
    }
    private static void merge(CircleLinkedList lista,CircleLinkedList left,CircleLinkedList right){
        int nL=left.size();
        int nR=right.size();
        int i=0,j=0,k=0;
        while(i <nL && j<nR){
            if(left.getNodo(i).getData()<=right.getNodo(j).getData()){
                lista.getNodo(k).setData(left.getNodo(i).getData());
                i++;
            }else{
                lista.getNodo(k).setData(right.getNodo(j).getData());
                j++;
            }
            k++;
        }
        while(i<nL){//trasladar los elementos sobrantes de L1
            lista.getNodo(k).setData(left.getNodo(i).getData());
            i++;
            k++;
        }
        while(j<nR){//trasladar los elementos sobrantes de L2
            lista.getNodo(k).setData(right.getNodo(j).getData());
            j++;
            k++;
        }
    }
    
}
