Club: Representación de un administrador de información de clubes y
miembros de los mismos, en base a dos clases principales:
- Miembro: Representa un miembro de club, con su id, nombre, apellido y
año de nacimiento.
- Club: clase que representa un club social y/o deportivos, con todos los 
miembros del mismo, separados entre miembros regulares y senior. 

Tareas a implementar en clase Miembro:
- Implementar el constructor de la clase, incluyendo el chequeo de precondición 
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public String toString()
    (se describe funcionalidad esperada en el comentario del método)
    
Tareas a implementar en clase Club:
- Implementar funcionalidad de: 
    public void agregarMiembro(Miembro miembro)
    incluyendo, de ser necesario, chequeo de precondición.
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public HashSet<Integer> obtenerIdsMiembros(int anhoNacimiento)
    incluyendo, de ser necesario, chequeo de precondición.
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public boolean repOK()
    (se describe funcionalidad esperada en el comentario del método)

