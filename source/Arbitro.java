/**
 * Esta clase mantiene control sobre la puntuación
 * del juego y la interacción entre el usario y
 * otras clases.
 * 
 * @author Alejandro Rodríguez
 * @version 12/09/2011
 */

public class Arbitro  {
    
    Interfaz interfaz;
    Filologo filologo;
    String progreso;
    
     /**
     * Inicialización de objetos.
     */
    public Arbitro() {
        interfaz = new Interfaz();
        filologo = new Filologo();
    }
    
    /**
     * Ejecución del juego.
     */
    public void iniciar() {
        
        interfaz.iniciar();
        while (true) {
            Sleep.wait(500);
            if(interfaz.getEstado()) {
                jugar();
            }
        }
        /*while (interfaz.confirmar("Seleccione una opciÃ³n", "Â¿Desea iniciar un juego nuevo?", 0, 3)==0) {
            jugar();
        }*/
        //System.exit(0);
    }
    
    /**
     * Control sobre turnos disponibles,
     * utilización de la clase Filologo
     * para obtener y comparar palabras.
     */
    
    private void jugar() {
        
        progreso = "";
        int turnos = 9;
        String caracter;
        filologo.crearPalabra();
        rellenarPalabra(filologo.obtenerLargo());
        interfaz.mostrarProgreso(obtenerProgreso());
        while (turnos>0) {
            interfaz.mostrarTurnos(Integer.toString(turnos));
            Sleep.wait(1000);
            //interfaz.mostrarHilera("Turnos restantes", Integer.toString(turnos));
            caracter=interfaz.pedirHilera("Adivinar una letra",3);
            if(buscar(caracter)) {
                progreso = filologo.rellenar(progreso, caracter);
                //interfaz.mostrarHilera("Progreso", obtenerProgreso());
                interfaz.mostrarProgreso(obtenerProgreso());
            }
            else {
                turnos--;
                interfaz.setPic(9-turnos);
                /*Dibujar objetos*/
                if (turnos==0) {
                    interfaz.mostrarTurnos(Integer.toString(turnos));
                    Sleep.wait(1000);
                    interfaz.mostrarHilera("¡Ha perdido la partida", "La palabra era: " + filologo.pedirRespuesta());
                    interfaz.mostrarProgreso("");
                    //interfaz.setPic(9);
                }
            }
            if (filologo.comparar(progreso)) { 
                interfaz.mostrarHilera("¡Felicidades!", "Ha ganado esta partida");
                interfaz.mostrarProgreso("");
                interfaz.mostrarTurnos("");
                if (turnos==9) {
                    interfaz.setPic(10);
                }
                 if (turnos==5) {
                     interfaz.setPic(11);
                }
                 if (turnos==1) {
                     interfaz.setPic(12);
                }
                turnos=0;
                Sleep.wait(2000);
            }
        }
        interfaz.setPic(0);
        interfaz.setEstado();
        interfaz.setBoton();
    }
    
    /**
     * Este método determina si existe la letra
     * indicada por el usuario en la palabra secreta
     * que almacena Filologo.
     * 
     * @param letra la letra deseada
     * @return existe indica si existe o no
     */

    private boolean buscar(String letra) {
        boolean existe = true;
        int indice = filologo.buscarLetra(letra);
        if (indice<0) {
            existe=false;
        }
        return existe;
    }
    
    /**
     * Rellena una palabra con guiones bajos
     * segun sea la cantidad de la palabra secreta.
     * 
     * @param largo largo de la palabra secreta
     * proporcionado por Filologo
     */
    
    private void rellenarPalabra(int largo) {
        for (int i=0; i<largo; i++) {
            progreso = progreso + "_";
        }
    }
    
    /**
     * Este método muesta las letras que el usuario
     * ha adivinado correctamente.
     * 
     * @return hilera el progreso del usuario
     */
    
    private String obtenerProgreso() {
        String hilera = "";
        for (int i=0;i<progreso.length(); i++) {
            hilera = hilera + progreso.charAt(i) + " ";
        }
        hilera = hilera.trim();
        return hilera;
    }
}