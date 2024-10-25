package uni.aed.stackTDA.tagsHTML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import uni.aed.tda.listTDA.NoSuchElementException;

public class HTMLRecuperaEtiq {
    private BufferedReader reader;

    public HTMLRecuperaEtiq(String nomArchivo) throws IOException {
        this.reader = new BufferedReader(new FileReader(nomArchivo));
    }
    public HTMLEtiq etiqSiguiente()throws IOException{
        String linea=reader.readLine();
        if (linea==null)
            throw new NoSuchElementException("Mo hay mas etiquetas por leer");
        linea=linea.trim();
        return new HTMLEtiq(linea);
    }
    
    public boolean hayMasEtiq(){
        try{
            return reader.ready();
        }
        catch(IOException e){
            return false;
        }
    }
    
    public void cerrar() throws IOException{
        reader.close();
    }
    
    public void reset(){
        try{
            reader.reset();
        }
        catch(IOException e){
            e.printStackTrace();
        }        
    }
    
    public void restablece(String nomArchivo)throws IOException{
        reader.close();
        reader = new BufferedReader(new FileReader(nomArchivo));
    }
    
}