/**
 * Esta clase espera un tiempo
 * dado en milisegundos
 * 
 * @author Alejandro Rodr�guez
 * @version 12/09/2011
 */
public class Sleep {

/**
 * Este m�todo realiza una pausa en la ejecuci�n
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