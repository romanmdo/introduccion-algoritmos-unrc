package BibliotecaMusical;

/**
 * Representa un album de música, con su información básica.
 *
 */
public class Album {

    // título del album 
    private String titulo;

    // nombre del artista
    private String artista;

    // año de edición
    private int anho;

    // es en vivo?
    private boolean enVivo;

    /**
     * Crea un nuevo album con todos sus datos.
     * @param titulo es el título del album
     * @param artista es el nombre del artista
     * @param anho es el año de edición del album (el año debe ser mayor o igual a 1900)
     * @param enVivo indica si el album es en vivo
     * 
     */
    public Album(String titulo, String artista, int anho, boolean enVivo) {
        this.titulo = titulo;
        this.artista = artista;
        this.anho = anho;
        this.enVivo = enVivo;
    }

    /**
     * Obtiene el título del album.
     */
    public String obtenerTitulo() {
        return titulo;
    }

    /**
     * Obtiene el artista del album.
     * @return el artista del album
     */
    public String obtenerArtista() {
        return artista;
    }

    /**
     * Es este album en vivo?
     * @return true si el album es en vivo, false en caso contrario
     */
    public boolean esEnVivo() {
        return enVivo;
    }

    /**
     * Obtiene año de edición del album.
     * @return año de edición del album
     */
    public int obtenerAnho() {
        return anho;
    }

    /**
     * Retorna los detalles del album, como cadena de caracteres.
     *
     * @return detalles del album en una cadena de caracteres,
     * usando el formato "<titulo> (año <anho>). Artista: <artista>", si el album no es en vivo, o
     *  "<titulo> (año <anho>). Artista: <artista>. Album en vivo", si el album es en vivo.
     */
    public String toString() {
        String cadena = "";
        
        if(enVivo == true)
        {
            cadena = titulo + " (año " + anho + "). Artista: " + artista + ". Album en vivo";
            return cadena;
        } else {
            cadena = titulo + " (año " + anho + "). Artista: " + artista;
            return cadena;
        }
    }

}
