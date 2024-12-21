package uni.aed.trees.matricula2.solucion;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private int numMatriculados;
    private int maxMatriculados;
    private List<Alumno> alumnosMatriculados;

    public Curso(String codigo, String nombre, int numMatriculados, int maxMatriculados) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numMatriculados = numMatriculados;
        this.maxMatriculados = maxMatriculados;
        this.alumnosMatriculados = new ArrayList<>();
    }
    
    

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.alumnosMatriculados = new ArrayList<>();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumMatriculados(int numMatriculados) {
        this.numMatriculados = numMatriculados;
    }

    public void setMaxMatriculados(int maxMatriculados) {
        this.maxMatriculados = maxMatriculados;
    }

    public void setAlumnosMatriculados(List<Alumno> alumnosMatriculados) {
        this.alumnosMatriculados = alumnosMatriculados;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumMatriculados() {
        return numMatriculados;
    }

    public int getMaxMatriculados() {
        return maxMatriculados;
    }

    public List<Alumno> getAlumnosMatriculados() {
        return alumnosMatriculados;
    }
    
    

    public void matricular(Alumno alumno) {
        alumnosMatriculados.add(alumno);
    }

    public void desmatricular(Alumno alumno) {
        alumnosMatriculados.remove(alumno);
    }

    @Override
    public String toString() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Curso: ").append(nombre).append(" (Código: ").append(codigo).append(")\n");
        
        if (alumnosMatriculados.isEmpty()) {
            reporte.append("No hay alumnos matriculados.\n");
        } else {
            reporte.append("Alumnos matriculados:\n");
            for (Alumno alumno : alumnosMatriculados) {
                reporte.append(alumno.toString()).append("\n");
            }
        }
        return reporte.toString();
    }    
    
}
