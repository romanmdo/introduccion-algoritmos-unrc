import java.util.ArrayList; 

/**
 * Registros de temperaturas diarios de una estacion meteorológica
 */
public class MedicionesTemperaturas
{
    /**
     * Contiene las mediciones de temperaturas.
     */
    private ArrayList<Integer> registros;
    
    /**
     * Dia del registro
     */
    private int dia;
    
    /**
     * Mes del registro
     */
    private int mes;
    
    /**
     * Constructor de la clase. Inicializa dia y mes con los parámetros respectivos,
     * y la lista de registros se inicializa vacía (sin mediciones).
     * Precondición: 
     *  - dia debe ser un día válido (entre 1 y 31)
     *  - mes debe ser un mes válido (entre 1 y 12)
     */
    
    public MedicionesTemperaturas(int dia, int mes) {
        assert dia >= 1 && dia <= 31;
        assert mes >= 1 && mes <= 12;
        this.dia = dia;
        this.mes = mes;
        this.registros = new ArrayList<Integer>();
    }
    
    /**
     * Agrega una temperatura al registro de temperaturas
     */
    
    public void agregarRegistro(int nuevaTemperatura){
        assert nuevaTemperatura >= -272.15;
        registros.add(new Integer(nuevaTemperatura));
    }
    
    /**
     * Muestra todas las temperaturas registradas en 
     * la pantalla. 
     */
    
    public void imprimirTemperaturas() {
        System.out.println(dia + "/" + mes);
        int pos = 0;
        for (Integer temperatura: registros) {
            System.out.print(pos + ": ");
            System.out.println(temperatura + "C");
            pos = pos + 1;
        }
    }
    
    /**
     * Metodo para retornar promedio de temperaturas 
     * donde tempCont es la sumatoria de temperaturas
     * y cont la cantidad de temperaturas cargadas
     */
    
    public int promedioTemp() 
    {
        int cont = 0;
        int tempCont = 0;
        int promedioTemp = 0;
        
        for (Integer i: registros) {
            cont += 1;
            tempCont += i;
            promedioTemp = tempCont / cont;
        }
        
        return promedioTemp;
    }
    
    /**
     * Metodo para retornar
     * la maxima temperatura 
     * cargada en el arreglo
     */
    
    public int tempMaxRegistrada()
    {
        int j = 0;
        
        for (Integer i: registros) {
            j = i;
            
            if(j > i)
            {
                System.out.println("La maxima temperatura registrada es: " + j);
            }
        }
        
        return j;
    }
    
    /**
     * Metodo para retornar
     * la minima temperatura 
     * cargada en el arreglo
     */
    
    public int tempMinRegistrada()
    {
        int j = 0;
        
        for (Integer i: registros) {
            j = i;
            
            if(j < i)
            {
                System.out.println("La minima temperatura registrada es: " + j);
            }
        }
        
        return j;
    }
    
    /**
     * @return: amplitud termica entre la
     * maxima temperatura registrada y la 
     * minima temperatura registrada
     */
    public int amplitudTermica()
    {
        int minTemp = 0;
        int maxTemp = 0;
        int ampTermica = 0;
        
        for (Integer i: registros) {
            minTemp = i;
            maxTemp = i;
            
            if(minTemp < i)
            {
                System.out.println("La minima temperatura registrada es: " + minTemp);
            }
            else if(maxTemp > i)
            {
                System.out.println("La maxima temperatura registrada es: " + maxTemp);
            }
        }
        
        ampTermica = maxTemp - minTemp;
        return minTemp; 
    }
    
    /**
     * Metodo para retornar si la temperatura
     * cargada es extrema, baja o normal
     */
    
    public void cantTemperaturasExtremas()
    {
        for (Integer i: registros) {
            if(i > 35)
            {
                System.out.println("Temperatura extrema: " + i + "C");
            }
            else if(i < 15)
            {
                System.out.println("Temperatura baja: " + i + "C");
            }
            else
            {
                System.out.println("Temperatura normal: " + i + "C");
            }
        }
    }
    
    /**
     * Metodo para saber la cantidad consecutiva 
     * de "x" temperatura.
     * - registros.get(i)
     */
    
    public void cantidadConsecutiva() {
        if (registros.size() == 0) {
            System.out.println("No hay registros.");
            return;
        }
    
        int maxRepeticiones = 1;
        int repeticionesActuales = 1;
        int temperaturaMax = registros.get(0);
    
        for (int i = 1; i < registros.size(); i++) {
            if (registros.get(i).equals(registros.get(i - 1))) {
                repeticionesActuales++;
                if (repeticionesActuales > maxRepeticiones) {
                    maxRepeticiones = repeticionesActuales;
                    temperaturaMax = registros.get(i);
                }
            } else {
                repeticionesActuales = 1;
            }
        }
    
        System.out.println("Temperatura " + temperaturaMax + " se repitió " + maxRepeticiones + " veces consecutivas.");
    }
}
