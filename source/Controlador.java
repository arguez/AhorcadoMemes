/**
 * Esta clase crea los objetos principales
 * para ejecutar el juego del ahorcado
 * 
 * @author Alejandro Rodriguez
 * @version 13/09/2011
 */

public class Controlador {
    /**
     * Este método da inicio a la
     * lógica del programa
     */
    public static void main(String [] args) {
        Arbitro arbitro;
        arbitro = new Arbitro();
        arbitro.iniciar();
    }
}