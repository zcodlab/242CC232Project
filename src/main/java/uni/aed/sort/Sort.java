package uni.aed.sort;

public class Sort {
    private Integer[] Y;

    public Sort() {
    }

    public Sort(int N) {
        this.Y = new Integer[N];
    }

    public void setY(Integer[] Y) {
        this.Y = Y;
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
    
    public Integer[] bubbleWuSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        int temp,bottom,i;
        boolean exchanged=true;
        bottom=X.length-2;
        while(exchanged){
            exchanged=false;
            for(i=0;i<=bottom;i++){
                if(X[i]>X[i+1]){
                    temp=X[i];
                    X[i]=X[i+1];
                    X[i+1]=temp;
                    exchanged=true;                    
                }
            }
            bottom--;
        }
        return X;
    }
    
}
