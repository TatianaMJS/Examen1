package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Modelo.Ingresos;
import Modelo.IngresosCalle;
import Modelo.IngresosDueño;
public class InterfazIngresar extends JFrame{
    private JTextField txtNombre, txtEdad, txtRaza;
    private JCheckBox chkCastrado;
    private JButton agregar, cancelar;
    private JTable tablaPerritos;
    private DefaultTableModel Tabla;
    private ArrayList<Ingresos> ingresosP;// arraylist que se llama ingresosP pero que se llena con la clase ingresos 
    private JRadioButton Encontrado, Abandono;

    public InterfazIngresar() {
      

        setTitle("Refugio de Perritos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ingresosP = new ArrayList<>();

        JPanel panelDatos = new JPanel(); //interfaz
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);
        panelDatos.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelDatos.add(txtEdad);
        panelDatos.add(new JLabel("Raza:"));
        txtRaza = new JTextField();
        panelDatos.add(txtRaza);
        panelDatos.add(new JLabel("Castrado:"));
        chkCastrado = new JCheckBox();
        panelDatos.add(chkCastrado);
        panelDatos.add(new JLabel("Tipo de ingreso:"));
        ButtonGroup grupoTipoIngreso = new ButtonGroup(); // un grupo de botones para los botones de radio
        Encontrado = new JRadioButton("Encontrado");
        Abandono = new JRadioButton("Abandono");
        grupoTipoIngreso.add(Encontrado);
        grupoTipoIngreso.add(Abandono);
        panelDatos.add(Encontrado);
        panelDatos.add(Abandono);


        Color color = new Color(29, 113, 115 );
        Encontrado.setForeground(Color.WHITE);
        Abandono.setForeground(Color.WHITE);

        agregar = new JButton("Agregar");
        
        panelDatos.add(agregar);
        

        Tabla = new DefaultTableModel();  //tabla personalizada para los datos
        Tabla.addColumn("Nombre");
        Tabla.addColumn("Edad");
        Tabla.addColumn("Raza");
        Tabla.addColumn("Castrado");
        tablaPerritos = new JTable(Tabla);
    
        JScrollPane panel = new JScrollPane(tablaPerritos);
        Color color4 = new Color(48, 181, 185 );
        tablaPerritos.setBackground(color);
        tablaPerritos.setForeground(Color.WHITE);
        panelDatos.setBackground(color4);
        panelDatos.setForeground(Color.WHITE);
        agregar.setBackground(color);
        agregar.setForeground(Color.WHITE);
        Encontrado.setBackground(color4);
        Abandono.setBackground(color4);

        agregar.addActionListener(e -> agregarPerrito());
        
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(e -> dispose()); 
        cancelar.setBackground(color);
        cancelar.setForeground(Color.WHITE);
        
        getContentPane().add(panelDatos, BorderLayout.NORTH); //posiciones en la ventana 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(cancelar, BorderLayout.SOUTH);
    }

    private void agregarPerrito() { //método para agregar a los perros al refugio 
        String nombre = txtNombre.getText();
    int edad = Integer.parseInt(txtEdad.getText());
    String raza = txtRaza.getText();
    boolean castrado = chkCastrado.isSelected(); 
    boolean esAbandono = Abandono.isSelected();

     ImageIcon foto = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/imagen3.jpg\"");

    // Verifica si el perro no está castrado y es por motivo de abandono
    if (!castrado && esAbandono) {
        JOptionPane.showMessageDialog(null, "El perro debe estar castrado para ser ingresado por abandono.");
        return; // si se da, salir del método sin agregar la información a la tabla
    }

    Ingresos perrito;
    if (esAbandono) {
        perrito = new IngresosDueño(nombre, edad, raza, castrado, foto);
        ((IngresosDueño) perrito).verificar();
    } else {
        perrito = new IngresosCalle(nombre, edad, raza, castrado, foto);
        ((IngresosCalle) perrito).verificar();
    }

    ingresosP.add(perrito);

    Object[] fila = {perrito.getNombre(), perrito.getEdad(), perrito.getRaza(), perrito.isCastrado()};
    Tabla.addRow(fila);
}
        

        
}