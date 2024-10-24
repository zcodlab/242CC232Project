package uni.aed.stackTDA;

public class StackTDAMain {

    public static void main(String[] args){
        StackTDAMain stackMain=new StackTDAMain();  
        //stackMain.testLinkedStackTDA();
        stackMain.testArrayStackTDA();
        
    }
    private void testLinkedStackTDA(){
        StackTDA<String> linkedStackTDA = new LinkedStackTDA<>();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+linkedStackTDA.size());
        linkedStackTDA.push("Jose");
        linkedStackTDA.push("Beatriz");
        linkedStackTDA.push("Sandro");        
        linkedStackTDA.push("Juan");        
        System.out.println("Despues de añadir elementos:");	
        System.out.println("Size = "+linkedStackTDA.size());
        System.out.println(linkedStackTDA.toString());
        
        System.out.println("Eliminando elementos:");	        
        System.out.println("Elemento eliminado:"+linkedStackTDA.pop().toString());	
        System.out.println("Despues de eliminar elemento:");	
        System.out.println("Size = "+linkedStackTDA.size());
        System.out.println(linkedStackTDA.toString());
        
        System.out.println("Recuperando el elemento con peek:");	        
        System.out.println("Elemento recuperado es:"+linkedStackTDA.peek());	
        System.out.println("Size = "+linkedStackTDA.size());
        System.out.println(linkedStackTDA.toString());
    }    
     private void testArrayStackTDA(){
        StackTDA<String> arrayStackTDA = new ArrayStackTDA<>(3);
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+arrayStackTDA.size());
        arrayStackTDA.push("Jose");
        arrayStackTDA.push("Beatriz");
        arrayStackTDA.push("Sandro");        
        System.out.println("Despues de añadir elementos:");	
        System.out.println("Size = "+arrayStackTDA.size());
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(arrayStackTDA.toString());  
        
        System.out.println("Eliminando elementos:");	        
        System.out.println("Elemento eliminado:"+arrayStackTDA.pop());	
        System.out.println("Despues de eliminar elemento:");	
        System.out.println("Size = "+arrayStackTDA.size());
        System.out.println(arrayStackTDA.toString());
        
        System.out.println("Recuperando el elemento con peek:");	        
        System.out.println("Elemento recuperado es:"+arrayStackTDA.peek());	
        System.out.println("Size = "+arrayStackTDA.size());
        System.out.println(arrayStackTDA.toString());
     }
}

