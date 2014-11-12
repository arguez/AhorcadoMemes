/**
 * Esta clase espera un tiempo
 * dado en milisegundos
 * 
 * @author Alejandro Rodríguez
 * @version 12/09/2011
 */
public class Sleep {

/**
 * Este método realiza una pausa en la ejecución
 * 
 * @param t tiempo en milisegundos
 */
    public static void wait(int t) {
        try {
            Thread.sleep(t);
        }
        catch (Exception e) {
        }
    }
}