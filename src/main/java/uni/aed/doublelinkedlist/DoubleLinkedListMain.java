package uni.aed.doublelinkedlist;
public class DoubleLinkedListMain {
    public static void main(String[] args){
        DoubleLinkedListMain lista=new DoubleLinkedListMain();
        lista.testDoubleLinkedList();        
    }   

    private void testDoubleLinkedList(){
        DoubleLinkedList lista=new DoubleLinkedList();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        lista.addFirst(40);

        System.out.println("La lista contiene "+lista.size()+" elementos");
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());    

        System.out.println("Eliminando el elemento: 20");
        lista.remove(20);    

        System.out.println("La lista contiene "+lista.size()+" elementos");
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(lista.toString());
    }
}
