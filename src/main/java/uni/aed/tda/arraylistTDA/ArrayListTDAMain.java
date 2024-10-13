package uni.aed.tda.arraylistTDA;

import uni.aed.model.Persona;
import uni.aed.tda.listTDA.ListTDA;

public class ArrayListTDAMain {
    public static void main(String[] args){
        ArrayListTDAMain lista=new ArrayListTDAMain();
        lista.testArrayListTDAString();
        lista.testArrayListTDAPersona();
        
    }
    private void testArrayListTDAString(){
        ListTDA<String> arrayListTDA = new ArrayListTDA<>();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+arrayListTDA.size());
        arrayListTDA.add("Jose");
        arrayListTDA.add("Beatriz");
        arrayListTDA.add("Sandro");
        arrayListTDA.add("Franklin");
        arrayListTDA.add(2,"Adelaida");        
        System.out.println("Despues de añadir elementos:");	
        System.out.println("Size = "+arrayListTDA.size());
        
        System.out.println("Visualizando el contenido de la lista");
        System.out.println(arrayListTDA.toString());        
        String elemento="Adelaida";
        if (arrayListTDA.contain(elemento)==true){            
            System.out.println("El elemento buscado: "+ elemento +" se encuentra en la posicion: "+ arrayListTDA.indexOf(elemento)+" se procedera a su eliminacion.");            
            arrayListTDA.delete(arrayListTDA.indexOf(elemento));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");        
        
        System.out.println("Visualizando el contenido de la lista");        
        System.out.println(arrayListTDA.toString());
        
    }
    private void testArrayListTDAPersona(){
        ListTDA<Persona> lista = new ArrayListTDA<>();
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+lista.size());
        
        Persona p1=new Persona("Sonya Smith",30,'F');
        Persona p2=new Persona("Barack Obama",60,'M');
        Persona p3=new Persona("Dina Boluarte",50,'F');
        Persona p4=new Persona("Mick Jagger",75,'M');
        
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        System.out.println("Antes de añadir elementos:");	
        System.out.println("Size = "+lista.size());
        System.out.println(lista.toString());
                
        lista.add(1,p4);   
        System.out.println("Despues de añadir 1 elemento: Mick Jagger, posicion 1");	
        System.out.println("Size = "+lista.size());        
        System.out.println(lista.toString());
        
        System.out.println("Buscando 1 elemento: Elon Musk");	
        Persona p5=new Persona("Elon Musk",60,'M');
        if (lista.contain(p5)==true){            
            System.out.println("El elemento buscado: "+ p5.getName() +" se encuentra en la posicion: "+ lista.indexOf(p5)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ p5.getName() +" luego de ubicarlo en la lista");
            lista.delete(lista.indexOf(p5));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        
        System.out.println("Buscando 1 elemento: Barack Obama");
        if (lista.contain(p2)==true){            
            System.out.println("El elemento buscado: "+ p2.getName() +" se encuentra en la posicion: "+ lista.indexOf(p2)+" se procedera a su eliminacion.");            
            System.out.println("Eliminando el elemento "+ p2.getName() +" luego de ubicarlo en la lista");
            lista.delete(lista.indexOf(p2));
        }else
            System.out.println("El elemento buscado no se encuentra en el Registro");
        //imprimiendo elementos de la LinkedList        
        System.out.println(lista.toString());
        
        System.out.println("Añadiedo 1 registro en la posicion 2: Zhang Yiming");
        lista.add(2, new Persona("Zhang Yiming",45,'M'));
        //imprimiendo elementos de la LinkedList        
        System.out.println(lista.toString());
    }   
}
