package Vista;

import javax.swing.*;
import javax.swing.table.*;

import Modelo.Donaciones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class InterfazDonar extends JFrame {
    
    private JRadioButton radioT;
    private JRadioButton radioL;
    private ButtonGroup grupoRadio;
    private JTextField campoNombre;
    private JComboBox<String> comboP;
    private JSpinner spinnerCantidad;
    private JButton Agregar,cancelar;
    private JTable tablaCompra;
    private DefaultTableModel Tabla;
    private ArrayList<Donaciones> inventario;
    public double precioTotal;

    public InterfazDonar(){
        
        setTitle("Gracias por Donar");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear lista de productos
        inventario = new ArrayList<>();
        inventario.add(new Donaciones("Alimento: 3 Kg", 2500));
        inventario.add(new Donaciones("Alimento: 5 Kg", 3300));
        inventario.add(new Donaciones("Alimento: 10 Kg", 12000));
        inventario.add(new Donaciones("Carne enlatada", 3500));
        inventario.add(new Donaciones("Shampoo", 3000));
        inventario.add(new Donaciones("Desparasitante", 6000));
        inventario.add(new Donaciones("Pipetas", 4000));

        // Crear panel para datos de compra
        JPanel panelDatos = new JPanel(new FlowLayout());
        Color color1 = new Color(29, 113, 115  );
        panelDatos.setBackground(color1);
        
    
        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setForeground(Color.WHITE);
        campoNombre = new JTextField(15);
        JLabel labelP = new JLabel("Producto:");
        labelP.setForeground(Color.WHITE);
        comboP = new JComboBox<>();
        comboP.setForeground(Color.BLACK);
        for (Donaciones donaciones : inventario) {
            comboP.addItem(donaciones.getNombre());
        }
        JLabel labelCan = new JLabel("Cantidad:");
        labelCan.setForeground(Color.WHITE);
        spinnerCantidad = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        Agregar = new JButton("Agregar");
        panelDatos.add(labelNombre);
        panelDatos.add(campoNombre);
        panelDatos.add(labelP);
        panelDatos.add(comboP);
        panelDatos.add(labelCan);
        panelDatos.add(spinnerCantidad);
        panelDatos.add(Agregar);

        //  tabla para mostrar la la donación
        Tabla = new DefaultTableModel();
        Tabla.addColumn("Nombre");
        Tabla.addColumn("Producto");
        Tabla.addColumn("Cantidad");
        Tabla.addColumn("Precio Unitario");
        Tabla.addColumn("Precio Total");
        Tabla.addColumn("Tipo de Donación");
        tablaCompra = new JTable(Tabla);
        Color coloor = new Color(17, 95, 97 );
tablaCompra.setBackground(coloor);
tablaCompra.setForeground(Color.WHITE);
        // radio buttons para el método de donación
        radioT = new JRadioButton("Pago por transferencia");
        radioL = new JRadioButton("Dejar en el local");
        grupoRadio = new ButtonGroup();
        grupoRadio.add(radioT);
        grupoRadio.add(radioL);
        Color color = new Color(29, 113, 115);
        radioL.setBackground(color);
        radioL.setForeground(Color.WHITE);
        radioT.setBackground(color);
        radioT.setForeground(Color.WHITE);
       
        JPanel panelR = new JPanel(new GridLayout(1, 1));
        panelR.add(radioT);
        panelR.add(radioL);
        

        cancelar = new JButton("Cancelar");
        Color color5 = new Color(85, 170, 173 );
        cancelar.addActionListener(e -> dispose()); 
        cancelar.setBackground(color5);
        cancelar.setForeground(Color.WHITE);
        Agregar.setBackground(color5);
        Agregar.setForeground(Color.WHITE);
        panelDatos.add(cancelar);

        //  acción para el botón 
        Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        // Agregar componentes a la ventana
        JScrollPane scrollPane = new JScrollPane(tablaCompra);
        add(panelDatos, BorderLayout.NORTH);
        add(panelR, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
       
    }

    private void agregarProducto() {
        String nombre = campoNombre.getText();
        String productoSeleccionado = (String) comboP.getSelectedItem();
        int cantidad = (int) spinnerCantidad.getValue();
        String tipoDonacion = "";
        
        ImageIcon icono = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/icono2.jpg");
        if (radioT.isSelected()) {
            tipoDonacion = "Pago por transferencia";            
               
        } else if (radioL.isSelected()) {
            tipoDonacion = "Dejar en el Refugio";
            
        }

        Donaciones donacion = null;
        for (Donaciones d : inventario) {
            if (d.getNombre().equals(productoSeleccionado)) {
                donacion = d;
                break;
            }
        }

        if (donacion != null) {
            precioTotal = donacion.getPrecio() * cantidad;
            Object[] fila = {nombre, donacion.getNombre(), cantidad, donacion.getPrecio(), precioTotal, tipoDonacion};
            Tabla.addRow(fila);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar el producto seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (radioT.isSelected()) {
            tipoDonacion = "Pago por transferencia";        
            JOptionPane.showMessageDialog(null, "Quien alimenta a un animal hambriento, alimenta su propia alma. \n"+"El nombre de la cuenta es RefugioSJ  \n"+ "El precio total a pagar es de: " + 
                                ""+precioTotal+"\n" +"El número de sinpe es: 8759-4856 \n" +"","GRACIAS POR DONAR", JOptionPane.INFORMATION_MESSAGE, icono);
               
        } else if (radioL.isSelected()) {
            tipoDonacion = "Dejar en el Refugio";
            JOptionPane.showMessageDialog(null, "Quien alimenta a un animal hambriento, alimenta su propia alma. \n"+"¡¡Gracias por tu donación, te esperamos!!  \n","GRACIAS POR DONAR", JOptionPane.INFORMATION_MESSAGE, icono);
        }


    }


    public void mostrarVentana() {
        setVisible(true);
    }
    
}
