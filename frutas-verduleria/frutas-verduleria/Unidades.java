public class Unidades
{
    private String name;
    private String marca;
    private int cant;
    private float price;
    private boolean isFruit;

    public Unidades(String name, String marca, int cant, float price, boolean isFruit)
    {
        if(name == null || name.equals(name.trim().isEmpty())){
            throw new IllegalArgumentException("El nombre no puede ser null ni vacio");
        }
        if(marca == null || marca.equals(marca.trim().isEmpty())){
            throw new IllegalArgumentException("El nombre no puede ser null ni vacio");
        }
        if(cant <= 0){
            throw new IllegalArgumentException("La cantidad no puede ser menor o igual a 0");
        }
        if(price <= 0){
            throw new IllegalArgumentException("El precio no puede ser menor o igual a 0");
        }

        this.name = name;
        this.marca = marca;
        this.cant = cant;
        this.price = price;
        this.isFruit = isFruit;
    }

    public String getName()
    {
        return this.name;
    }
    
    public String getMarca()
    {
        return this.marca;
    }
        
    public int getCant()
    {
        return this.cant;
    }
    
    public float getPrice()
    {
        return this.price;
    }
    
    public boolean getisFruit()
    {
        return this.isFruit;
    }
    
    public String toString()
    {
        String cadena = "";
        
        if(this.isFruit == true)
        {
            cadena = "fruta";
            return name + " es una " + cadena + ". En nuestra verduleria quedan: " + cant + " unidades. Cuesta: $" + price + " c/u. " + marca;
        } else {
            cadena = "verdura";
            return name + " es una " + cadena + ". En nuestra verduleria quedan: " + cant + " unidades. Cuesta: $" + price + " c/u. " + marca;
        }
    }
}
