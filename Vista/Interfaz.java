package  Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Interfaz extends JFrame {

    public  Interfaz (){
// Interfaz Principal

setTitle("Refugio para perritos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un JLabel para la imagen de fondo
        JLabel fondoLabel = new JLabel();
        ImageIcon imagenFondo = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/imagen1.jpg");
        fondoLabel.setIcon(imagenFondo);
        fondoLabel.setBounds(0, 0, getWidth(), getHeight());

        // Crear un panel para colocar los otros componentes
        JPanel panel = new JPanel();
        panel.setLayout(null); //Usar diseño absoluto

        // Crear y configurar el menú
        JMenuBar menu = new JMenuBar();

        JMenuItem adoptar = new JMenuItem("           Adoptar un Perrito");
        Color color = new Color(61, 167, 38);
        adoptar.setBackground(color);
        adoptar.setForeground(Color.WHITE);
        
        JMenuItem ingresar = new JMenuItem("           Ingresar un Perrito");
        ingresar.setBackground(color);
        ingresar.setForeground(Color.WHITE);

        JMenuItem donar= new JMenuItem("          Donar al Refugio");
        donar.setBackground(color);
        donar.setForeground(Color.WHITE);

        Color Borde = new Color(12, 64, 10 );
        //agregar al menu
        menu.add(adoptar);
        menu.add(ingresar);
        menu.add(donar);
        
        Border borde = BorderFactory.createLineBorder(Borde, 2); 
        menu.setBorder(borde);
        adoptar.setBorder(borde);
        ingresar.setBorder(borde);
        donar.setBorder(borde);

        // Agregar el menú 
        setJMenuBar(menu);

        // Configurar acciones para los elementos del menú
        adoptar.addActionListener(e -> {
            InterfazAdoptar ventana = new InterfazAdoptar();
            ventana.setVisible(true);
        });

        ingresar.addActionListener(e -> {
            
            InterfazIngresar ventana = new InterfazIngresar();
            ventana.setVisible(true);
        });

        donar.addActionListener(e -> {
            
            InterfazDonar ventana = new InterfazDonar();
            ventana.setVisible(true);
        });

        // Agregar el JLabel de fondo y el panel a la ventana principal
        add(fondoLabel);
        add(panel);
    }

    public void mostrarVentana() {
        setVisible(true);
    }
    
}
