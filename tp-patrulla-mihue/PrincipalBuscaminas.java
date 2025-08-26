/**
 * Clase PrincipalBuscaminas. Lanza el juego Buscaminas.
 *
 * @author Nazareno Aguirre
 * @version 0.2
 */
public class PrincipalBuscaminas {

    /**
     * Método main que inicia el juego Buscaminas.
     * @param args son los parámetros de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crea una instancia de Buscaminas
        Buscaminas buscaminas = new Buscaminas();

        // Inicia el juego
        buscaminas.iniciarJuego();
    }
}
