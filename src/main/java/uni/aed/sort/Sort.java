package uni.aed.sort;

public class Sort {    
    private Integer[] Y;
    public final String SELECCION_COMPLEJIDAD_WORSTCASE="O(n^2)";
    public final String BURBUJA_COMPLEJIDAD_WORSTCASE="O(n^2)";
    public final String INSERCIONBINARIA_COMPLEJIDAD_WORSTCASE="O(nlog(n))";    
    private int nComp=0;

    public Sort() {
    }

    public Sort(int N) {
        this.Y = new Integer[N];
    }

    public void setY(Integer[] Y) {
        this.Y = Y;
    }    

    public void setnComp(int nComp) {
        this.nComp = nComp;
    }

    public int getnComp() {
        return nComp;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(Integer y:Y){
            str.append(y.toString());
        }
        return str.toString();
    }
    
    
    public Integer[] selectionWuSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        int startIndex,minIndex,lenght,temp;
        int nComp=0;
        lenght=X.length;
        for(startIndex=0;startIndex<=lenght-2;startIndex++ ){
            minIndex=startIndex;
            //buscando el valor mas pequeño
            for(int i=startIndex+1;i<=lenght-1;i++){
                nComp++;
                if(X[i]<X[minIndex]) minIndex=i;    
            }        
            //intercambio
            temp=X[startIndex];
            X[startIndex]=X[minIndex];
            X[minIndex]=temp;            
        }
        this.setnComp(nComp);
        return X;
    }
    
    public Integer[] bubbleWuSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        int temp,bottom,i;
        int nComp=0;
        boolean exchanged=true;
        bottom=X.length-2;
        while(exchanged){
            exchanged=false;
            for(i=0;i<=bottom;i++){
                nComp++;
                if(X[i]>X[i+1]){
                    temp=X[i];
                    X[i]=X[i+1];
                    X[i+1]=temp;
                    exchanged=true;                    
                }
            }
            bottom--;
        }
        this.setnComp(nComp);
        return X;
    }
    public Integer[] insercionBinariaSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        int aux,p,u,c;
        int nComp=0;
        for(int i =1;i<X.length;i++)
        {  aux=X[i];
           p=0;
           u=i-1;
           while(p<=u){
               c=(p+u)/2;
               nComp++;
               if(aux<X[c])
                   u=c-1;
               else
                   p=c+1;               
           }
           for(int k=i-1;k>=p;k--)
               X[k+1]=X[k];
           X[p]=aux;            
        }
        this.setnComp(nComp);
        return X;
    }
    
}
