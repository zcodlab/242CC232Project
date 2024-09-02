package uni.aed.search;
/** 
 * @author zemr
 */
public class Search {
    public final int NO_ENCONTRADO=-1;
    
    public int searchLineal(Integer[] X,int valor){
        int loc=0;
        while(loc<X.length && X[loc]!=valor){
            loc++;
        }
        if(loc==X.length)
            return NO_ENCONTRADO;
        else
            return loc;                    
    }
    
}
