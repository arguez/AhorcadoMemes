/**
 * Esta clase crea los objetos principales
 * para ejecutar el juego del ahorcado
 * 
 * @author Alejandro Rodriguez
 * @version 13/09/2011
 */

public class Controlador {
    /**
     * Este m�todo da inicio a la
     * l�gica del programa
     */
    public static void main(String [] args) {
        Arbitro arbitro;
        arbitro = new Arbitro();
        arbitro.iniciar();
    }
}