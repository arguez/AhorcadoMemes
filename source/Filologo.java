/**
 * Esta clase crea una palabra secreta
 * para el juego del ahorcado, compara
 * si existe una letra espec�fica y si
 * dos palabras son iguales.
 * 
 * @author Alejandro Rodr�guez
 * @version 11/09/2011
 */

import java.io.FileReader;
import java.io.BufferedReader;

public class Filologo {

    FileReader archivo;
    BufferedReader br;
    private String palabraSecreta;
    private String palabraUsuario;
    
    /**
     * Este m�todo crea una palabra secreta
     */
    
    public void crearPalabra() {

        boolean buscar = true;
        int contador = 1;
        int palabras = contarPalabras();
        int linea = RandomArreglos.rangoAleatorio(0,palabras);
        try {
            archivo = new FileReader("src\\lang\\diccionario.pir");
            br = new BufferedReader(archivo);
            while (buscar&&((palabraSecreta=br.readLine())!=null)) {
                if (contador >= linea) {
                buscar = false;
                }
                contador++;
            }
        }
        catch(Exception e) { 
        }
    }
    
    /**
     * Devuelve la posici�n de una letra
     * 
     * @param letra la letra que ser� buscada
     * @return -1 si no existe, la posici�n
     */
    
    public int buscarLetra(String letra) {
        return palabraSecreta.indexOf(letra);
    }
    
    /**
     * Compara dos palabras, devuelve verdadero
     * si son iguales, falso en caso contrario.
     * 
     * @param palabra el progreso del usuario
     * @return true, false
     */
    
    public boolean comparar(String palabra) {
        boolean iguales = false;
        if (palabraSecreta.equals(palabra)) {
            iguales = true;
        }
        return iguales;
    }
    
    /**
     * Este m�todo se encarga de llenar una
     * palabra vac�a con el caracter que existe
     * en la palabra secreta y lo coloca en las
     * posciciones correspondientes.
     * 
     * @param palabra una palabra que contiene
     * rayas y caracteres adivinados previamente.
     * @param letra la letra que ser� a�adida.
     */
    
    public String rellenar(String palabra, String letra) {
        
        int num;
        int indice = 0;
        String resultado;
        char [] letras = palabra.toCharArray();
        
        while ((num=palabraSecreta.indexOf(letra, indice))>=0) {
            letras[num]=palabraSecreta.charAt(num);
            indice++;
        }
        resultado = new String(letras);
        return resultado;
    }
    
    /**
     * Obtener el largo de la palabra secreta.
     */
    
    public int obtenerLargo() {
        return palabraSecreta.length();
    }
    
    /**
     * Este m�todo calcula cuantas palabras 
     * existen en el diccionario, del cual
     * se obtiene la palabra secreta.
     */
    
    private int contarPalabras() {
        int cantidad = 0;
        try {
            archivo = new FileReader("src\\lang\\diccionario.pir");
            br = new BufferedReader(archivo);
            while ((br.readLine())!=null) {
                cantidad++;
            }
        }
        catch (Exception e) {
        }
        return cantidad;
    }
    
    /**
     * Solicitud de la palabra secreta en
     * caso que ya no queden turnos y se
     * le quiera mostrar al usuario.
     * 
     * @return la palabra secreta
     */
    
    public String pedirRespuesta() {
        return palabraSecreta;
    }
        
}