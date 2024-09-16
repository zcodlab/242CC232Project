package uni.aed.directorio;

import uni.aed.model.Persona;

public class DirectorioV1 implements Directorio{
    private static final int DEFAULT_SIZE=25;
    private static final int NOT_FOUND=-1;
    private Persona[] entry;
    private int count;

    public DirectorioV1() {
        this(DEFAULT_SIZE);
    }    
    
    public DirectorioV1(int size) {
        count=0;
        if(size<=0)
            throw new IllegalArgumentException("tamaño del array debe ser positivo");
        entry=new Persona[size];
    }  
    

    @Override
    public void add(Persona newPersona) {
        if(count==entry.length)
            enlarge();
        entry[count]=newPersona;
        count++;
    }
    
    private void enlarge(){
        int newLength=(int)(1.5*entry.length);
        Persona[] temp=new Persona[newLength];
        for(int i=0; i<entry.length;i++)
           temp[i]=entry[i];
        entry=temp;
    }

    @Override
    public boolean delete(String searchName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona search(String searchName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int search(Object searchValue, String algoritmo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Persona[] sort(int attribute) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "DirectorioV1{" + "entry=" + entry + '}';
    }
    
}
