package BibliotecaMusical;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa una fonoteca (repositorio de material musical) organizado
 * en albumes de estudio y en vivo. 
 */
public class Fonoteca
{
    // nombre de la fonoteca (repositorio de material musical)
    private String nombre;
    
    // albumes de estudio
    private ArrayList<Album> albumesDeEstudio;

    // albumes en vivo
    private ArrayList<Album> albumesEnVivo;

    /**
     * Constructor de la clase Fonoteca. Crea una nueva fonoteca con su nombre, y listas
     * vacías de albumes de estudio y en vivo.
     */
    public Fonoteca(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede ser null ni vacío");
        }
        this.nombre = nombre;
        this.albumesDeEstudio = new ArrayList<Album>();
        this.albumesEnVivo = new ArrayList<Album>();
    }

    /**
     * Agrega un nuevo album a la fonoteca.
     * @param album es el album a agregar.
     * Precondición: el album no debe ser null, ni deben existir albumes con el mismo título
     *              en la fonoteca.
     * Postcondición: se agrega el album a la fonoteca, a la lista de albumes correspondiente, de 
     *              acuerdo a si el album es en vivo o no. 
     */
    public void agregarAlbum(Album album) {
        assert album != null;
        assert !buscarAlbum(album.obtenerTitulo());
        
        if(album.esEnVivo() == true)
        {
            albumesEnVivo.add(album);
        } else {
            albumesDeEstudio.add(album);
        }
    }
    
    public boolean buscarAlbum(String album)
    {
        for(Album a: albumesDeEstudio)
        {
            if(a.obtenerTitulo().equalsIgnoreCase(album))
            {
                return true;
            }
        }
        
        for(Album a: albumesEnVivo)
        {
            if(a.obtenerTitulo().equalsIgnoreCase(album))
            {
                return true;
            }
        }
        
        return false;
    }
 
    /**
     * Retorna el conjunto de títulos de albumes de un año dado. 
     * @param anho es el año para el cual se deben encontrar los albumes en la fonoteca.
     * @return el conjunto de todos los títulos de albumes en la fonoteca, cuyo año de edición es el dado.
     * Precondición: anho debe ser mayor o igual a 1900.
     */
    public HashSet<String> obtenerTitulosAlbumesAnho(int anho) {
        assert anho >= 1900;
        
        HashSet<String> titulos = new HashSet<>();
        
        for(Album a: albumesDeEstudio)
        {
            if(a.obtenerAnho() == anho)
            {
                titulos.add(a.obtenerTitulo());
            }
        }
        
        for(Album a: albumesEnVivo)
        {
            if(a.obtenerAnho() == anho)
            {
                titulos.add(a.obtenerTitulo());
            }
        }
          
        return titulos;
    }

    /**
     * Invariante de representacion de la clase. Un objeto de tipo Fonoteca es internamente consistente si:
     * - El nombre de la fonoteca debe ser no nulo y no vacio
     * - Las listas de albumes no deben tener elementos repetidos (albumes distintos con el mismo nombre)
     * - La lista de albumes en vivo solo contiene albumes en vivo
     * - la lista de albumes de estudio solo contiene albumes de estudio (no albumes en vivo)
     */
    public boolean repOK() {
        if (nombre == null || nombre.trim().isEmpty()) { return false; }
        return true;
    }
    
    public boolean buscarAlbum(String album)
    {
        for(Album a: albumesDeEstudio)
        {
            if(a.obtenerTitulo().equalsIgnoreCase(album))
            {
                return true;
            }
        }
        
        for(Album a: albumesEnVivo)
        {
            if(a.obtenerTitulo().equalsIgnoreCase(album))
            {
                return true;
            }
        }
        
        return false;
    }
}
