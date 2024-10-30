package uni.aed.fortunecookie.end;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class FortuneCookieMain {
    private static FortuneCookieManager fortuna;
    private static Scanner scr;
    private static int opcion=1;		
    private static String Rpta="S";				
    private static String SEPARADOR="\n";	                                
    private static String archivo;
    public static void main(String[] args){
        FortuneCookieMain fortunaMain=new FortuneCookieMain();        
        archivo=fortunaMain.selectFile();
        if (archivo==null){
            System.out.println("No se seleccionó ningún archivo.");
            return;
        }
        fortuna=new FortuneCookieManager(archivo);        
        scr=new Scanner(System.in).useDelimiter("\n");
        fortunaMain.menu();
    }
    
    private void menu(){        
        try{
            
            do			
            {	
                System.out.print("Galleta de la Fortuna con Listas Enalazadas"+SEPARADOR+
                "1.- Obtiene una Galleta de la Fortuna "+SEPARADOR+
                "2.- Añadir Galleta de la Fortuna "+SEPARADOR+
                "3.- Eliminar Galleta de la Fortuna "+SEPARADOR+                
                "4.- Listar Galletas de la Fortuna "+SEPARADOR+                
                "5.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {getFortuneCookie();}
                    case 2 -> {addFortuneCookie();}
                    case 3 -> {deleteFortuneCookieManager();}                    
                    case 4 -> {verFortunesCookies();}                    
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
                Rpta=scr.next().toUpperCase();			
            }while(Rpta.equals("S")==true);	
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }finally{
            fortuna.updateFile(archivo);
            scr.close();
        }
    }
    private String selectFile(){
        // Crear una instancia de JFileChooser
        JFileChooser fileChooser = new JFileChooser();        
        // Establecer un filtro para solo mostrar archivos de texto
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));        
         // Desactivar la opción de "All Files"
        fileChooser.setAcceptAllFileFilterUsed(false);
        File selectedFile = null;        
        // Abrir el cuadro de diálogo para seleccionar un archivo
        int returnValue = fileChooser.showOpenDialog(null);        
        // Verificar si se seleccionó un archivo
        if (returnValue == JFileChooser.APPROVE_OPTION)
            selectedFile = fileChooser.getSelectedFile();            
        
        if (selectedFile!=null)
            return selectedFile.getAbsolutePath();                    
        
        return null;
    }
    
    private void addFortuneCookie(){        
        System.out.println("Ingrese una Galleta de la Fortuna");
        String galleta = scr.next();
        fortuna.AddFortuneCookie(galleta);        
        System.out.println("Ahora se tiene "+ fortuna.getSizeFortuneCookie()+ " galletas de la fortuna");
    }
    private void deleteFortuneCookie(){        
        System.out.println("Ingrese posicion de la Galleta de la Fortuna a eliminar");
        int pos = scr.nextInt();
        System.out.println("Eliminado(fortuna" +pos+"):"+fortuna.DeleteFortuneCookieWithReturn(pos));        
        System.out.println("Ahora se tiene "+ fortuna.getSizeFortuneCookie()+ " galletas de la fortuna");
    }    
    private void verFortunesCookies(){        
        System.out.println("Lista Galletas de la Fortuna "+ fortuna.getSizeFortuneCookie());                
        System.out.println(fortuna.toString(SEPARADOR));                      
    }
    private void getFortuneCookie(){        
        String rpta;        
        System.out.println("****Galletas de la Fortuna****");
        System.out.println(fortuna.nexFortune());        
        System.out.println("Pulse S para continuar obteniendo galletas de la fortuna, N para salir:");        
        while(true){
            rpta=scr.next();
            if(!rpta.equalsIgnoreCase("N"))
                System.out.println(fortuna.nexFortune());    
            else break;
        }
    }
    private void deleteFortuneCookieManager(){
        try{
            
            do			
            {	
                System.out.print("Seleccione el tipo de eliminacion"+SEPARADOR+
                "1.- Borrado por Posicion "+SEPARADOR+
                "2.- Borrado de Lista "+SEPARADOR+                
                "3.- Listar Galletas de la Fortuna "+SEPARADOR+                           
                "4.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> {deleteFortuneCookie();}
                    case 2 -> {deleteFortuneCookieWithMenu();}                    
                    case 3 -> {verFortunesCookies();}                    
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para retornar al Menu Principal pulse N: ");
                Rpta=scr.next().toUpperCase();			
            }while(Rpta.equals("S")==true);	
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void deleteFortuneCookieWithMenu(){        
        for(int i = 0;i<fortuna.getSizeFortuneCookie();i++){            
            System.out.println("fortuna"+i+": "+fortuna.getFortuneCookie(i));
            System.out.println("Ingrese una opcion  B(Borrar)   M(Mantener) S(Detener el listado)");            
            Rpta = scr.next().toUpperCase();
            switch (Rpta.charAt(0))
                {
                    case 'B' -> {System.out.println("Eliminado(fortuna" +i+"):"+fortuna.DeleteFortuneCookieWithReturn(i)); i--;}
                    case 'M' -> {break;}                    
                    case 'S' -> {return;}                    
                    default -> {return;}
                }
        }
    }
    
}
