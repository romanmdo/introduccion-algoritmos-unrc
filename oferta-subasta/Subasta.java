import java.util.ArrayList;

/**
 * Clase que mantiene los detalles de una subasta.
 * Una subasta consta de ofertas, y un monto mínimo.
 * Todas las ofertas deben ser por montos mayores o iguales
 * que el monto mínimo.
 * 
 * @author N. Aguirre
 * @version 0.1
 */
public class Subasta
{
    /**
     * Lista que almacena las ofertas
     */
    private ArrayList<Oferta> ofertas;
    
    /**
     * Monto mínimo
     */
    private int montoMinimo;
    
    /**
     * Crea una subasta vacía, con un monto mínimo inicial
     */
    public Subasta(int montoMinimo)
    {
        this.ofertas = new ArrayList<>();
        this.montoMinimo = montoMinimo;
    }
    
    /**
     * Agrega una oferta a la subasta. Debe cumplir con la restricción
     * de monto mínimo
     * @param oferta es la oferta a agregar a la subasta.
     */
    public void agregarOferta(Oferta oferta)
    {
        if (oferta == null) {
            throw new IllegalArgumentException("oferta nula");
        }
        if (oferta.obtenerMonto() < this.montoMinimo) {
            throw new IllegalArgumentException("oferta inválida");
        }
        ofertas.add(oferta);
    }
    
    
    /**
     * Retorna la cantidad de ofertas de la subasta
     * @return número de ofertas en la subasta
     */
    public int cantidadOfertas()
    {
        return ofertas.size();
    }
    
    /**
     * Retorna los montos de las ofertas
     * @return un arreglo conteniendo los montos de las ofertas
     */
    public int[] obtenerMontosOfertas()
    {
        //TODO: implementar funcionalidad de este método
        return null;
    }
    
    /**
     * Imprime las ofertas de la subasta
     */
    public void imprimirOfertas()
    {
        for (Oferta p: ofertas) {
            System.out.println(p.toString());
        }
    }
    
    /**
     * Comprueba si existen ofertas superiores a cierto monto
     * en la subasta
     * @param monto es el monto a utilizar en la búsqueda
     * @return true ssi existe una oferta en la subasta con valor mayor
     * al monto pasado como parámetro
     */
    public boolean ofertasMayores(int monto)
    {
        //método no implementado (no requerido)
        return false;
    }
    
    /**
     * Calcula la oferta ganadora hasta el momento.
     * La oferta ganadora es la oferta de mayor monto. 
     * Si hay varias ofertas con igual máximo monto, retorna la
     * primera. 
     * Debe haber al menos una oferta para poder calcular oferta
     * ganadora
     * @return oferta ganadora, máxima oferta en la subasta.
     */
    public Oferta ofertaGanadora()
    {
        //método no implementado (no requerido)
        return null;
    }
    
    /**
     * Invariante de clase para Subasta. Chequea que la colección de ofertas no
     * es nula, el monto mínimo es positivo, cada oferta satisface su repOK, 
     * y todos los montos de ofertas son mayores o iguales al monto mínimo.
     */
    public boolean repOK() {
        //método no implementado (no requerido)
        return false;
    }
}
