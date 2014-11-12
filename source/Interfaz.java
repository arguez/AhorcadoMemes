/**
 * Esta clase se encarga de mostrar
 * información al usuario y pedir
 * entradas de datos.
 * 
 * @author Alejandro Rodríguez
 * @version 12/09/2011
 */

//import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.applet.AudioClip;
import java.applet.Applet;
import java.net.URL;


public class Interfaz {

    private static JFrame frame;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JLabel label1;
    private static JLabel label2;
    private static JLabel lblTurnos;
    private static JLabel lblProgreso;
    private static boolean lbl1_presionado;
    private static JOptionPane display;
    
    /**
     * Inicialización de objetos y atributos
     */
    public Interfaz() {
        display = new JOptionPane();
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        lblTurnos = new JLabel();
        lblProgreso = new JLabel();
    }
    
    /**
     * Este método se encarga de ejecutar
     * la funcionalidad del la clase.
     */
    
    public void iniciar(){
        inicializar();
    }
    
    /**
     * Este método crea los elementos
     * necesarios para la interacción
     * con el usuario.
     */
    
    private void inicializar() {
        
        lbl1_presionado = false;
         
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 650);
        frame.setLocationRelativeTo(null);  //para que aparezca centrado
        frame.setLayout(null);
        frame.setTitle("Ahorcado");
        frame.setResizable(false);
        frame.add(panel1);
        frame.add(panel2);
        
        //panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.setBounds(5,490,110,110);
        panel1.setVisible(true);
        panel1.add(label1);
        
        //panel2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel2.setBounds(5,0,480,480);
        panel2.setVisible(true);
        panel2.add(label2);
        
        frame.add(lblTurnos);
        frame.add(lblProgreso);
        
        label1.setSize(100,100);
        label1.setIcon(new javax.swing.ImageIcon("src\\graphics\\play.jpg"));
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            
            /*public void mouseClicked(MouseEvent e) {
                label1_mouseClicked(e);
            }*/
            public void mousePressed(MouseEvent e) {
                label1_mousePressed(e);
            }
            
        });
        
        label2.setSize(480,480);
        label2.setIcon(new javax.swing.ImageIcon("src\\graphics\\Stage0.jpg"));
        
        lblTurnos.setSize(150,30);
        lblTurnos.setLocation(130,490);
        lblTurnos.setText("<html><h3><font color=\"#000099\" face=\"Comic Sans MS\">Turnos:</font></h2></html>");
        
        lblProgreso.setSize(300,70);
        lblProgreso.setLocation(120,510);
        lblProgreso.setText("<html><h3><font color=\"#000099\" face=\"Comic Sans MS\">Progreso:</font></h2></html>");
        
        panel1.updateUI();
        panel2.updateUI();
        
        frame.repaint();    //actualiza el contnido del frame
        frame.setVisible(true);
    }

    /*
     * Cambio de figura del botÃ³n despuÃ©s de un click
     
    private void label1_mouseClicked(MouseEvent e) {
        label1.setIcon(new javax.swing.ImageIcon("src\\graphics\\play.jpg"));
    }
    */
    /**
    * Cambio de figura del botón al presionarlo
    */
    private void label1_mousePressed(MouseEvent e) {
        label1.setIcon(new javax.swing.ImageIcon("src\\graphics\\play2.jpg"));
        lbl1_presionado = true;
    }
    
    /**
     * Determina si se ha presionado el botón de inicio
     * 
     * @return true, false
     */
    public boolean getEstado() {
        return lbl1_presionado;
    }
    
    /**
     * Establece la imagen de fondo
     * 
     * @param n el número de la imagen
     */
    public void setPic(int n) {
        label2.setIcon(new javax.swing.ImageIcon("src\\graphics\\Stage"+n+".jpg"));
    }
    
    /**
     * Muestra el avance del usuario en el frame
     * 
     * @param cadena el progreso del usuario
     */
    public void mostrarProgreso(String cadena) {
        lblProgreso.setText("<html><h3><font color=\"#000099\" face=\"Comic Sans MS\">Progreso: " + cadena + "</font></h2></html>");
    }
    
    /**
     * Muestra los turnos disponibles
     * 
     * @param turnos los turnos restantes
     */
    public void mostrarTurnos(String turnos) {
        lblTurnos.setText("<html><h3><font color=\"#000099\" face=\"Comic Sans MS\">Turnos: " + turnos + "</font></h2></html>");
    }
    
    /**
     * Establece el estado del botón de
     * inicio en no presionado, para que
     * pueda utilizarse de nuevo.
     */
    public void setEstado() {
        lbl1_presionado=false;
    }
    
    /**
     * Cambia la figura del botón para
     * indicar que es posible jugar
     * nuevamente.
     */
    public void setBoton() {
        label1.setIcon(new javax.swing.ImageIcon("src\\graphics\\play.jpg"));
    }
    
    /**
     * Muestra un mensaje de texto
     * 
     * @param titulo titulo del cuadro de diálogo
     * @param mensaje el mensaje que se desea mostrar
     */
    public void mostrarHilera(String titulo, String mensaje) {
        display.showMessageDialog(null, mensaje, titulo, display.PLAIN_MESSAGE);
    }

    /**
     * Pide una cadena de texto al usuario
     * 
     * @param mensaje la información que 
     * desplegará el cuadro de diálogo.
     * @param icono tipo de icono
     * @return String introducido
     */
    public String pedirHilera(String mensaje, int icono) {
        return display.showInputDialog(null, mensaje, "", icono);
    }
    
    /**
     * Este método pide un String y lo convierte a entero
     * 
     * @param mensaje la información que 
     * desplegará¡ el cuadro de diálogo.
     * @param icono tipo de ícono
     * @return String convertido en entero
     */
    public int pedirEntero(String mensaje, int icono) {
        return Integer.parseInt(pedirHilera(mensaje, icono));
    }
    
    /**
     * Este método muestra un diálogo de confirmación
     * 
     * @param titulo titulo del cuadro de diálogo
     * @param opc tipos de opciones
     * @param msg tipo de ícono
     * @retun el entero correspondiente a la opción seleccionada
     */
    public int confirmar(String titulo, String mensaje, int opc, int msg) {
        return display.showConfirmDialog(null, mensaje, titulo, opc, msg);
    }
    
}