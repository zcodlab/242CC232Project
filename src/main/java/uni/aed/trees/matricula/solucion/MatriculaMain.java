/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uni.aed.trees.matricula.solucion;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author OTI-FC24
 */
public class MatriculaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaMatricula sistema = new SistemaMatricula("src/main/java/uni/aed/trees/matricula/solucion/cursos.txt");
        Scanner sc= new Scanner(System.in);
        
        int choice;
        try{
            do {
                System.out.println("\nMenu");
                System.out.println("--------------");
                System.out.println("1. Agregar Curso");
                System.out.println("2. Matricular alumno");
                System.out.println("3. Anular Matricula");
                System.out.println("4. Visualizar arbol");
                System.out.println("5. Salir");
                System.out.print("Ingrese una opcion: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Ingrese nombre del curso: ");
                        String nombre = sc.next();

                        System.out.println("Ingrese codigo del curso: ");
                        String codigo = sc.next();

                        System.out.println("Ingrese el numero de alumnos matriculados: ");
                        int num = sc.nextInt();

                        System.out.println("Ingrese el maximo de matriculados: ");
                        int max = sc.nextInt();

                        sistema.addCurso(nombre, codigo, num, max);
                        break;
                    case 2:                    
                        System.out.println("Ingrese nombre del curso: ");
                        nombre = sc.next();

                        System.out.println("Ingrese codigo del curso: ");
                        codigo = sc.next();

                        System.out.println("Ingrese el numero de alumnos a matricular: ");
                        num = sc.nextInt();

                        sistema.matricularAlumnos(nombre,codigo,num);
                        break;
                    case 3:
                        System.out.println("Ingrese nombre del curso: ");
                        nombre = sc.next();

                        System.out.println("Ingrese codigo del curso: ");
                        codigo = sc.next();

                        System.out.println("Ingrese el numero de matriculas a anular: ");
                        num = sc.nextInt();

                        sistema.anularMatricula(nombre,codigo,num);
                        break;
                    case 4:
                        System.out.println("Visualizar arbol");
                        sistema.verArbol();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion Invalida, vuelva a intentarlo");
                        break;
                }
            } while (choice != 5);
            sc.close();
            sistema.cleanUpFile();
        }catch(InputMismatchException ex) {
            System.out.println("Debe ingresar obligatoriamente un número entero como opcion elegida.");
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }        
    }
    
}
