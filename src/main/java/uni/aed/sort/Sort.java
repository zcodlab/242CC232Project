package uni.aed.sort;

public class Sort {
    private Integer[] Y;
    
    public Integer[] selectionWuSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        int startIndex,minIndex,lenght,temp;
        lenght=X.length;
        for(startIndex=0;startIndex<=lenght-2;startIndex++ ){
            minIndex=startIndex;
            //buscando el valor mas pequeño
            for(int i=startIndex+1;i<=lenght-1;i++)            
                if(X[i]<X[minIndex]) minIndex=i;            
            //intercambio
            temp=X[startIndex];
            X[startIndex]=X[minIndex];
            X[minIndex]=temp;            
        }
        return X;
    }
    
}
