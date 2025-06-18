Auction: Representación de una subasta en base a dos clases 
principales:
- Oferta: variante de la clase 'Bid' de los proyectos de
BlueJ. Representa una oferta en la subasta, con nombre de la persona
y monto ofertado.
- Subasta: variante de la clase 'Auction' de los proyectos
de BlueJ. Representa una subasta. Una subasta consta de una lista de
ofertas. En una subasta, hay un monto mínimo
que todas las ofertas deben respetar (ofertar al menos el monto 
mínimo para ser consideradas válidas).

Tareas a implementar en clase Oferta:
- Implementar chequeo de precondición de:
    public Oferta(String oferente, int monto)
    (se describe funcionalidad esperada en el comentario del método)
    public boolean repOK()
    (se describe funcionalidad esperada en el comentario del método)
    
Tareas a implementar en clase Subasta:
- Implementar funcionalidad y chequeo de precondición de:
    public Subasta(int montoMinimo) 
    (se describe funcionalidad esperada en el comentario del método)
- Implementar funcionalidad de:
    public int[] obtenerMontosOfertas()
    (se describe funcionalidad esperada en el comentario del método)
