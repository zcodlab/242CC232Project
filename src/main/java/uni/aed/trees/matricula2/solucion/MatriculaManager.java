package uni.aed.trees.matricula2.solucion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MatriculaManager {
  private AvlTree tree = new AvlTree();
  private final String filePathCurso = "src/main/java/uni/aed/trees/matricula2/solucion/Cursos.txt";
  private final String filePathMatricula = "src/main/java/uni/aed/trees/matricula2/solucion/Matricula.txt";

  public MatriculaManager() {
    loadInitialData();
  }

  private void loadInitialData() {
    try {
      List<String> courses = FileManager.readFile(filePathCurso);
      for (String line : courses) {
        String[] parts = line.split("\\s+");
        if (parts.length >= 2) {
          String codigo = parts[0].trim();
          String nombre = parts[1].trim();
          int numMat = Integer.parseInt(parts[2].trim());
          int maxMat = Integer.parseInt(parts[3].trim());
          Curso curso=new Curso(codigo,nombre,numMat,maxMat);
          tree.addCourse(curso);
        }
      }
      List<String> enrollments = FileManager.readFile(filePathMatricula);
      for (String line : enrollments) {
        String[] parts = line.split("\\s+");
        if (parts.length >= 3) {
          String codigoCurso = parts[0].trim();
          String codigoAlumno = parts[1].trim();
          String nombres = parts[2].trim();
          String apellidos = parts[3].trim();

          AvlTreeNode courseNode = tree.findCourse(tree.getRoot(), codigoCurso);
          if (courseNode != null) {
            courseNode.curso.getAlumnosMatriculados().add(new Alumno(codigoAlumno, nombres, apellidos));
            courseNode.curso.setNumMatriculados(courseNode.curso.getNumMatriculados());            
          } else 
            System.out.println("Error: Curso no encontrado para matrícula " + codigoCurso);          
        }
      }
    } catch (IOException e) {
      System.out.println("Error cargando datos: " + e.getMessage());
    }
  }

  private String[] splitName(String fullName) {
    return fullName.split("(?<!^)(?=[A-Z])");
  }

  public void appendCourseToFile(Curso curso) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathCurso, true))) {
      writer.write(curso.getCodigo() + "\t" + curso.getNombre() + "\t" + curso.getNumMatriculados() + "\t" + curso.getMaxMatriculados());
      writer.newLine();
    } catch (IOException e) {
      System.out.println("Error al agregar curso al archivo: " + e.getMessage());
    }
  }

  public void appendEnrollmentToFile(String codigoCurso, Alumno alumno) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathMatricula, true))) {
      writer.write(codigoCurso + "\t" + alumno.getCodigo() + "\t" + alumno.getNombres() + "\t" + alumno.getApellidos());
      writer.newLine();
    } catch (IOException e) {
      System.out.println("Error al agregar matrícula al archivo: " + e.getMessage());
    }
  }

  

  public void overwriteFiles() {
    try {
      List<String> courseLines = new ArrayList<>();
      tree.populateCoursesFile(tree.getRoot(), courseLines);
      FileManager.writeFile(filePathCurso, courseLines);

      List<String> enrollmentLines = new ArrayList<>();
      tree.populateEnrollmentsFile(tree.getRoot(), enrollmentLines);
      FileManager.writeFile(filePathMatricula, enrollmentLines);

      System.out.println("Archivos actualizados correctamente.");
    } catch (IOException e) {
      System.out.println("Error actualizando archivos: " + e.getMessage());
    }
  }
  
  public void displayReport(){
      tree.displayReport();
  }
  
  public void addCourse(Curso curso){
       tree.addCourse(curso);
  }
  
  public boolean enrollStudent(String codigoCurso, Alumno alumno){
      return tree.enrollStudent(codigoCurso, alumno);
  }
  public boolean cancelEnrollment(String codigoCurso, String codigoAlumno){
      return tree.cancelEnrollment(codigoCurso, codigoAlumno);
  }
}


