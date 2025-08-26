/**
 * CeldaBuscaminas representa las celdas de un juego Buscaminas. Una celda puede contener una mina
 * o estar vacía. Puede estar abierta o cerrada (al abrirla se revela su contenido, y si contiene
 * una mina, finaliza el juego). Una celda puede bloquearse para evitar abrirla accidentalmente.
 *
 * @author Nazareno Aguirre
 * @version 0.2
 */
public class CeldaBuscaminas
{
    /**
     * ¿Está la celda bloqueada? Una celda bloqueada está cerrada y no puede abrirse.
     */
    private boolean estaBloqueada;

    /**
     * ¿Contiene la celda una mina? Al abrir una celda con mina, se termina el juego.
     */
    private boolean tieneMina;

    /**
     * ¿Está la celda abierta?
     */
    private boolean estaAbierta;

    /**
     * Constructor de CeldaBuscaminas.
     * Crea una celda que está cerrada, desbloqueada y sin minas.
     */
    public CeldaBuscaminas()
    {
        this.estaBloqueada = false;
        this.tieneMina = false;
        this.estaAbierta = false;
    }

    /**
     * @return true si y solo si la celda está bloqueada
     */
    public boolean estaBloqueada()
    {
        return this.estaBloqueada;
    }

    /**
     * @return true si y solo si la celda está cerrada
     */
    public boolean estaCerrada()
    {
        return !this.estaAbierta;
    }

    /**
     * @return true si y solo si la celda está abierta
     */
    public boolean estaAbierta()
    {
        return this.estaAbierta;
    }

    /**
     * @return true si y solo si la celda contiene una mina
     */
    public boolean tieneMina()
    {
        return this.tieneMina;
    }

    /**
     * Coloca una mina en la celda. La celda no debe tener ya una mina ni estar abierta.
     */
    public void colocarMina()
    {
        if (this.tieneMina() || this.estaAbierta()) {
            throw new IllegalStateException("No se puede colocar mina en una celda abierta o que ya tiene mina");
        }
        this.tieneMina = true;
    }

    /**
     * Abre una celda. Una celda puede abrirse si está cerrada y no bloqueada.
     */
    public void abrir()
    {
        //TODO implementar este método, incluyendo chequeo de precondición
        if (this.estaAbierta || this.estaBloqueada) {
            throw new IllegalStateException("La celda ya se encuentra abierta o está bloqueada");
        }
        
        this.estaAbierta = true;
    }

    /**
     * Bloquea una celda cerrada que no esté bloqueada.
     */
    public void bloquear()
    {
        //TODO implementar este método, incluyendo chequeo de precondición
        if (this.estaAbierta || this.estaBloqueada) {
            throw new IllegalStateException("La celda ya se encuentra bloqueada o está abierta");
        }
        
        this.estaBloqueada = true;
    }

    /**
     * Desbloquea una celda bloqueada.
     */
    public void desbloquear()
    {
        //TODO implementar este método, incluyendo chequeo de precondición
        if (!this.estaBloqueada) {
            throw new IllegalStateException("La celda ya está desbloqueada");
        }
        
        this.estaBloqueada = false;
    }
}
