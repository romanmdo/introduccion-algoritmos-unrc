
/**
 * Clase NumberUtils: contiene implementaciones de rutinas fundamentales
 * sobre números.
 * 
 * @author N. Aguirre
 * @version 0.1
 */
import java.util.ArrayList;
import java.util.Collections;

public class NumberUtils
{
    
    /**
     * Comprueba si un número es primo.
     */
    public boolean esPrimo(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) 
        {
            if(n % i == 0)
            {
                return false;
            }
        }

        return true;
    }
    
    /**
     * Comprueba si un número es compuesto.
     */
    public boolean esCompuesto(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) 
        {
            if(n % i == 0)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Calcula el máximo común divisor de dos números.
     */
    public int maximoComunDivisor(int n, int m) {
        int temp = m;
        m = n % m;
        n = temp;
        
        return n;
    }

    /**
     * Calcula el mínimo común múltiplo de dos números.
     */
    public int minimoComunMultiplo(int n, int m) {
        int z = 0;
        z = n * m;
        
        return z;
    }
    
    /**
     * Calcula los divisores de un número.
     */
    public ArrayList<Integer> divisores(int n) {
        ArrayList<Integer> divisoresN = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisoresN.add(i); // divisor menor
                if (i != n / i) {
                    divisoresN.add(n / i); // divisor complementario
                }
            }
        }
    
        Collections.sort(divisoresN); // opcional: para que estén ordenados
        
        System.out.println(divisoresN);
        return divisoresN;
    }

    
    /**
     * Calcula los primeros n números primos
     */
    public int[] primos(int n) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return null;
    }
    
    /**
     * Calcula el n-ésimo número de Fibonacci
     */
    public int nthFib(int n) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return 0;
    }
    
    /**
     * Calcula los dígitos de un número entero positivo.
     */
    public ArrayList<Integer> digitos(int n) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return null;
    }
    
    /**
     * Calcula el valor mínimo de un arreglo de reales
     */
    public float minimo(float[] arreglo) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return 0;
    }
    
    /**
     * Calcula el valor máximo de un arreglo de reales
     */
    public float maximo(float[] arreglo) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return 0;
    }
    
    
    /**
     * Calcula el valor promedio de un arreglo de reales
     */
    public float promedio(float[] arreglo) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return 0;
    }
    
    /**
     * Retorna un arreglo con los primeros n números de Fibonacci
     */
    public int[] fibSequence(int n) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return null;
    }
    
    /**
     * Calcula la mediana de un arreglo de reales
     */
    public float mediana(float[] arreglo) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return 0;
    }
    
    /**
     * Comprueba si dos arreglos de enteros son iguales
     */
    public boolean iguales(int[] arr1, int[] arr2) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
        return false;
    }
    
    /**
     * Comprueba si un arreglo tiene valores repetidos
     */
    public boolean tieneRepetidos(int[] arreglo) {
        //TODO: Completar la implementación, reemplazando la línea siguiente
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
