package uni.aed.queueTDA;

import uni.aed.model.Persona;

public class QueueTDAMain {
   public static void main(String[] args){
       QueueTDAMain queueMain=new QueueTDAMain();
       queueMain.testPriorityQueueTDAInteger();       
   }
   private void testArrayQueueTDAInteger(){
       QueueTDA<Integer> q=new ArrayQueueTDA<>(4);
       q.enqueue(30);
       q.enqueue(10);
       q.enqueue(20);
       q.enqueue(5);
       System.out.println("Despues de añadir elementos:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Eliminando elementos:");	        
       System.out.println("Elemento eliminado:"+q.dequeue().toString());	
       System.out.println("Despues de eliminar elemento:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());        
       
        System.out.println("Recuperando el elemento con peek:");	        
        System.out.println("Elemento recuperado es:"+q.peek());	
        System.out.println("Size = "+q.size());
        System.out.println(q.toString());
       
   }
   private void testArrayQueueTDAString(){
       QueueTDA<String> q=new ArrayQueueTDA<>(4);
       q.enqueue("Jose");
       q.enqueue("Ana");
       q.enqueue("Juan");
       q.enqueue("Betty");
       System.out.println("Despues de añadir elementos:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Eliminando elementos:");	        
       System.out.println("Elemento eliminado:"+q.dequeue());	
       System.out.println("Despues de eliminar elemento:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());        
       
       System.out.println("Recuperando el elemento con peek:");	        
       System.out.println("Elemento recuperado es:"+q.peek());	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
   }
   
   private void testArrayQueueTDAPersona(){
       QueueTDA<Persona> q=new ArrayQueueTDA<>(4);
       q.enqueue(new Persona("Jose",36));
       q.enqueue(new Persona("Ana",46));
       q.enqueue(new Persona("Juan",16));
       q.enqueue(new Persona("Betty",66));
       System.out.println("Despues de añadir elementos:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Eliminando elementos:");	        
       System.out.println("Elemento eliminado:"+q.dequeue());	
       System.out.println("Despues de eliminar elemento:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());        
       
       System.out.println("Recuperando el elemento con peek:");	        
       System.out.println("Elemento recuperado es:"+q.peek());	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
   }
   
   private void testLinkedQueueTDAInteger(){
       QueueTDA<Integer> q=new LinkedQueueTDA<>();
       q.enqueue(30);
       q.enqueue(10);
       q.enqueue(20);
       q.enqueue(5);
       System.out.println("Despues de añadir elementos:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Eliminando elementos:");	        
       System.out.println("Elemento eliminado:"+q.dequeue().toString());	
       System.out.println("Despues de eliminar elemento:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());        
       
        System.out.println("Recuperando el elemento con peek:");	        
        System.out.println("Elemento recuperado es:"+q.peek());	
        System.out.println("Size = "+q.size());
        System.out.println(q.toString());
       
   }
   private void testLinkedQueueTDAString(){
       QueueTDA<String> q=new LinkedQueueTDA<>();
       q.enqueue("Jose");
       q.enqueue("Ana");
       q.enqueue("Juan");
       q.enqueue("Betty");
       System.out.println("Despues de añadir elementos:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Eliminando elementos:");	        
       System.out.println("Elemento eliminado:"+q.dequeue());	
       System.out.println("Despues de eliminar elemento:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());        
       
       System.out.println("Recuperando el elemento con peek:");	        
       System.out.println("Elemento recuperado es:"+q.peek());	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
   }
   
   private void testLinkedQueueTDAPersona(){
       QueueTDA<Persona> q=new LinkedQueueTDA<>();
       q.enqueue(new Persona("Jose",36));
       q.enqueue(new Persona("Ana",46));
       q.enqueue(new Persona("Juan",16));
       q.enqueue(new Persona("Betty",66));
       System.out.println("Despues de añadir elementos:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Eliminando elementos:");	        
       System.out.println("Elemento eliminado:"+q.dequeue());	
       System.out.println("Despues de eliminar elemento:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());        
       
       System.out.println("Recuperando el elemento con peek:");	        
       System.out.println("Elemento recuperado es:"+q.peek());	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
   }
   
   private void testPriorityQueueTDAInteger(){
       int n=7;
       QueueTDA<Integer> q=new PriorityQueueTDA<>(n);
       q.enqueue(56);
       q.enqueue(88);
       q.enqueue(7);
       q.enqueue(60);
       q.enqueue(2);
       q.enqueue(71);
       q.enqueue(59);
       
       System.out.println("Despues de añadir elementos:");	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Recuperando el elemento con peek:");	        
       System.out.println("Elemento recuperado es:"+q.peek());	
       System.out.println("Size = "+q.size());
       System.out.println(q.toString());
       
       System.out.println("Eliminando elementos:");
       for(int i=0;i<n;i++)           
            System.out.println("Elemento eliminado:"+q.dequeue().toString());	
       System.out.println("Despues de eliminar elemento:");	
       System.out.println("Size = "+q.size());       
       
   }
}
