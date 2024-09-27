/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.model;

/**
 *
 * @author zemr
 */
public class Bicicleta implements Comparable{
    private String nomPropietario;

    public Bicicleta(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public void setNomPropietario(String nomPropietario) {
        this.nomPropietario = nomPropietario;
    }

    public String getNomPropietario() {
        return nomPropietario;
    }

    @Override
    public String toString() {
        return "Bicicleta{" + "nomPropietario=" + nomPropietario + '}';
    }

    @Override
    public int compareTo(Object o) {//1(o1>o2),0(o1=o2),-1(o1<o2)
        return compareTo((Bicicleta)o);
    }
    
    private int compareTo(Bicicleta o){
        String o2=o.getNomPropietario();
        return this.nomPropietario.compareTo(o2);
    }
    
}
