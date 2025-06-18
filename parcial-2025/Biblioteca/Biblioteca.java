package Biblioteca;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa una biblioteca (repositorio de material bibliográfico) organizado
 * en estantes por años (siglos).
 */
public class Biblioteca
{
    // nombre de la biblioteca
    private String nombre;
    
    // libros entre 1900 y 1999 (inclusive).
    private ArrayList<Libro> sigloVeinte;
    
    // libros de 2000 en adelante, (incluidos los libros de 2000).
    private ArrayList<Libro> sigloVeintiuno;

    /**
     * Constructor de la clase Biblioteca. Crea una nueva biblioteca con su nombre, y listas
     * vacías de libros para los respectivos estantes
     */
    public Biblioteca(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede ser null ni vacío");
        }
        this.nombre = nombre;
        this.sigloVeinte = new ArrayList<Libro>();
        this.sigloVeintiuno = new ArrayList<Libro>();
    }

    /**
     * Agrega un nuevo libro a la biblioteca.
     * @param libro es el libro a agregar.
     * Precondición: el libro no debe ser null, ni deben existir libros con el mismo título
     *              en la biblioteca. El libro debe tener año de edición mayor o igual a 1900.
     * Postcondición: se agrega el libro a la biblioteca, a la lista de libros correspondiente, de 
     *              acuerdo a si el libro es novela o no. 
     */
    public void agregarLibro(Libro libro) {
        // PRE-CONDICIONES
        assert libro != null; // Libro distinto de null
        assert libro.obtenerAnho() >= 1900; // Edicion mayor a 1900
        assert !comprobarTitulo(libro.obtenerTitulo()); // Comprobar titulo
        
        if(libro.obtenerAnho() >= 1900 && libro.obtenerAnho() <= 1999)
        {
            sigloVeinte.add(libro);
            assert !sigloVeinte.isEmpty();
        } else
        {
            sigloVeintiuno.add(libro);
            assert !sigloVeintiuno.isEmpty();
        }
    }
    
    public boolean comprobarTitulo(String titulo)
    {
        for(Libro l: sigloVeinte){
            if(l.obtenerTitulo().equals(titulo)) return true;
        }
        
        for(Libro l: sigloVeintiuno){
            if(l.obtenerTitulo().equals(titulo)) return true;
        }
        
        return false;
    }
 
    /**
     * Retorna el conjunto de títulos de libros de un autor determinado 
     * @param autor es el autor para el cual se deben encontrar los libros en la biblioteca.
     * @return el conjunto de todos los títulos de libros en la biblioteca, cuyo autor es el dado.
     * Precondición: autor no puede ser null
     */
    public HashSet<String> obtenerTitulosLibrosAutor(String autor) {
        assert autor != null;
        
        HashSet<String> titulos = new HashSet<>();
    
        for (Libro libro : sigloVeinte) {
            if (autor.equalsIgnoreCase(libro.obtenerAutor())) {
                titulos.add(libro.obtenerTitulo());
            }
        }
    
        for (Libro libro : sigloVeintiuno) {
            if (autor.equalsIgnoreCase(libro.obtenerAutor())) {
                titulos.add(libro.obtenerTitulo());
            }
        }

        return titulos;
    }
    
    
    /**
     * Chequea si el objeto es internamente consistente. Lo es si:
     * - Las listas de libros no contienen libros con título repetido
     * - las listas de libros no contienen libros en común (libros con el mismo título en las dos listas)
     * - cada libro de cada una de las listas cumple con la restricción requerida del año de edición (sigloVeinte contiene libros del siglo veinte,
     * sigloVeintiuno contiene libros del siglo veintiuno).
     */
    public boolean repOK() {
        if(nombre == null || nombre == ""){ return false; }
        if(sigloVeinte == null){ return false; }
        if(sigloVeintiuno == null){ return false; }
        return true;
    }
}
