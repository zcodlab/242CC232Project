package uni.aed.sort;

public class SortObject{   
    private static final int LESS = -1;
    private static final int EQUAL = 0;    
    private static final int MORE  = 1;  
    private Object[] Y;

    public SortObject() {
    }
    

    public SortObject(Object[] Y) {
        this.Y = Y;
    }

    public void setY(Object[] Y) {
        this.Y = Y;
    }

    public Object[] getY() {
        return Y;
    }
    
    @Override
    public String toString() {
        if (Y==null) return "";
        StringBuilder str=new StringBuilder();    
        for(Object y:Y)
            if (str.isEmpty()) 
                str.append(y.toString());                
            else
                str.append("|"+ y.toString());                
        return "{"+ str.toString() + "}";
    }   
    
    //Metodo MergeSort 
    public Object[] MergeSort(){
        Object[] X=getY().clone();
        return MergeSort(X);                
    }
            
    private Object[] MergeSort(Object[] X)
    {
        int n=X.length;
        if(n < 2) return X;
        int mid = n/2;
        Object[] left=new Object[mid];
        Object[] right=new Object[n - mid];
        for(int i=0;i<mid;i++)
            left[i] = X[i];
        for(int i=mid;i<n;i++)
            right[i - mid] = X[i];        
        MergeSort(left);
        MergeSort(right);
        Merge(X,left,right );
        return X;
    }
    private void Merge(Object[] X,Object[] left,Object[] right){
        int nL=left.length;
        int nR=right.length;
        int i=0,j=0,k=0;
        int result;
        while(i<nL && j<nR){
            result=((Comparable)left[i]).compareTo( right[j] );
            if(result<=0){//left[i] <= right[j]
                X[k]=left[i];
                i++;
            }else{
                X[k]=right[j];
                j++;                
            }
            k++;                
        }
        while(i<nL){
            X[k]=left[i];
            i++;
            k++;
        }
        while(j<nR){
            X[k]=right[j];
            j++;
            k++;
        }        
    }
}

