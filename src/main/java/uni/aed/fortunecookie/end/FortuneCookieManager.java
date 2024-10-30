package uni.aed.fortunecookie.end;

import java.util.Random;
import uni.aed.tda.listTDA.ListTDA;

public class FortuneCookieManager {
    private ListTDA<String> fortunas;    
    FortuneCookieFile fortuneCookieFile;
            
    public FortuneCookieManager(String nombreArchivo) {
        fortuneCookieFile=new FortuneCookieFile(nombreArchivo);
        fortunas=fortuneCookieFile.getLista();        
    }
    
    public String nexFortune() {
        Random random = new Random();
        int index = random.nextInt(fortunas.size());
        return fortunas.get(index);
        
    }
    
    public void AddFortuneCookie(String fortune){
        fortunas.add(fortune);
    }
    public void DeleteFortuneCookie(String fortune){
        fortunas.delete(fortune);
    }
    public void DeleteFortuneCookie(int index){
        fortunas.delete(index);
    }
    public String DeleteFortuneCookieWithReturn(int index){
        return fortunas.delete(index);
    }
    public String getLastFortuneCookie() {
        return fortunas.get(fortunas.size());
    }
    public String getFortuneCookie(int index){
        return fortunas.get(index);
    }
    public int getSizeFortuneCookie() {
        return fortunas.size();
    }
    @Override
    public String toString() {
        return fortunas.toString();
    }
    public String toString(String patron) {
        return fortunas.toString(patron);
    }
    public void updateFile(String filePath){
        fortuneCookieFile.updateFile(filePath);
    }
    
}
