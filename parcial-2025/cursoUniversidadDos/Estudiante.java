package cursoUniversidadDos;

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

    // es regular?
    private boolean esRegular;

    /**
     * Crea un nuevo estudiante con todos sus datos.
     *
     * @param nombre       el nombre del estudiante (no puede ser null ni vacío)
     * @param apellido     el apellido del estudiante (no puede ser null ni vacío)
     * @param id           el ID del estudiante (debe ser positivo)
     * @param esRegular indica si el estudiante es regular
     * @throws IllegalArgumentException si alguno de los parámetros no cumple con las validaciones
     */
    public Estudiante(String nombre, String apellido, int id, boolean esRegular) {
        //TODO Implementar este método
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
     * Obtiene el nombre del estudiante
     *
     * @return el nombre del estudiante
     */
    public String obtenerNombre() {
        return nombre;
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
     * Verifica si el estudiante es regular
     *
     * @return true si es regular, false en caso contrario
     */
    public boolean esRegular() {
        return esRegular;
    }

    /**
     * Retorna los detalles del estudiante, como cadena de caracteres.
     *
     * @return detalles del estudiante en una cadena de caracteres,
     * usando el formato "<id>: <apellido>, <nombre>", si el estudiante es regular, o
     *  "<id>: <apellido>, <nombre> (aspirante)", si el estudiante no es regular.
     */
    public String toString() {
        //TODO Implementar este método
        return null;
    }

}
