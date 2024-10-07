package uni.aed.tda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uni.aed.model.Libro;

public class TdaMain {
    public static void main(String[] args){
        TdaMain tdaMain = new TdaMain();
        System.out.println("Llamada al metodo casillero1");
        tdaMain.casillero1();
        System.out.println("Llamada al metodo casillero2");
        tdaMain.casillero2();
        System.out.println("Llamada al metodo casillero4");
        tdaMain.casillero4();
        System.out.println("Llamada al metodo casillero5");
        tdaMain.casillero5();
        System.out.println("Llamada al metodo testColeccionLibrosSinParametroDeTipo");
        tdaMain.testColeccionLibrosSinParametroDeTipo();
        System.out.println("Llamada al metodo testColeccionLibrosConParametroDeTipo");
        tdaMain.testColeccionLibrosConParametroDeTipo();
    }
    
    private void casillero1(){
        Casillero1<String> casilleroUno;
        Casillero1<Integer> casilleroDos;
        casilleroUno=new Casillero1<>();
        casilleroDos=new Casillero1<>();
        casilleroUno.setContenido("Mochila");
        casilleroDos.setContenido(100);
        
        System.out.println("El casillero1 tiene el contenido "+ casilleroUno.getContenido());
        System.out.println("El casillero2 tiene el contenido "+ casilleroDos.getContenido().toString());
    }
    
    private void casillero2(){
        Casillero2<String,Integer> casillero;
        casillero=new Casillero2<>("Mochila",100);
        
        Casillero2<String,String> saludo;
        saludo=new Casillero2<>("Hola","AED");
        
        System.out.println("El casillero tiene el contenido: "+
                casillero.getContenido1()+"-"+casillero.getContenido2());
        System.out.println("El saludo es: "+
                saludo.getContenido1()+"-"+saludo.getContenido2());
        
    }
    private void casillero4(){
        Casillero4<Number> numerico1=new Casillero4<>(100);
        Casillero4<Double> numerico2=new Casillero4<>(10.0);
        Casillero4<Integer> numerico3=new Casillero4<>(10);
        System.out.println("El Casillero4 tiene los contenidos numericos: "+
                numerico1.getContenido().toString()+"|"+
                numerico2.getContenido().toString()+"|"+
                numerico3.getContenido().toString());
    }
    private void casillero5(){
        Casillero5<Double> casillero51=new Casillero5<>(3.1);
        Casillero5<Integer> casillero52=new Casillero5<>(3);
        System.out.println("Los valores de casillero51 y casillero52 son iguales("
            + casillero51.getContenido()+"|"+casillero52.getContenido()+"):"
            + casillero51.isSameValue(casillero52) );
        
    }
    private void testColeccionLibrosSinParametroDeTipo(){
        List libros=new ArrayList();
        libros.add(new Libro("C.thomas Wu"));
        libros.add(new Libro("Adam Drozdek"));
        libros.add(new Libro("Joyanes"));
        
        Iterator it=libros.iterator();
        while(it.hasNext()){
            Libro libro=(Libro)it.next();
            System.out.println(libro.getAutor());
        }
    }
     private void testColeccionLibrosConParametroDeTipo(){
        List<Libro> libros=new ArrayList<>();
        libros.add(new Libro("C.thomas Wu"));
        libros.add(new Libro("Adam Drozdek"));
        libros.add(new Libro("Joyanes"));
        
        Iterator<Libro> it=libros.iterator();
        while(it.hasNext()){
            Libro libro=it.next();
            System.out.println(libro.getAutor());
        }
        
        for(Libro libro: libros)
            System.out.println(libro.getAutor());
    }
}
