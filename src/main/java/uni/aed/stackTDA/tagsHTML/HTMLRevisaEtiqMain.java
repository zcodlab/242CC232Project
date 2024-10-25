package uni.aed.stackTDA.tagsHTML;

import java.io.IOException;

public class HTMLRevisaEtiqMain {
    public static void main(String[] args){
        try{
            HTMLRevisaEtiq revisar=new HTMLRevisaEtiq("src\\main\\java\\uni\\aed\\stackTDA\\tagsHTML\\index.html");
            if(revisar.esValido())
                System.out.println("Archivo valido");
            else
                System.out.println("Archivo es Invalido");
                    
        }catch(IOException e){
            System.out.println("Error al abrir el archivo" + e.getMessage());
        } 
    }
    
}
