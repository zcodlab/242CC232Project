package uni.aed.directorio;

import uni.aed.model.Persona;

public class DirectorioMain {
    public static void main(String[] args){
        DirectorioMain directorioMain=new DirectorioMain();        
        directorioMain.test();
    }
    
    private void test(){
        Directorio directorio=new DirectorioV1(4);
        Persona p1=new Persona("Sonya Smith",random(18,70),random(0,1)==0?'M':'F');
        Persona p2=new Persona("Barack Obama",random(18,70),random(0,1)==0?'M':'F');
        Persona p3=new Persona("Kamala Harris",random(18,70),random(0,1)==0?'M':'F');
        Persona p4=new Persona("Dina Boluarte",random(18,70),random(0,1)==0?'M':'F');
        
        directorio.add(p1);
        directorio.add(p2);
        directorio.add(p3);
        directorio.add(p4);
        
        System.out.println("Coleccion de Persona en el Directorio Origen");
        System.out.println(directorio.toString());
        
        System.out.println("Eliminando una persona la coleccion");
        System.out.println(directorio.delete("Barack Obama"));
        
        System.out.println("Coleccion de Persona despues de la eliminacion");
        System.out.println(directorio.toString());
        
        System.out.println("Realizando la busqueda");
        System.out.println(directorio.search(p3,"LINEAL"));
        
        System.out.println("Realizando la busqueda");
        System.out.println(directorio.search(p4,"LINEAL"));
    }
    
    private int random(int low,int high){
        return (int)Math.floor(Math.random()*(high-low + 1))+low;
    }
    
}
