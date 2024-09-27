package uni.aed.directorio;

import uni.aed.model.Persona;

public interface Directorio {
    public void add(Persona newPersona);
    public boolean delete(String searchName);
    public Persona search(String searchName);
    public int search(Object searchValue, String algoritmo);
    public Persona[] sort(int attribute);    
    //definicion del metodo sort que atiende el enunciado 1 de la 1PC
    public Object[ ] sort ( int attribute, String algoritmo ); 
}
