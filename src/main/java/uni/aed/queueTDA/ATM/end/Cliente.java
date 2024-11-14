package uni.aed.queueTDA.ATM.end;

/**
 * La clase Cliente representa a un cliente en la simulación de cajeros automáticos.
 * Cada cliente tiene un tiempo de transacción y acumula tiempo de espera.
 */
public class Cliente {
    private int tiempoTransaccion; // Tiempo que tomará la transacción
    private int tiempoEspera;      // Tiempo que el cliente ha esperado en la cola    

    /**
     * Constructor de la clase Cliente.
     * @param tiempoTransaccion El tiempo requerido para la transacción del cliente.
     */
    public Cliente(int tiempoTransaccion) {
        this.tiempoTransaccion = tiempoTransaccion;
        this.tiempoEspera = 0;        
    }

    /**
     * Obtiene el tiempo restante de transacción del cliente.
     * @return Tiempo de transacción restante.
     */
    public int getTiempoTransaccion() {
        return tiempoTransaccion;
    }
    //zemr
    public void setTiempoTransaccion(int tiempoTransaccion) {
        this.tiempoTransaccion = tiempoTransaccion;
    }

    /**
     * Obtiene el tiempo que el cliente ha esperado en la cola.
     * @return Tiempo de espera del cliente.
     */
    public int getTiempoEspera() {
        return tiempoEspera;
    }

    /**
     * Incrementa en uno el tiempo de espera del cliente.
     */
    public void incrementarTiempoEspera() {
        this.tiempoEspera++;
    }

    /**
     * Reduce en uno el tiempo restante de transacción del cliente.
     */
    public void reducirTiempoTransaccion() {
        if (this.tiempoTransaccion > 0) {
            this.tiempoTransaccion--;
        }
    }

    /**
     * Verifica si el cliente ha completado su transacción.
     * @return true si el cliente ha sido atendido; false en caso contrario.
     */
    public boolean estaAtendido() {
        return this.tiempoTransaccion == 0;
    }
   
}
