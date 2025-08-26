import java.util.Collections;
import java.util.ArrayList;

/**
 * EstadoJuegoBuscaminas representa el estado actual del juego Buscaminas.
 * Contiene el tablero de juego y la lógica principal del juego.
 *
 * @author Nazareno Aguirre
 * @version 0.2
 */
public class EstadoJuegoBuscaminas {

    /**
     * El tablero del juego, compuesto por celdas
     */
    private CeldaBuscaminas[][] tablero;

    /**
     * Indica si el juego ha terminado
     */
    private boolean juegoTerminado;

    /**
     * Constructor de EstadoJuegoBuscaminas. Crea un tablero con minas en posiciones aleatorias.
     * El número de filas está determinado por Buscaminas.FILAS.
     * El número de columnas está determinado por Buscaminas.COLUMNAS.
     * El número de minas está determinado por Buscaminas.CANTIDAD_MINAS.
     */
    public EstadoJuegoBuscaminas() {
        tablero = new CeldaBuscaminas[Buscaminas.FILAS][Buscaminas.COLUMNAS];
        // No modificar arriba de esta línea

        //TODO: Agregar código para cargar el tablero. El tablero es un arreglo bi
        // dimensional de Buscaminas.FILAS filas y Buscaminas.COLUMNAS columnas.
        // Debe cargarse con Buscaminas.FILAS * Buscaminas.COLUMNAS objetos de tipo
        // CeldaBuscaminas diferentes.
        for (int i = 0; i < Buscaminas.FILAS; ++i) {
            for (int j = 0; j < Buscaminas.COLUMNAS; ++j) {
                tablero[i][j] = new CeldaBuscaminas();
            }
        }

        // No modificar debajo de esta línea
        colocarMinasAleatorias();
        juegoTerminado = false;
    }

    /**
     * Coloca minas aleatorias en un tablero vacío. La cantidad de minas está determinada por
     * Buscaminas.CANTIDAD_MINAS.
     */
    private void colocarMinasAleatorias() {
        ArrayList<CeldaBuscaminas> todasLasCeldas = new ArrayList<CeldaBuscaminas>();
        for (int fila = 0; fila < Buscaminas.FILAS; fila++) {
            for (int columna = 0; columna < Buscaminas.COLUMNAS; columna++) {
                todasLasCeldas.add(tablero[fila][columna]);
            }
        }
        Collections.shuffle(todasLasCeldas);
        for (CeldaBuscaminas celda : todasLasCeldas.subList(0, Buscaminas.MINAS)) {
            celda.colocarMina();
        }
    }

    /**
     * Verifica si el juego ha terminado.
     * @return true si y solo si el juego terminó.
     */
    public boolean juegoTerminado() {
        return juegoTerminado;
    }

    /**
     * Verifica si la celda en las coordenadas dadas está bloqueada (marcada).
     * @param fila coordenada de fila de la posición a verificar
     * @param columna coordenada de columna de la posición a verificar
     * @return true si y solo si la posición (fila,columna) está bloqueada.
     */
    public boolean estaBloqueada(int fila, int columna) {
        return tablero[fila][columna].estaBloqueada();
    }

    /**
     * Marca la celda en las coordenadas dadas como bloqueada si el juego no ha terminado.
     * @param fila número de fila donde está ubicada la celda
     * @param columna número de columna donde está ubicada la celda
     */
    public void bloquear(int fila, int columna) {
        if(!juegoTerminado) {
            tablero[fila][columna].bloquear();
        }
    }

    /**
     * Desbloquea la celda en la posición actual si está bloqueada.
     * @param fila número de fila donde está ubicada la celda
     * @param columna número de columna donde está ubicada la celda
     */
    public void desbloquear(int fila, int columna) {
        tablero[fila][columna].desbloquear();
    }

    /**
     * Indica si la celda está abierta o no.
     * @param fila número de fila donde está ubicada la celda
     * @param columna número de columna donde está ubicada la celda
     * @return true si la celda en la posición dada está abierta.
     */
    public boolean estaAbierta(int fila, int columna) {
        return tablero[fila][columna].estaAbierta();
    }

    /**
     * Abre una celda en la posición dada. Después de abrirla, si no hay mina en
     * la ubicación, verifica si el número de celdas cerradas coincide con el
     * número de minas, para determinar si el juego terminó. En tal caso, declara
     * el juego terminado llamando a terminarJuego().
     * @param fila número de fila donde está ubicada la celda
     * @param columna número de columna donde está ubicada la celda
     */
    public void abrir(int fila, int columna)
    {
        //TODO Implementar este método.
        //  Este método abre la celda en posición (fila,columna).
        //  Precondición: la celda debe estar cerrada y no bloqueada.
        //  Si al abrir, la celda contiene una mina, el juego termina.
        //  Si al abrir, la celda no contiene mina y tiene cero minas vecinas,
        //  entonces todas las celdas vecinas sin minas deben abrirse también (efecto cascada).
        //  Si después de abrir la celda (y potencialmente del efecto cascada) solo quedan cerradas
        //  las celdas con minas (es decir, no quedan celdas sin minas cerradas), el juego también termina.
        
        if (estaAbierta(fila, columna) || estaBloqueada(fila, columna)) {
            throw new IllegalStateException("La celda debe estar cerrada y desbloqueada");
        }
        
        tablero[fila][columna].abrir();

        if (tablero[fila][columna].tieneMina()) {
            terminarJuego();
            return;
        }
        
        if (contarMinasVecinas(fila, columna) == 0) {
            abrirMinasVecinas(fila, columna);
        }
        
        if (contarCeldasCerradas() == Buscaminas.MINAS) {
            terminarJuego();
        }
    }

