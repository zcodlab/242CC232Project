package uni.aed.stackTDA.tagsHTML;

import java.io.IOException;
import uni.aed.stackTDA.ArrayStackTDA;
import uni.aed.stackTDA.StackTDA;

public class HTMLRevisaEtiq {
    private StackTDA<HTMLEtiq> etiquetasenPila;
    private HTMLRecuperaEtiq etiqRecuperada;

    public HTMLRevisaEtiq(String nomArchivo) throws IOException{
        etiquetasenPila=new ArrayStackTDA<>();
        etiqRecuperada = new HTMLRecuperaEtiq(nomArchivo);
    }

    public StackTDA<HTMLEtiq> getEtiquetasenPila() {
        return etiquetasenPila;
    }

    public HTMLRecuperaEtiq getEtiqRecuperada() {
        return etiqRecuperada;
    }    
    public boolean esValido(){
        HTMLEtiq etiqSiguiente=null,etiqTop=null;
        boolean nohayerror=true, termina=false;
        etiquetasenPila.clear();
        while(!termina){
            if(!etiqRecuperada.hayMasEtiq()){
                termina=true;
                if(!etiquetasenPila.isEmpty())
                    nohayerror=false;
            }else{
                try{
                    etiqSiguiente=etiqRecuperada.etiqSiguiente();
                }
                catch(IOException e){
                    e.printStackTrace();
                } 
                if(etiqSiguiente.esEtiquetaApertura())
                    etiquetasenPila.push(etiqSiguiente);
                else if(etiqSiguiente.esEtiquetaCierre()){
                    etiqTop=etiquetasenPila.pop();
                    if(!etiqTop.compara(etiqSiguiente)){
                        nohayerror=false;
                        termina=true;
                    }
                }
            }
        }
        return nohayerror;
    }
    
    
}
