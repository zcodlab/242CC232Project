package uni.aed.queueTDA.ATM.end;

import uni.aed.tda.listTDA.ListTDA;
import uni.aed.tda.linkedlistTDA.LinkedListTDA;
import uni.aed.queueTDA.QueueTDA;
import uni.aed.queueTDA.QueueEmptyExceptionTDA;
import java.util.Random;

/**
 * La clase SimuladorATM simula el funcionamiento de cajeros automáticos en un banco.
 * Permite ejecutar la simulación bajo diferentes parámetros y obtener estadísticas.
 */
public class SimuladorATM {
    private int M;  // Minutos a simular
    private double P;  // Probabilidad de llegada de un cliente cada minuto
    private int N;  // Número de cajeros automáticos
    private ListTDA<ATM> cajeros;  // Lista de cajeros en el banco
    
    // Variables para almacenar resultados
    private double tiempoEsperaPromedio;
    private int totalClientesAtendidos;    
    private int totalTiempoEspera;    
    private Random rand;

    /**
     * Constructor de la clase SimuladorATM.
     * @param M Minutos a simular.
     * @param P Probabilidad de llegada de un cliente cada minuto.
     * @param N Número de cajeros automáticos.
     */
    public SimuladorATM(int M, double P, int N) {
        this.M = M;
        this.P = P;
        this.N = N;        
        this.cajeros = new LinkedListTDA<>();
        rand = new Random();
        for (int i = 0; i < N; i++) {
            cajeros.add(new ATM());
        }
    }

    /**
     * Ejecuta la simulación asumiendo que todos los clientes restantes
     * serán atendidos inmediatamente al final del período.
     */
    public void simularHastaColasVacias() {
    int min = 0;
    do {
        // Generar nuevos clientes durante los primeros M minutos
        if (min < M && rand.nextDouble() < P)
            generarNuevosClientes();        
        procesarClientesCajero();
        asignarNuevosClientesToCajeros();
        incTiempoEsperaClientesEnCola();
        min++;
    } while (!allQueuesEmpty() || min < M);

    // Al finalizar la simulación, sumamos los clientes atendidos y el tiempo de espera de todos los cajeros
    totalClientesAtendidos = 0;
    totalTiempoEspera = 0;
    for (int i = 0; i < cajeros.size(); i++) {
        ATM cajero = cajeros.get(i);
        totalClientesAtendidos += cajero.getTotalClientesAtendidos();
        totalTiempoEspera += cajero.getTotalTiempoEspera();
    }
    // Calcular tiempo de espera promedio
    setTiempoEsperaPromedio();
    M = min; // Actualizar M si se extendió el tiempo de simulación
}

public void simularAtencionInmediataClientesEnEspera() {    
    int min = 0;
    for (min = 0; min < M; min++) {
        // Determinar si llega un nuevo cliente
        if (rand.nextDouble() < P)
            generarNuevosClientes();        
        procesarClientesCajero();
        asignarNuevosClientesToCajeros();
        incTiempoEsperaClientesEnCola();
    }
    AtenderClientesEnEspera();
    // Calcular tiempo de espera promedio
    setTiempoEsperaPromedio();
    }

    private void generarNuevosClientes(){
        int tiempoTransaccion = rand.nextInt(5) + 1; // Tiempo entre 1 y 5 minutos
        Cliente nuevoCliente = new Cliente(tiempoTransaccion);
        asignarCliente(nuevoCliente);
    }

