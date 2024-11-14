package uni.aed.queueTDA.ATM.end;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que ejecuta el programa y maneja la interacción con el usuario.
 * Proporciona un menú de opciones para ejecutar diferentes simulaciones.
 */
public class ATMMain {    
    private static SimuladorATM simulador;
    private static Scanner scr= new Scanner(System.in).useDelimiter("\n");
    private static int opcion=1;		
    private static String Rpta="S";				
    private static String SEPARADOR="\n";	                                
    public static void main(String[] args) {
        ATMMain aTMMain=new ATMMain();
        aTMMain.menu();
    }    
    private void menu(){        
        try{
            
            do			
            {	
                System.out.print("Simulacion ATM"+SEPARADOR+
                "1.- Ejecutar simulacion con atencion inmediata a clientes restantes "+SEPARADOR+
                "2.- Ejecutar simulacion continuando hasta vaciar colas "+SEPARADOR+                
                "3.- Salir "+SEPARADOR+"Elija una opcion:");                
                opcion =scr.nextInt();            
                switch (opcion)
                {
                    case 1 -> { if(ingresoParametros()==-1) break;
                                simulador.simularAtencionInmediataClientesEnEspera();
                                resultadosSimulacion();}  // Opción 3.2.1
                    case 2 -> { if(ingresoParametros()==-1) break;
                                simulador.simularHastaColasVacias();
                                resultadosSimulacion();}  // Opción 3.2.2                    
                    default -> {break;}
                }	            
                System.out.print("Para continuar con las operaciones pulsa S; Para finalizar pulse N: ");
                Rpta=scr.next().toUpperCase();			
            }while(Rpta.equals("S")==true);	
        }catch(InputMismatchException ex) {
            System.out.println("El valor ingresado es incorrecto, revise y corrija.");
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
        }finally{            
            scr.close();
        }
    }
    private int ingresoParametros(){
        // Solicitar parámetros de simulación
            System.out.print("Ingrese el numero de minutos a simular (M): ");
            int M = scr.nextInt();

            System.out.print("Ingrese la probabilidad de que llegue un cliente cada minuto (P) [0 a 1]: ");
            double P = scr.nextDouble();

            System.out.print("Ingrese el numero de cajeros automaticos (N): ");
            int N = scr.nextInt();

            // Validar entrada
            if (M <= 0 || P < 0 || P > 1 || N <= 0){
                System.out.println("Entrada invalida. Por favor, intente nuevamente.");
                return -1;
            }
            simulador = new SimuladorATM(M, P, N);
            return 1;
    }
    private void resultadosSimulacion(){
        // Mostrar resultados
        System.out.println("\nSimulacion terminada con los siguientes parametros:");
        System.out.println("Minutos simulados (M): " + simulador.getTiempoSimulacion());
        System.out.println("Probabilidad de llegada de clientes (P): " + simulador.getProbabilidadLlegada());
        System.out.println("Numero de cajeros automaticos (N): " + simulador.getNumeroCajeros());
        System.out.println("Total de clientes atendidos: " + simulador.getTotalClientesAtendidos());
        System.out.printf("Tiempo de espera promedio: %.2f minutos\n", simulador.getTiempoEsperaPromedio());
    }
}
