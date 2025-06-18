package Club;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa un club social y/o deportivo, con informacion de sus miembros. 
 * Los miembros están organizados en lista de miembros regulares y miembros senior. Los miembros senior son los 
 * nacidos antes (estrictamente antes) de 1970. 
 */
public class Club
{
    // nombre del club 
    private String nombre;

    // miembros senior
    private ArrayList<Miembro> seniors;

    // miembros regulares
    private ArrayList<Miembro> regulares;

    /**
     * Constructor de la clase Club. Crea un nuevo club con su nombre y ambas listas de miembros vacias. 
     */
    public Club(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del club no puede ser null ni vacío");
        }
        this.nombre = nombre.trim();
        this.seniors = new ArrayList<Miembro>();
        this.regulares = new ArrayList<Miembro>();
    }

    /**
     * Agrega un miembro al club. La lista a la que se agrega el miembro depende del
     * año de nacimiento del mismo: si es menor a 1970, es senior, sino es regular.
     * @param miembro es el miembro a agregar
     * Precondición: el miembro no debe ser null.
     * Precondición: no debe existir en ninguna de las listas un miembro con el mismo id.
     */
    public void agregarMiembro(Miembro miembro) {
        assert(miembro != null);
        assert !buscarMiembro(miembro.obtenerId());
        
        if(miembro.obtenerAnhoNacimiento() < 1970)
        {
            seniors.add(miembro);
        } else
        {
            regulares.add(miembro);
        }
    }
    
    /**
     * Busca un miembro dentro de las dos listas
     * 
     * @param id del miembro a buscar
     * @return si el miembro esta en la lista es true
     * sino es false.
     */
    public boolean buscarMiembro(int id)
    {   
        for(Miembro m: seniors)
        {
            if(m.obtenerId() == id)
            {
                return true;
            }
        }
        
        for(Miembro m: regulares)
        {
            if(m.obtenerId() == id)
            {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Retorna el conjunto de ids de miembros nacidos en un año determinado.
     * @param anhoNacimiento es el año de nacimiento de los miembros a retornar.
     * @return el conjunto de ids de miembros nacidos en el año indicado.
     */
    public HashSet<Integer> obtenerIdsMiembros(int anhoNacimiento) {
        HashSet<Integer> ids = new HashSet<>();
        
        for(Miembro m: seniors)
        {
            if(m.obtenerAnhoNacimiento() == anhoNacimiento)
            {
                ids.add(m.obtenerId());
            }
        }
        
        for(Miembro m: regulares)
        {
            if(m.obtenerAnhoNacimiento() == anhoNacimiento)
            {
                ids.add(m.obtenerId());
            }
        }
        
        return ids;
    }
    
    /**
     * 1. Devuelve un arreglo con todos los miembros activos
     */ 
    public Miembro[] obtenerMiembrosActivos() {
        ArrayList<Miembro> activos = new ArrayList<>();
        for (Miembro m : seniors) {
            if (m.obtenerCondicion()) {
                activos.add(m);
            }
        }
        return activos.toArray(new Miembro[0]);
    }

    /**
     * 2. Devuelve una lista con los nombres de los mayores de edad
    */
    public ArrayList<String> nombresDeMayoresDeEdad() {
        ArrayList<String> edades = new ArrayList<>(); 
   
        for(Miembro m: seniors)
        {
            if(m.obtenerEdad() >= 18)
            {
                edades.add(m.obtenerNombre());
            }
        }
        
        for(Miembro m: regulares)
        {
            if(m.obtenerEdad() >= 18)
            {
                edades.add(m.obtenerNombre());
            }
        }
        
        return edades;
    }

    /**
     * 3. Devuelve true si existe un miembro con el nombre dado (ignorando mayúsculas/minúsculas)
     */ 
    public boolean existeMiembro(String nombre) {
        for(Miembro m: seniors)
        {
            if(m.obtenerNombre().equalsIgnoreCase(nombre))
            {
                return true;
            }
        }
        
        for(Miembro m: regulares)
        {
            if(m.obtenerNombre().equalsIgnoreCase(nombre))
            {
                return true;
            }
        }
        
        return false;
    }

    /**
     *  4. Devuelve el miembro de mayor edad
     */
    public Miembro miembroDeMayorEdad() {
        return null;
    }

    /**
     * 5. Devuelve un conjunto con las edades únicas de los miembros
     */
    public HashSet<Integer> edadesUnicas() {
        // TODO: implementar
        return null;
    }

    // 6. Devuelve un conjunto con los nombres únicos de los miembros
    public HashSet<String> nombresUnicos() {
        // TODO: implementar
        return null;
    }

     
    /**
     * 8. Desactiva a todos los miembros menores de edad
     */ 
    public void desactivarMenores() {
        for(Miembro m: seniors)
        {
            if(m.obtenerEdad() < 18)
            {
                boolean condicion = m.obtenerCondicion();
                condicion = false;
            }
        }
    }

    // 9. Elimina del club a los miembros inactivos
    public void eliminarInactivos() {
        // TODO: implementar
    }

    // 10. Calcula el promedio de edad de los miembros
    public double promedioEdad() {
        // TODO: implementar
        return 0;
    }

    // 11. Devuelve cuántos miembros tienen la edad exacta indicada
    public int contarPorEdad(int edad) {
        // TODO: implementar
        return 0;
    }
    
    /**
     * Invariante de representacion de la clase. 
     * La clase es internamente consistente si:
     * - el nombre del club es no nulo y no vacio.
     * - las listas de miembros no tienen miembros en comun
     * - las listas de miembros no tienen miembros con ids repetidos
     * - las listas de miembros no tienen null
     * - las listas de miembros respetan la restricción de nacimiento: la lista de seniors sólo contiene miembros nacidos antes de 1970, y la lista de
     * regulares sólo miembros nacidos en 1970 o posterior.
     */
    public boolean repOK() {
        if (nombre == null || nombre.trim().isEmpty()) { return false; }
        return true;
    }
}
