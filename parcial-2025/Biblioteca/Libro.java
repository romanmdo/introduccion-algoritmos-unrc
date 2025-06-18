package Biblioteca;

/**
 * Representa un libro, con su información básica.
 *
 */
public class Libro {

    // título del libro 
    private String titulo;

    // nombre del autor
    private String autor;

    // año de edición
    private int anho;

    // es novela?
    private boolean esNovela;

    /**
     * Crea un nuevo libro con todos sus datos.
     * @param titulo es el título del libro
     * @param autor es el nombre del autor (cadena vacía si el autor es desconocido)
     * @param anho es el año de edición del libro 
     * @param esNovela indica si el libro es una novela
     * Precondición: el título no puede ser null ni vacío.
     * Precondición: el autor no puede ser null.
     */
    public Libro(String titulo, String autor, int anho, boolean esNovela) {
        assert titulo != null;
        assert titulo.length() > 0;
        assert !titulo.trim().isEmpty();
        assert autor != null;
        
        this.titulo = titulo;
        this.autor = autor;
        this.anho = anho;
        this.esNovela = esNovela;
    }

    /**
     * Retorna el título del libro.
     * @return el título del libro
     */
    public String obtenerTitulo() {
        return titulo;
    }

    /**
     * Retorna el año de edición del libro
     * @return año de edición del libro
     */
    public int obtenerAnho() {
        return anho;
    }

    /**
     * Retorna el autor del libro.
     */
    public String obtenerAutor() {
        return autor;
    }

    /**
     * Retorna los detalles del libro, como cadena de caracteres.
     *
     * @return detalles del libro en una cadena de caracteres,
     * usando el formato "<titulo> (año <anho>). Novela de <autor>.", si el libro es una novela, o
     *  "<titulo> (año <anho>). Libro de <autor>.", si el libro no es una novela.
     */
    public String toString() {
        String cadena = "";
        
        if(esNovela == true)
        {
            cadena = titulo + " (año " + anho + "). Novela de " + autor + ".";
            return cadena;
        } else
        
        {
            cadena = titulo + " (año " + anho + "). Libro de " + autor + ".";
            return cadena;  
        }
    }
}
