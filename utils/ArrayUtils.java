import java.util.ArrayList;
import java.util.Collections;
 
/**
 * Clase ArrayUtils: contiene implementaciones de rutinas fundamentales
 * sobre arreglos.
 * 
 * @author N. Aguirre
 * @version 0.1
 */
public class ArrayUtils
{
    /**
     * Comprueba si un elemento (entero) pertenece a un arreglo.
     */
    public boolean pertenece(int elem, int[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("Arreglo nulo");
           
        for(int i = 0; i < arreglo.length; i++)
        {  
            int j = arreglo[i]; 
            if(j == elem)
            {   
                System.out.println(j + "=" + elem);
                return true;
            }
            else
            {
                System.out.println(arreglo[i]);
            }
        }
        return false;
    }
    
    /**
     * Calcula la suma de los elementos de un arreglo de enteros
     */
    public int suma(int[] arreglo) {
        int resultado = 0;
        
        for(int i = 0; i < arreglo.length; i++)
        {  
           resultado = resultado + arreglo[i]; 
        }
        return resultado; 
    }
    
    /**
     * Calcula el valor mínimo de un arreglo de reales
     */
    public float minimo(float[] arreglo) {
        float j = 0;
        
        for(int i = 0; i < arreglo.length; i++)
        {  
            if(j > arreglo[i])
            {
                j = arreglo[i];
                System.out.println(j);
            }  
        }
        return j;
    }
    
    /**
     * Calcula el valor máximo de un arreglo de reales
     */
    public float maximo(float[] arreglo) {
        float j = 0;
        
        for(int i = 0; i < arreglo.length; i++)
        {  
            if(arreglo[i] > j)
            {
                j = arreglo[i];
            }
        }
        return j;
    }
    
    
    /**
     * Calcula el valor promedio de un arreglo de reales
     */
    public float promedio(float[] arreglo) {
        float promedio = 0;
        float cant = 0;   
        
        for(int i = 0; i < arreglo.length; i++)
        {  
            cant += 1;
            promedio += arreglo[i];
            
        }
        return promedio / cant;
    }
    
    /**
     * Retorna un arreglo con los primeros n números de Fibonacci
     */
    public int[] fibSequence(int n) {
        if (n <= 0) {
            return new int[0]; // arreglo vacío
        }
    
        int[] fib = new int[n];
    
        // Casos base
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
        }
    
        // Llenamos el resto del arreglo
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    
        return fib;
    }

    
    /**
     * Calcula la mediana de un arreglo de reales
     */
    public float mediana(float[] arreglo) {
        ArrayList<Float> ordenados = new ArrayList<>();

        // Copiar los elementos del arreglo a la lista
        for (float num : arreglo) {
            ordenados.add(num);
        }

        // Ordenar la lista
        Collections.sort(ordenados);

        int n = ordenados.size();

        if (n % 2 == 0) {
            // Si es par: promedio de los dos valores centrales
            float medio1 = ordenados.get(n / 2 - 1);
            float medio2 = ordenados.get(n / 2);
            return (medio1 + medio2) / 2.0f;
        } else {
            // Si es impar: valor central
            return ordenados.get(n / 2);
        }
    }
        
    /**
     * Comprueba si dos arreglos de enteros son iguales
     */
    public boolean iguales(int[] arr1, int[] arr2) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>(); 
        
        for(int i: arr1)
        {
            array1.add(i);
        }
        
        for(int j: arr2)
        {
            array2.add(j);
        }
        
        Collections.sort(array1);
        Collections.sort(array2);
        
        int n = array1.size();
        int m = array2.size();
        
        if(n == m)
        {
            for(int i = 0; i < array1.size(); i++)
            {
                int valor1 = array1.get(i);
                int valor2 = array2.get(i);
                
                if(valor1 != valor2){
                    return false;
                }
            }
            return true;
        } else
        {
          return false;
        }
    }
    
    /**
     * Comprueba si un arreglo tiene valores repetidos
     */
    public boolean tieneRepetidos(int[] arreglo) {
        ArrayList<Integer> array = new ArrayList<>();
        
        for(int i: arreglo)
        {
           array.add(i);
        }
        
        Collections.sort(array);
        int n = 0;
        
        for (int j = 0; j < array.size() - 1; j++) {
            int actual = array.get(j);
            int siguiente = array.get(j + 1);
        
            if(actual == siguiente)
            {
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
    
    /**
     * Comprueba si un arreglo tiene dos valores cuya suma dé cero.
     */
    public boolean tieneOpuestos(float[] arreglo) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return false;
    }
    
}
