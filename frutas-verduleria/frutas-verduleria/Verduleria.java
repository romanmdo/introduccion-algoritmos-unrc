import java.util.ArrayList;
import java.util.HashSet;

public class Verduleria
{
    private String name;
    private ArrayList<Unidades> frutas;
    private ArrayList<Unidades> verduras;
    
    /**
     * Constructor de la clase 'Verduleria'.
     * @param nombre de la verduleria.
     * Precondicion: nombre no puede ser vacio ni null.
     */
    
    public Verduleria(String name) {
        if(name == null || name.equals(name.trim().isEmpty())){
            throw new IllegalArgumentException("El nombre no puede ser null ni vacio");
        }
        
        this.name = name;
        this.frutas = new ArrayList<>();
        this.verduras = new ArrayList<>();
    }
    
    /**
     * @return cajon (lista) de frutas.
     */
    
    public ArrayList<Unidades> cajonFrutas()
    {
        return frutas;
    }
    
    /**
     * @return cajon (lista) de verduras.
     */
    
    public ArrayList<Unidades> cajonVerduras()
    {
        return verduras;
    }
    
    /**
     * Añade la unidad a su correspondiente lista.
     * si es verdura a la lista de verduras.
     * si es fruta a la lista de frutas.
     * @param unidad a guardar en su determinado cajon.
     * Precondicion: unidad no puede ser null.
     * Precondicion: No puede existir la fruta/verdura en su determinada lista.
     */
    
    public void cajones(Unidades unidad)
    {
        if(unidad == null){
            throw new IllegalArgumentException("La unidad no puede ser null");
        }
        if(buscarRepetidos(unidad.getName())){
            throw new IllegalArgumentException("La unidad no puede estar repetida");
        }
        
        if(unidad.getisFruit() == true)
        {
            frutas.add(unidad);
        } else {
            verduras.add(unidad);
        }
    }
    
    /**
     * Metodo auxiliar para ver si
     * una fruta/verdura esta en su lista.
     * @param nombre de la unidad a buscar
     */
    
    public boolean buscarRepetidos(String unidad)
    {
        for(Unidades u: frutas)
        {
            if(u.getName().equalsIgnoreCase(unidad))
            {
                return true;
            }
        }
        
        for(Unidades u: verduras)
        {
            if(u.getName().equalsIgnoreCase(unidad))
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Metodo para borrar una unidad deseada
     * @param unidad a buscar
     */
    
    public void sacarUnidad(Unidades unidad)
    {
        for(int i = 0; i < frutas.size(); i++)
        {
            if(frutas.get(i).equals(unidad))
            {
                frutas.remove(unidad);
            }
        }
        
        for(int i = 0; i < verduras.size(); i++)
        {
            if(verduras.get(i).equals(unidad))
            {
                verduras.remove(unidad);
            }
        }
    }
    
    /**
     * @return HashSet (conjunto) con frutas/verduras que tiene
     * una determinada marca de productos.
     */
    
    public HashSet<String> categoriasDisponibles(String marca)
    {
        HashSet<String> marcasFrutas = new HashSet<>();
        
        for(Unidades u: frutas)
        {
            if(u.getMarca().equalsIgnoreCase(marca)) 
            {
                marcasFrutas.add(u.getName());
            }
        }
        
        for(Unidades u: verduras)
        {
            if(u.getMarca().equalsIgnoreCase(marca)) 
            {
                marcasFrutas.add(u.getName());
            }
        }
        
        return marcasFrutas;
    }
    
    /**
     * Devuelve la cantidad total de unidades en la verdulería.
     * @return suma de las cantidades de todas las frutas y verduras.
     * Precondición: la lista de frutas y verduras no puede ser null.
     */
    public int totalDeUnidades()
    {   
        if(frutas == null || verduras == null){
            throw new IllegalArgumentException("La lista no puede ser null");
        }
        
        int cantidad = 0;
        
        for(Unidades u: frutas)
        {
            cantidad += u.getCant();
        }
        
        for(Unidades u: verduras)
        {
            cantidad += u.getCant();
        }
        
        return cantidad;
    }
    
    /**
     * Devuelve un conjunto con las letras iniciales de los nombres de productos en stock.
     * @return conjunto de iniciales (mayúsculas) sin repetir.
     */
    public HashSet<String> inicialesDeProductos()
    {
        HashSet<String> letrasIniciales = new HashSet <>();
        
        for(Unidades u: frutas)
        {
            char primeraLetra = u.getName().charAt(0);
            String letraMayus = Character.toString(primeraLetra);
            letrasIniciales.add(letraMayus);
        }
        
        for(Unidades u: verduras)
        {
            char primeraLetra = u.getName().charAt(0);
            String letraMayus = Character.toString(primeraLetra);
            letrasIniciales.add(letraMayus);
        }
        
        return letrasIniciales;
    }
    
    /**
     * Devuelve la unidad con mayor precio unitario en toda la verdulería.
     * @return la unidad más cara.
     * Precondición: debe haber al menos un producto cargado.
     */
    public Unidades productoMasCaro()
    {
        Unidades masCaro = frutas.get(0);
        
        for(Unidades u: frutas)
        {
            if(u.getPrice() > masCaro.getPrice())
            {
                masCaro = u;                
            }
        }
        
        for(Unidades u: verduras)
        {
            if(u.getPrice() > masCaro.getPrice())
            {
                masCaro = u;                
            }
        }
        
        return masCaro;
    }
}