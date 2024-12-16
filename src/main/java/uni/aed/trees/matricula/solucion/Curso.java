/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uni.aed.trees.matricula.solucion;

/**
 *
 * @author OTI-FC24
 */
public class Curso {
    private String nombre;
    private String codigo;
    private int numMatriculados;
    private int maxMatriculados;

    public Curso(String nombre, String codigo, int numMatriculados, int maxMatriculados) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.numMatriculados = numMatriculados;
        this.maxMatriculados = maxMatriculados;
        if(numMatriculados>maxMatriculados) this.numMatriculados=maxMatriculados;
        else if (numMatriculados<0) this.numMatriculados=0;
    }
    
    public void setCodigo(String codigo) {
        this.codigo=codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getNumMatriculados() {
        return numMatriculados;
    }

    public void setNumMatriculados(int numMatriculados) {
        if(numMatriculados>maxMatriculados) this.numMatriculados=maxMatriculados;
        else if (numMatriculados<0) this.numMatriculados=0;
        else this.numMatriculados = numMatriculados;
    }

    public int getMaxMatriculados() {
        return maxMatriculados;
    }

    public void setMaxMatriculados(int maxMatriculados) {
        this.maxMatriculados = maxMatriculados;
        if(numMatriculados>maxMatriculados) this.numMatriculados=maxMatriculados;
    }

    @Override
    public String toString() {
        return nombre + "|" + codigo + "|" + numMatriculados + "|" + maxMatriculados;
    }
    
    
}
