/**
 * La clase Buscaminas es la clase principal del juego Buscaminas.
 * Buscaminas es un conocido juego para un solo jugador, popularizado por versiones antiguas
 * de MS Windows. Esta implementación es para la versión "fácil" del juego.
 *
 * @author N. Aguirre
 * @version 0.2
 */
public class Buscaminas {

    /**
     * comando para abrir celda
     */
    public static final String CMD_ABRIR = "abrir";

    /**
     * comando para bloquear celda
     */
    public static final String CMD_BLOQUEAR = "bloquear";

    /**
     * comando para desbloquear celda
     */
    public static final String CMD_DESBLOQUEAR = "desbloquear";

    /**
     * Número de filas en el juego
     */
    public static final int FILAS = 9;

    /**
     * Número de columnas en el juego
     */
    public static final int COLUMNAS = 9;

    /**
     * Número de minas
     */
    public static final int MINAS = 10;

    /**
     * Lector de entrada para procesar comandos del usuario
     */
    private LectorEntrada lector;

    /**
     * Objeto que representa el estado del juego Buscaminas
     */
    private EstadoJuegoBuscaminas juego;

    /**
     * ¿El juego ha comenzado?
     */
    private boolean juegoIniciado;

    /**
     * Constructor de Buscaminas. Lanza un juego buscaminas con un tablero
     * de 9 filas por 9 columnas, con 10 minas. El juego se inicia y se procesan
     * las entradas del usuario hasta que el juego termina, ya sea ganando o perdiendo.
     */
    public Buscaminas() {
        lector = new LectorEntrada(); // crea el lector de entrada
        juego = new EstadoJuegoBuscaminas(); // inicializa el estado del juego

        juegoIniciado = false; // juego no iniciado
    }

    /**
     * Inicia el juego.
     */
    public void iniciarJuego() {
        if (juegoIniciado) {
            throw new IllegalStateException("El juego terminó. Crea un nuevo juego para jugar otra vez.");
        }
        juegoIniciado = true;
        while (!juego.juegoTerminado()) {
            System.out.println(juego.toString());

            lector.leerEntradaUsuario();
            String comando = lector.getComando();
            int fila = lector.getFila();
            int columna = lector.getColumna();

            ejecutarComandoUsuario(comando, fila, columna);
        }

        if (juego.esVictoria()) {
            System.out.println("¡¡Ganaste!!");
        }
        else {
            System.out.println("Perdiste :(");
        }
        juego.abrirTodasLasCeldas();
        System.out.print(juego.toString());
        juegoIniciado = false;
    }

    /**
     * Ejecuta un comando del usuario, delegando la acción apropiada al objeto de estado del juego.
     * @param comando es el comando a ejecutar
     * @param fila es la fila de la celda afectada
     * @param columna es la columna de la celda afectada
     */
    private void ejecutarComandoUsuario(String comando, int fila, int columna) {
        if (comando.equals(CMD_ABRIR)) {
            if (!juego.estaAbierta(fila, columna) && !juego.estaBloqueada(fila, columna)) {
                juego.abrir(fila, columna);
            }
            else {
                System.out.println("No se puede abrir. La celda ya está abierta o bloqueada.");
            }
        }
        else {
            if (comando.equals(CMD_BLOQUEAR)) {
                if (!juego.estaAbierta(fila, columna) && !juego.estaBloqueada(fila, columna)) {
                    juego.bloquear(fila, columna);
                }
                else {
                    System.out.println("No se puede bloquear. La celda ya está bloqueada o abierta.");
                }
            }
            else {
                if (juego.estaBloqueada(fila, columna)) {
                    juego.desbloquear(fila, columna);
                }
                else {
                    System.out.println("No se puede desbloquear. La celda no está bloqueada.");
                }
            }
        }
    }
}