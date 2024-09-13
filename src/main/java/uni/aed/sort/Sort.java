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
    public Integer[] heapSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        HeapSortConstruct(X);//1)fase de construccion
        return HeapSortExtract(X);//2) fase de extraccion                
    }
    private void HeapSortConstruct(Integer[] X){
        int current=0, maxChildIndex;
        boolean hecho;
        for(int i=(X.length-2)/2; i>=0; i--){
            current=i;
            hecho=false;
            while(!hecho){
                if(2*current+1 > X.length-1)
                    hecho=true;//nodo actual no tiene hijos
                else{//el nodo actual tiene por lo menos 1 hijo
                    maxChildIndex=HeapSortMaxChild(X,current,X.length - 1);
                    if(X[current]< X[maxChildIndex]){
                        intercambio(X,current,maxChildIndex);
                        current=maxChildIndex;                    
                    }else
                        hecho=true;                    
                }                    
            }
        }
    }
    
    private int HeapSortMaxChild(Integer[] X,int loc,int end){
        int result, izq,der;
        izq=2*loc+1;//posicionamiento impar = nodo izq
        der=2*loc+2;//posicionamiento par = nodo der
        if(der<=end && X[izq]<X[der])
            result=der;
        else
            result=izq;
        return result;        
    }
    
    private void intercambio(Integer[] X,int p,int q){
        int temp=X[p];
        X[p]=X[q];
        X[q]=temp;
    }
    
    private Integer[] HeapSortExtract(Integer[] X){
        Integer[] Y=new Integer[X.length];//va contener los elementos extraidos del heap
        int current, maxChildIndex;
        boolean hecho;
        for(int i=X.length -1; i>=0; i--){
            Y[i]=X[0];//consignamos la raiz del heap en el array destino(ordenado)
            X[0]=X[i];//rellenando la raiz del heap con el ultimo elemento del heap
            current=0;
            hecho=false;
            while(!hecho){//procedimiento para resstructurar el heap, luego de extraer elemento
                if(2*current + 1 > i)
                    hecho=true;
                else{//si el nodo tiene al menos un hijo
                    maxChildIndex=HeapSortMaxChild(X,current,i);
                    if(X[current]< X[maxChildIndex]){
                        intercambio(X,current,maxChildIndex);
                        current=maxChildIndex;                    
                    }else
                        hecho=true;    
                }       
            }//end while
        }//end for
        return Y;
    }   
    
    public Integer[] CallQuickSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        return QuickSort(X,0,X.length - 1);
    }
            
    private Integer[] QuickSort(Integer[] X, int start,int end){
        if(start < end)
        {
            int pIndex=QuickSortPartition(X,start,end);
            QuickSort(X,start,pIndex-1);
            QuickSort(X,pIndex+1,end);
        }
        return X;
    }
    private int QuickSortPartition(Integer[] X, int start,int end){
        int pivot=X[end];
        int pIndex=start;
        for(int i=start;i<end;i++){
            if(X[i]<=pivot){
                intercambio(X,i,pIndex);
                pIndex++;
            }
        }//end for
        intercambio(X,pIndex,end);
        return pIndex;
    }
    public Integer[] CallMergeSort(){
        if(Y==null) return null;
        Integer[] X=Y.clone();
        return MergeSort(X);
    }
    
    private Integer[] MergeSort(Integer[] X){
        int n=X.length;
        if(n<2) return X; //n=1 -> ya llego al caso base
        int mid=n/2;
        Integer[] left=new Integer[mid];
        Integer[] right=new Integer[n-mid];
        for(int i=0;i<mid;i++)
            left[i]=X[i];
        for(int i=mid;i<n;i++)
            right[i-mid]=X[i];
        MergeSort(left);
        MergeSort(right);
        Merge(X,left,right);
        return X;        
    }
    private void Merge(Integer[] X,Integer[] left,Integer[] right){
        int nL=left.length;
        int nR=right.length;
        int i=0,j=0,k=0;
        while(i <nL && j<nR){
            if(left[i]<=right[j]){
                X[k]=left[i];
                i++;
            }else{
                X[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<nL){//trasladar los elementos sobrantes de L1
            X[k]=left[i];
            i++;
            k++;
        }
        while(j<nR){//trasladar los elementos sobrantes de L2
            X[k]=right[j];
            j++;
            k++;
        }
    }
    
}
