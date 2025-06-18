CursoUniversidad: Representación de un administrador de información de materias y
estudiantes de una Universidad, en base a dos clases principales:
- Estudiante: variante de la clase 'Student' de los proyectos de
BlueJ. Representa un estudiante, con su id, nombre, apellido y
cantidad de materias aprobadas.
- Curso: clase que representa una materia que está siendo cursada en una carrera
universitaria, con todos los estudiantes que cursan la misma, separados por comisión. 
Los estudiantes de la materia se almacenan por comisión, en listas.

Tareas a implementar en clase Estudiante:
- Implementar el constructor de la clase, incluyendo el chequeo de precondición 
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public String toString()
    (se describe funcionalidad esperada en el comentario del método)
    
Tareas a implementar en clase Curso:
- Implementar funcionalidad de: 
    public void inscribirEstudiante(Estudiante estudiante, int comision)
    incluyendo, de ser necesario, chequeo de precondición.
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public HashSet<String> obtenerApellidosAspirantes()
    incluyendo, de ser necesario, chequeo de precondición.
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public boolean repOK()
    (se describe funcionalidad esperada en el comentario del método)

