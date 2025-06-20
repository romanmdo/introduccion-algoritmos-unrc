package CursoUniversidad;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa un curso (materia) de una carrera universitaria.
 * Los estudiantes están organizdos en comisiones, cada comisión en
 * una lista diferente.
 */
public class Curso
{
    // nombre de la materia/curso
    private String nombre;

    // indica si es materia obligatoria del plan de estudios
    private boolean esObligatoria;

    // estudiantes de la comisión 1
    private ArrayList<Estudiante> comision1;

    // estudiantes de la comisión 2
    private ArrayList<Estudiante> comision2;

    /**
     * Constructor de la clase Curso. Crea un nuevo curso con su nombre y si es obligatoria,
     * con ambas comisiones de estudiantes vacías.
     */
    public Curso(String nombre, boolean esObligatoria) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede ser null ni vacío");
        }
        this.nombre = nombre.trim();
        this.esObligatoria = esObligatoria;
        this.comision1 = new ArrayList<Estudiante>();
        this.comision2 = new ArrayList<Estudiante>();
    }

    /**
     * Agrega un estudiante al curso, en una comisión determinada
     * @param estudiante es el estudiante a agregar
     * @param comision es la comisión en la cual agregar el estudiante.
     * Precondición: el estudiante no debe ser null.
     * Precondición: no debe existir en ninguna de las comisiones un estudiante con el mismo id.
     * Precondición: la comisión debe ser 1 o 2.
     */
    public void inscribirEstudiante(Estudiante estudiante, int comision) {
        assert estudiante != null;
        assert !estudianteExistente(estudiante.obtenerId());
        
        if(comision == 1)
        {
            comision1.add(estudiante);
        } else {
            comision2.add(estudiante);
        }
    }
    
    public boolean estudianteExistente(int id)
    {
        for(Estudiante e: comision1)
        {
            if(e.obtenerId() == id)
            {
                return true;
            }
        }
        
        for(Estudiante e: comision2)
        {
            if(e.obtenerId() == id)
            {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Retorna el conjunto de ids de ingresantes de una comisión
     * @param comision es la comisión para la cual calcular ids de ingresantes.
     * @return el conjunto de ids de estudiantes en la comisión indicada.
     * Precondición: comisión debe ser 1 o 2.
     */
    public HashSet<Integer> obtenerIdsIngresantes(int comision) {
        HashSet<Integer> ids = new HashSet<>();
        
        if(comision == 1)
        {
            for(Estudiante e: comision1)
            {
                ids.add(e.obtenerId());
            }
            
            return ids;
        }
        
        if(comision == 2)
        {
            for(Estudiante e: comision1)
            {
                ids.add(e.obtenerId());
            }
            
            return ids;
        }
        
        return ids;
    }

    /**
     * Invariante de representacion de la clase. 
     * La clase es internamente consistente si:
     * - el nombre de la materia es no nulo y no vacio.
     * - las listas de las comisiones no tienen alumnos en comun
     * - las listas de las comisiones no tienen alumnos con ids repetidos
     * - las listas de las comisiones no contienen objetos nulos
     */
    public boolean repOK() {
        if (nombre == null || nombre.trim().isEmpty()) { return false; }
        
        
        return true;
    }
}