    /**
     * Finaliza el juego.
     */
    public void terminarJuego() {
        juegoTerminado = true;
    }

    /**
     * Indica si el jugador ganó. El juego debe haber terminado.
     * @return true si las celdas cerradas son iguales a la cantidad de minas
     * @throws IllegalStateException si el juego no ha terminado
     */
    public boolean esVictoria() {
        if (!juegoTerminado) throw new IllegalStateException("El juego no ha terminado");
        return contarCeldasCerradas() == Buscaminas.MINAS;
    }

    /**
     * Cuenta el número de minas en las celdas vecinas a la celda en posición (fila, columna)
     * @param fila coordenada de fila de la celda a verificar
     * @param columna coordenada de columna de la celda a verificar
     * @return número de celdas vecinas que contienen minas. El resultado puede estar entre 0 y 8.
     */
    public int contarMinasVecinas(int fila, int columna) {
        //TODO Implementar este método. Reemplazar la línea siguiente por la implementación del método.
        int minasVecinas = 0;
        
        for (int i = -1; i <= 1; ++i) {
            int y = fila + i;
            for (int j = -1; j <= 1; ++j) {
                int x = columna + j;
                if (!esCoordenadaValida(y, x) || (y == fila && x == columna)) continue;
                
                if (tablero[y][x].tieneMina()) {
                    ++minasVecinas;
                }
            }
        }
        
        return minasVecinas;
    }

    /**
     * Abre todas las celdas cerradas en el tablero, independientemente de si tienen minas
     * o están bloqueadas. Las celdas bloqueadas deben desbloquearse antes de abrirlas.
     */
    public void abrirTodasLasCeldas() {
        //TODO Implementar este método.
        for (int i = 0; i < Buscaminas.FILAS; ++i) {
            for (int j = 0; j < Buscaminas.COLUMNAS; ++j) {
                if (estaAbierta(i, j)) continue;
                
                if (estaBloqueada(i, j)) {
                    desbloquear(i, j);
                }
                tablero[i][j].abrir();
            }
        }
    }

    /**
     * Verifica si las coordenadas son válidas.
     * @param fila número de fila a verificar
     * @param columna número de columna a verificar
     * @return true si las coordenadas están dentro del rango válido del tablero
     */
    public static boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < Buscaminas.FILAS && columna >= 0 && columna < Buscaminas.COLUMNAS;
    }

    /**
     * Calcula el número de celdas cerradas en el tablero.
     * @return número de celdas cerradas en el tablero.
     */
    public int contarCeldasCerradas() {
        int cant = 0;
        
        for (int fila = 0; fila < Buscaminas.FILAS; fila++) {
            for (int columna = 0; columna < Buscaminas.COLUMNAS; columna++) {
                if (!estaAbierta(fila, columna)) {
                    cant += 1;
                }
            }
        }
        
        return cant;
    }

    /**
     * Proporciona una representación textual del estado del juego.
     * @return String que representa visualmente el estado del juego.
     */
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        if(juegoTerminado) {
            resultado.append("Juego Terminado.\n");
        } else {
            resultado.append("Juego en Progreso.\n");
        }

        resultado.append("   0  1  2  3  4  5  6  7  8  \n");
        resultado.append("   --------------------------\n");

        for (int fila = 0; fila < Buscaminas.FILAS; fila++) {
            resultado.append(fila).append("|");
            for (int columna = 0; columna < Buscaminas.COLUMNAS; columna++) {
                CeldaBuscaminas celdaActual = tablero[fila][columna];

                if(celdaActual.estaAbierta()) {
                    if(celdaActual.tieneMina()) {
                        resultado.append(" X ");
                    } else {
                        resultado.append(" ").append(this.contarMinasVecinas(fila, columna)).append(" ");
                    }
                } else {
                    if(celdaActual.estaBloqueada()) {
                        resultado.append(" B ");
                    } else {
                        resultado.append(" - ");
                    }
                }
            }
            resultado.append("|").append(fila).append("\n");
        }

        resultado.append("   --------------------------\n");
        resultado.append("   0  1  2  3  4  5  6  7  8 \n");

        return resultado.toString();
    }
    
    private void abrirMinasVecinas(int fila, int columna)
    {
        for (int i = -1; i <= 1; ++i) {
            int y = fila + i;
            for (int j = -1; j <= 1; ++j) {
                int x = columna + j;
                if (!esCoordenadaValida(y, x) || (y == fila && x == columna)) continue;
                
                if (!tablero[y][x].tieneMina() && !estaAbierta(y, x) && !estaBloqueada(y, x)) {
                    tablero[y][x].abrir();
                }
            }
        }
    }
}
