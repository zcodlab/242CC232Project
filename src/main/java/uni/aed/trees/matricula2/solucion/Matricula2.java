package uni.aed.trees.matricula2.solucion;

import java.util.Scanner;

public class Matricula2 {
  MatriculaManager matricula = new MatriculaManager();
  
  public static void main(String[] args) {          
    Matricula2 m2=new Matricula2();    
    m2.displayMenu();    
  }
  
  public void displayMenu() {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    int option;
    do {
      System.out.println("\n--- MENÚ DE MATRICULACIÓN ---");
      System.out.println("1. Agregar Curso");
      System.out.println("2. Matricular Alumno");
      System.out.println("3. Anular Matrícula");
      System.out.println("4. Visualizar Reporte de Matrículas");
      System.out.println("5. Salir");
      System.out.print("Seleccione una opción: ");
      option = scanner.nextInt();
      //scanner.next();

      switch (option) {
        case 1:
          addCourse(scanner);
          break;
        case 2:
          enrollStudent(scanner);
          break;
        case 3:
          cancelEnrollment(scanner);
          break;
        case 4:
          displayReport();
          break;
        case 5:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción no válida.");
      }
    } while (option != 5);
    scanner.close();
  }

  private void addCourse(Scanner scanner) {
    System.out.print("Código del curso: ");
    String codigo = scanner.next();
    System.out.print("Nombre del curso: ");
    String nombre = scanner.next();
    System.out.print("Numero de matriculados: ");
    int numMat = scanner.nextInt();
    System.out.print("Tope de matriculados: ");
    int maxMat = scanner.nextInt();
    Curso curso=new Curso(codigo,nombre,numMat,maxMat);
    matricula.addCourse(curso);
    matricula.appendCourseToFile(curso);
    System.out.println("Curso agregado.");
  }

  private void enrollStudent(Scanner scanner) {
    System.out.print("Código del curso: ");
    String codigoCurso = scanner.next();
    System.out.print("Código del alumno: ");
    String codigoAlumno = scanner.next();
    System.out.print("Nombres del alumno: ");
    String nombres = scanner.next();
    System.out.print("Apellidos del alumno: ");
    String apellidos = scanner.next();
    Alumno alumno=new Alumno(codigoAlumno,nombres,apellidos);
    if (matricula.enrollStudent(codigoCurso, alumno)) {
      matricula.appendEnrollmentToFile(codigoCurso, alumno);
      System.out.println("Alumno matriculado.");
    }
  }

  private void cancelEnrollment(Scanner scanner) {
    System.out.print("Código del curso: ");
    String codigoCurso = scanner.next();
    System.out.print("Código del alumno: ");
    String codigoAlumno = scanner.next();
    if (matricula.cancelEnrollment(codigoCurso, codigoAlumno)) {
      System.out.println("Matrícula anulada con éxito.");
      matricula.overwriteFiles();
    } else
      System.out.println("No se pudo anular la matrícula. Verifique los datos ingresados.");    
  }
  
  private void displayReport(){
     matricula.displayReport(); 
  }
}
