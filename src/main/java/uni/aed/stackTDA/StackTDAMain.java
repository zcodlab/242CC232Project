package uni.aed.stackTDA;

public class StackTDAMain {

    public static void main(String[] args){
        StackTDAMain stackMain=new StackTDAMain();  
        stackMain.testLinkedStackTDA();
        
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
}

