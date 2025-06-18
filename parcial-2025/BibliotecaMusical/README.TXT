BibliotecaMusical: Representación de un administrador de información de albumes musicales,
 en base a dos clases principales:
- Album: Representa un album de música, con su título, artista, año de edición y si es en vivo o no.
- Fonoteca: clase que representa una fonoteca, con todos los albumes de la misma,
 clasificados entre albumes en vivo y de estudio.

Tareas a implementar en clase Album:
- Implementar el constructor de la clase, incluyendo el chequeo de precondición 
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public String toString()
    (se describe funcionalidad esperada en el comentario del método)
    
Tareas a implementar en clase Fonoteca:
- Implementar funcionalidad de: 
    public void agregarAlbum(Album album)
    incluyendo, de ser necesario, chequeo de precondición.
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public HashSet<String> obtenerTitulosAlbumesAnho(int anho)
    incluyendo, de ser necesario, chequeo de precondición.
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public boolean repOK()
    (se describe funcionalidad esperada en el comentario del método)