    /**
     * Asigna un cliente al cajero con la cola más corta.
     * @param cliente El cliente a asignar.
     */
    private void asignarCliente(Cliente cliente) {
        ATM mejorCajero = null;
        int colaMinima = Integer.MAX_VALUE;

        for (int i = 0; i < cajeros.size(); i++) {
            ATM cajero = cajeros.get(i);
            int tamCola = cajero.getColaClientes().size();
            if (tamCola < colaMinima) {
                mejorCajero = cajero;
                colaMinima = tamCola;
            }
        }

        mejorCajero.asignarCliente(cliente);
    }    
    private void procesarClientesCajero(){
        // Procesar clientes en cada cajero
        for (int i = 0; i < cajeros.size(); i++) {
            ATM cajero = cajeros.get(i);
            cajero.procesarCliente();
        }
    }
    private void asignarNuevosClientesToCajeros(){
        // Asignar nuevos clientes a cajeros disponibles
        for (int i = 0; i < cajeros.size(); i++) {
            ATM cajero = cajeros.get(i);
            if (cajero.estaDisponible()) {
                cajero.atenderSiguienteCliente();
            }
        }
    }
    private void incTiempoEsperaClientesEnCola(){
        // Incrementar tiempo de espera de clientes en cola
        for (int i = 0; i < cajeros.size(); i++) {
            ATM cajero = cajeros.get(i);
            QueueTDA<Cliente> cola = cajero.getColaClientes();
            int colaSize = cola.size();
            for (int j = 0; j < colaSize; j++) {
                try {
                    Cliente cliente = cola.dequeue();
                    cliente.incrementarTiempoEspera();
                    cola.enqueue(cliente);
                } catch (QueueEmptyExceptionTDA e) {
                    // La cola está vacía
                }
            }
        }
    }
    private void AtenderClientesEnEspera(){
        // Al final, atender todos los clientes restantes inmediatamente
        // Los clientes restantes son atendidos sin esperar más
        totalClientesAtendidos = 0;
        totalTiempoEspera = 0;
        for (int i = 0; i < cajeros.size(); i++) {
            ATM cajero = cajeros.get(i);
            // Añadir clientes atendidos durante la simulación
            totalClientesAtendidos += cajero.getTotalClientesAtendidos();
            totalTiempoEspera += cajero.getTotalTiempoEspera();
            // Atender los clientes restantes inmediatamente
            QueueTDA<Cliente> cola = cajero.getColaClientes();
            while (!cola.isEmpty()) {
                try {
                    Cliente cliente = cola.dequeue();                
                    abrirNuevoCajeroClienteEnEspera(cliente);              
                    totalClientesAtendidos++;
                    totalTiempoEspera += cliente.getTiempoEspera();
                    // No incrementamos tiempo de espera adicional, ya que son atendidos inmediatamente
                } catch (QueueEmptyExceptionTDA e) {
                    // La cola está vacía                
                }
            }
        }
    }
    private void abrirNuevoCajeroClienteEnEspera(Cliente cliente){
        ATM adicionalATM=new ATM();
        cajeros.add(adicionalATM);
        int tiempoTransaccion = rand.nextInt(5) + 1; // Tiempo entre 1 y 5 minutos
        cliente.setTiempoTransaccion(tiempoTransaccion);                
        adicionalATM.asignarCliente(cliente);   
        N++;//se incrementa el numero de cajeros por cada cliente que quedo en cola          
    }
    /**
     * Verifica si todas las colas de los cajeros están vacías.
     * @return true si todas las colas están vacías y no hay clientes siendo atendidos; false en caso contrario.
     */
    private boolean allQueuesEmpty() {
        for (int i = 0; i < cajeros.size(); i++) {
            ATM cajero = cajeros.get(i);
            if (!cajero.getColaClientes().isEmpty() || cajero.estaEnUso()) {
                return false;
            }
        }
        return true;
    }

    // Métodos getter para obtener resultados
    public double getTiempoEsperaPromedio() {
        return tiempoEsperaPromedio;
    }

    public int getTotalClientesAtendidos() {
        return totalClientesAtendidos;
    }

    public int getTiempoSimulacion() {
        return M;
    }

    public double getProbabilidadLlegada() {
        return P;
    }

    public int getNumeroCajeros() {
        return N;
    }

    public void setTiempoEsperaPromedio() {
        this.tiempoEsperaPromedio = (totalClientesAtendidos > 0) ? (double) totalTiempoEspera / totalClientesAtendidos : 0;
    }
    
    
}
