package uni.aed.search;

import java.util.Scanner;

/**
 * @author zemr
 */
public class SearchMain {
    private static Integer[] X;
    
    public static void main(String[] args){
        SearchMain searchMain=new SearchMain();
        searchMain.carga();
        searchMain.visualizar();        
        searchMain.searchLineal();
    }
    
    private void carga(){
        Integer[] Y={15,1,25,60,69,86,3,78,2,10} ;
        X=Y;
    }
    private void visualizar(){
        System.out.println("El array contiene los siguientes elementos");
        for(Integer x: X)
            System.out.print(x.toString()+",");            
        System.out.println("");
    }
    private void searchLineal(){
        Scanner scr=new Scanner(System.in);
        Search search=new Search();
        System.out.println("Ingrese el valor a buscar");
        int valor=scr.nextInt();
        int pos=search.searchLineal(X, valor);
        if(pos==-1)
            System.out.println("El valor buscado "+ valor + ", no existe");
        else
            System.out.println("El valor " + valor +" se ubico en la posicion "+ pos);                    
    }
    
}


