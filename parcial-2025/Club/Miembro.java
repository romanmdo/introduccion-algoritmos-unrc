package Club;

/**
 * Representa un miembro de un club social y/o deportivo 
 * Los detalles del miembro son su nombre, apellido, id, y anho de nacimiento
 *
 */
public class Miembro {
    
    // apellido del miembro
    private String apellido;

    // nombre del miembro
    private String nombre;

    // id del miembro
    private int id;

    // anho de nacimiento
    private int anhoNacimiento;
    
    // edad del miembro
    private int edad;
    
    // Miembro activo o inactivo
    private boolean activo;

    /**
     * Crea un nuevo miembro con todos sus datos.
     *
     * @param nombre       el nombre del miembro (no puede ser null ni vacío)
     * @param apellido     el apellido del miembro (no puede ser null ni vacío)
     * @param id           el ID del miembro (debe ser positivo)
     * @param anhoNacimiento el anho de nacimiento del miembro (debe ser mayor o igual a 1900)
     * @throws IllegalArgumentException si alguno de los parámetros no cumple con las validaciones
     */
    public Miembro(String nombre, String apellido, int id, int anhoNacimiento, int edad, boolean activo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del miembro no puede ser null ni vacío");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del miembro no puede ser null ni vacío");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("El id del miembro no puede ser negativo");
        }
        if (anhoNacimiento <= 1900) {
            throw new IllegalArgumentException("El Año de nacimiento del miembro debe ser mayor a 1900");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad del miembro debe ser mayor a 0");
        }
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.edad = edad;
        this.anhoNacimiento = anhoNacimiento;
        this.activo = activo;
    }

    /**
     * Obtiene el apellido del miembro
     *
     * @return el apellido del miembro
     */
    public String obtenerApellido() {
        return apellido;
    }

    /**
     * Obtiene el nombre del miembro
     *
     * @return el nombre del miembro
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Obtiene el ID del miembro
     *
     * @return el ID del miembro
     */
    public int obtenerId() {
        return id;
    }

    /**
     * Obtiene el anho de nacimiento del miembro
     *
     * @return el anho de nacimiento del miembro
     */
    public int obtenerAnhoNacimiento() {
        return anhoNacimiento;
    }
    
    /**
     * Obtiene la edad  del miembro
     *
     * @return la edad del miembro
     */
    public int obtenerEdad() {
        return edad;
    }
    
    /**
     * Obtiene la condicion del miembro
     * 
     * @return la condicion del miembro
     */
    public boolean obtenerCondicion() {
        return activo;
    }


    /**
     * Retorna los detalles del miembro, como cadena de caracteres.
     *
     * @return detalles del miembro en una cadena de caracteres,
     * usando el formato "<id>: <apellido>, <nombre>. Nacido en <anhoNacimiento>. Condicion <activo>".
     */
    public String toString() {
        String condicion = "";
        
        if(activo == true)
        {
            condicion = "Activo";
            return id + ": " + apellido + ", " + nombre + ". Nacido en " + anhoNacimiento + ". Condicion: " + condicion;
        } else {
            condicion = "Inactivo";
            return id + ": " + apellido + ", " + nombre + ". Nacido en " + anhoNacimiento + ". Condicion: " + condicion;
        }
    }
}
