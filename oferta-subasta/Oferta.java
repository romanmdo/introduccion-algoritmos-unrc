 

/**
 * Almacena los detalles de una oferta, 
 * en particular nombre del oferente y monto ofertado.
 * 
 * @author N. Aguirre
 * @version 0.1
 */
public class Oferta
{
    /**
     * ofertaMaxima (ninguna oferta puede superar este valor)
     */
    public static int ofertaMaxima = 10000;
    
    /**
     * el oferente
     */ 
    private String nombre;
    
    /**
     * el monto de la oferta
     */
    private int monto;
    
    /**
     * Constructor de objetos de la clase Oferta.
     * El oferente debe ser no nulo y no vacío. El monto
     * mayor a cero y menor o igual a oferta maxima.
     * @param oferente es el oferente de la oferta
     * @param monto es el monto de la oferta
     */
    public Oferta(String oferente, int monto)
    {
        assert oferente != null && oferente.length() > 0;
        assert monto > 0 && monto <= ofertaMaxima; 
        
        this.nombre = oferente;
        this.monto = monto;
    }
    
    
    /**
     * Retorna el oferente de la oferta.
     * @return el ofente de la oferta.
     */
    public String obtenerOferente()
    {
        return nombre;
    }
    
    /**
     * Retorna el monto de la oferta.
     * @return el monto de la oferta.
     */
    public int obtenerMonto()
    {
        return monto;
    }
        
    /**
     * Retorna los detalles de la oferta, oferente y monto, como
     * cadena de caracteres.
     * @return detalles de la oferta en una cadena de caracteres,
     * usando el formato "<oferente> (oferta $<monto>)".
     */
    public String toString()
    {
        String detalles = this.nombre + "(oferta $" + this.monto + ")";
        return detalles;
    }
    
    /**
     * Invariante de clase para Oferta.
     * Chequea que el oferente no sea null ni vacío, y que el monto sea
     * positivo
     */
    public boolean repOK() {
        return false;
    }
}
