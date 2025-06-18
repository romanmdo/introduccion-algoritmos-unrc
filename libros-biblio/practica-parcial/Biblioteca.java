import java.util.ArrayList;

/**
 * Representa una biblioteca personal (colección de libros).
 * Se asume que la persona organiza su biblioteca en estanterías.
 */
public class Biblioteca {

    private String nombreEstanteria;
    private ArrayList<Libro> libros;

    public Biblioteca(String nombreEstanteria) 
    {
        this.nombreEstanteria = nombreEstanteria;
        this.libros = new ArrayList<>();
    }
    
    public void agregarLibro(Libro libro) 
    {
        libros.add(libro);
    }
    
    public int cantidadAutor(String autor)
    {  
        int cant = 0;
        for(Libro l: libros)
        {
            if(l.getAutor().equals(autor))
            {
                cant += 1;
            }
        }
        return cant;
    }
    
    public void cambiarTitulo(int id, String nuevoTitulo)
    {
        int i = 0;
        while(i < libros.size())
        {
            if(libros.get(i).getId() == id)
            {
                libros.get(i).cambiarTitulo(nuevoTitulo);
            }
            i += 1;
        }
    }
    
    public void eliminarAutor(String autor)
    {
        int i = 0;
        while(i < libros.size())
        {
            if(libros.get(i).getAutor().equals(autor))
            {
                libros.remove(i);
            }
            i += 1;
        }
    }
}
