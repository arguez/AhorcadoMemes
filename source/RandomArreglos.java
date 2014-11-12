/**
 * Esta clase devuelve números aleatorios
 * dentro de un rango y desordena arreglos
 * de tipo int.
 * 
 * @author Alejandro Rodríguez Flores 
 * @version 13/09/2011
 */

public class RandomArreglos {

    /**
     * Ese método devuelve un número aleatorio
     * dentro del rango especificado [x,y].
     */

    public static int rangoAleatorio(int min, int max) {
        int aleatorio = (int)(Math.random()*(max - min+1))+min;
        return aleatorio;
    }
    
    public static int[] getIntArray(int min, int max) {
        
        /*Se requiere sumar 1 al tamaño para poder almacenar
        la totalidad de los números del rango espeficido*/
        int arreglo[] = new int[max-min+1];
        arreglo[0] = rangoAleatorio(min, max);
        int ocupados = 1;
        int aleatorio;
        while (ocupados<arreglo.length) {
           aleatorio = rangoAleatorio(min, max);
           if (!comprobar(arreglo, ocupados, aleatorio)) {
               arreglo[ocupados] = aleatorio;
               ocupados++;
            }
        }
        return arreglo;
    }
    
    public static int [] sortIntArray(int arreglo[]) {
        int tamaño = arreglo.length;
        int [] arregloTemp = new int [tamaño];
        int [] arregloRand = getIntArray(0, tamaño-1);
        int contador = 0;
        
        while (contador<tamaño) {
            arregloTemp[contador]=arreglo[arregloRand[contador]];
            System.out.println("Arreglo: " + arreglo[contador] + " Temp: " + arregloTemp[contador] + " Rand: " +arregloRand[contador]);
            contador++;
        }
        return arreglo;
    }
    
    private static boolean comprobar(int []arreglo, int ocupados, int numAleatorio) {
        boolean existe = false;
        int contador = 0;
        
        while (contador<ocupados) {
            if (arreglo[contador]==numAleatorio) {
                existe = true;
            }
            contador++;
        }
        return existe;
    }
    
    void iniciar() { //método de prueba
        int [] miArreglo = new int [] {1,2,3,4,5,6,7,8,9,10};
        sortIntArray(miArreglo);
    }
}