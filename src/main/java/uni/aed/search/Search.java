package uni.aed.search;
/** 
 * @author zemr
 */
public class Search {
    public final int NO_ENCONTRADO=-1;
    public final String SEARCH_BINARY_COMPLEJIDAD_WORSTCASE="O(lg(n))";
    public final String SEARCH_LINEAL_COMPLEJIDAD_WORSTCASE="O(n)";
    private int nComp=0;

    public void setnComp(int nComp) {
        this.nComp = nComp;
    }

    public int getnComp() {
        return nComp;
    }    
    
    public int searchLineal(Integer[] X,int valor){
        int loc=0;
        while(loc<X.length && X[loc]!=valor){
            loc++;
        }        
        
        if(loc==X.length){
            this.setnComp(loc);
            return NO_ENCONTRADO;
        }
        else{
            this.setnComp(loc + 1);
            return loc;                    
        }
    }
    
    public int searchBinaria(Integer[] X,int valor){
        int bajo=0, alto=X.length - 1, medio=(bajo+alto)/2;
        int ncomp=0;
        while(bajo<=alto && X[medio]!=valor){
            ncomp++;
            if(X[medio]<valor)
                bajo=medio+1;
            else
                alto=medio-1;
            medio=(bajo+alto)/2;
        }
        
        if(bajo>alto){
            this.setnComp(ncomp);
            medio=NO_ENCONTRADO;        
        }else
            this.setnComp(ncomp + 1);
        
        return medio;
    }
    
}
