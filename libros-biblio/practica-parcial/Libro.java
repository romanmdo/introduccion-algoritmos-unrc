/**
 * Clase Libro: representa un libro de una biblioteca personal.
 */
public class Libro {
    private String titulo;
    private String autor;
    private int id;
    private boolean estaPrestado;

    public Libro(String titulo, String autor, int id, boolean estaPrestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.estaPrestado = estaPrestado;
    }

    /**
     * Retorna el autor del libro
     */
    
    public String getTitulo()
    {
        return titulo;    
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getId() {
        return id;
    }
    
    public void cambiarTitulo(String nuevoTitulo)
    {
        this.titulo = nuevoTitulo;
    }
}
