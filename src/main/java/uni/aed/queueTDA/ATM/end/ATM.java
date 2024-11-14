package uni.aed.queueTDA.ATM.end;

import uni.aed.queueTDA.QueueTDA;
import uni.aed.queueTDA.LinkedQueueTDA;
import uni.aed.queueTDA.QueueEmptyExceptionTDA;

/**
 * La clase ATM representa un cajero automático en la simulación.
 * Administra la cola de clientes y procesa las transacciones.
 */
public class ATM {
    private boolean disponible;       // Indica si el cajero está disponible
    private QueueTDA<Cliente> colaClientes;  // Cola de clientes esperando
    protected Cliente clienteActual;  // Cliente actualmente siendo atendido

    // Variables para estadísticas
    private int totalClientesAtendidos;
    private int totalTiempoEspera;
    /**
     * Constructor de la clase ATM.
     * Inicializa el cajero como disponible y crea una nueva cola de clientes.
     */
    public ATM() {
        this.disponible = true;
        this.colaClientes = new LinkedQueueTDA<>();
        this.clienteActual = null;
        this.totalClientesAtendidos = 0;
        this.totalTiempoEspera = 0;
    }

    /**
     * Verifica si el cajero está actualmente en uso.
     * @return true si está atendiendo a un cliente; false si está disponible.
     */
    public boolean estaEnUso() {
        return clienteActual != null;
    }

    /**
     * Asigna un cliente al cajero si está disponible; de lo contrario, lo agrega a la cola.
     * @param cliente El cliente a asignar.
     */
    public void asignarCliente(Cliente cliente) {
        if (disponible) {
            clienteActual = cliente;
            disponible = false;
        } else {
            colaClientes.enqueue(cliente);
        }
    }

    /**
     * Procesa la transacción del cliente actual.
     * Reduce el tiempo de transacción y verifica si ha sido atendido.
     */
    public void procesarCliente() {
        if (clienteActual != null) {
            clienteActual.reducirTiempoTransaccion();
            if (clienteActual.estaAtendido()) {
                // Cliente ha sido atendido
                totalClientesAtendidos++;
                totalTiempoEspera += clienteActual.getTiempoEspera();
                disponible = true;
                clienteActual = null;
            }
        }
    }

    /**
     * Atiende al siguiente cliente en la cola si el cajero está disponible.
     */
    public void atenderSiguienteCliente() {
        if (disponible && !colaClientes.isEmpty()) {
            try {
                clienteActual = colaClientes.dequeue();
                disponible = false;
            } catch (QueueEmptyExceptionTDA e) {
                // La cola está vacía, no hacer nada
            }
        }
    }
    
    /**
     * Obtiene el total de clientes atendidos por este cajero.
     * @return Número de clientes atendidos.
     */
    public int getTotalClientesAtendidos() {
        return totalClientesAtendidos;
    }
    
    /**
     * Obtiene el total de tiempo de espera acumulado por este cajero.
     * @return Tiempo de espera acumulado.
     */
    public int getTotalTiempoEspera() {
        return totalTiempoEspera;
    }
    /**
     * Obtiene la cola de clientes del cajero.
     * @return La cola de clientes.
     */
    public QueueTDA<Cliente> getColaClientes() {
        return colaClientes;
    }

    /**
     * Verifica si el cajero está disponible.
     * @return true si está disponible; false si está en uso.
     */
    public boolean estaDisponible() {
        return disponible;
    }
}
