package CursoUniversidad;

/**
 * Representa un estudiante de una materia en una carrera universitaria.
 * Los detalles del estudiante son su nombre, apellido, id,
 * e indicando si es ingresante o no.
 *
 */
public class Estudiante {
    
    // apellido del estudiante
    private String apellido;

    // nombre del estudiante
    private String nombre;

    // id del estudiante
    private int id;

    // es ingresante?
    private boolean esIngresante;

    /**
     * Crea un nuevo estudiante con todos sus datos.
     *
     * @param nombre       el nombre del estudiante (no puede ser null ni vacío)
     * @param apellido     el apellido del estudiante (no puede ser null ni vacío)
     * @param id           el ID del estudiante (debe ser positivo)
     * @param esIngresante indica si el estudiante es ingresante
     * @throws IllegalArgumentException si alguno de los parámetros no cumple con las validaciones
     */
    public Estudiante(String nombre, String apellido, int id, boolean esIngresante) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni vacío");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser null ni vacío");
        }

        if(id < 0){
            throw new IllegalArgumentException("El id no puede ser negativo");
        }
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.esIngresante = esIngresante;
    }

    /**
     * Obtiene el apellido del estudiante
     *
     * @return el apellido del estudiante
     */
    public String obtenerApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del estudiante
     *
     * @param apellido el apellido a establecer
     */
    public void cambiarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser null ni vacío");
        }
        this.apellido = apellido;
    }

    /**
     * Obtiene el nombre del estudiante
     *
     * @return el nombre del estudiante
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante
     *
     * @param nombre el nombre a establecer
     */
    public void cambiarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser null ni vacío");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del estudiante
     *
     * @return el ID del estudiante
     */
    public int obtenerId() {
        return id;
    }

    /**
     * Verifica si el estudiante es ingresante
     *
     * @return true si es ingresante, false en caso contrario
     */
    public boolean esIngresante() {
        return esIngresante;
    }

    /**
     * Retorna los detalles del estudiante, como cadena de caracteres.
     *
     * @return detalles del estudiante en una cadena de caracteres,
     * usando el formato "<id>: <apellido>, <nombre>", si el estudiante no es ingresante, o
     *  "<id>: <apellido>, <nombre> (ingresante)", si el estudiante es ingresante.
     */
    public String toString() {
        String cadena = "";
        
        if(this.esIngresante == true)
        {
            cadena = id + ": " + apellido + ", " + nombre + " (ingresante)";
            return cadena;
        } else {
            cadena = id + ": " + apellido + ", " + nombre;
            return cadena;
        }
    }

}
