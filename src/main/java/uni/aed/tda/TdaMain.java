package uni.aed.tda;
public class TdaMain {
    public static void main(String[] args){
        TdaMain tdaMain = new TdaMain();
        System.out.println("Llamada al metodo casillero1");
        tdaMain.casillero1();
        System.out.println("Llamada al metodo casillero2");
        tdaMain.casillero2();
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
}
