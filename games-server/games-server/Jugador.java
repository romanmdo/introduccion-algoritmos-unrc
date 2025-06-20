public class Jugador {
    
    // nombre del jugador
    private String nombre;
    
    // Nivel del jugador
    private int nivel;
    
    // Conectado o desconectado
    private boolean conectado;

    public Jugador(String nombre, int nivel, boolean conectado) {
        assert nombre != null;
        assert !nombre.trim().isEmpty();
        assert nivel >= 0;
        
        this.nombre = nombre;
        this.nivel = nivel;
        this.conectado = conectado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean estaConectado() {
        return conectado;
    }

    public void desconectar() {
        this.conectado = false;
    }

    public void subirNivel() {
        this.nivel++;
    }

    @Override
    public String toString() {
        return nombre + " - Nivel " + nivel + " - " + (conectado ? "En línea" : "Desconectado");
    }
}
