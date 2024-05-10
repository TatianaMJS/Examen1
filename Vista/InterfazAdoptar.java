package Vista;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
public class InterfazAdoptar extends JFrame {

    public InterfazAdoptar(){
    setTitle("Adoptar Perritos");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        //  tabla personalizada
        DefaultTableModel tabla3 = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? ImageIcon.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // para que las celdas no se puedan editar
            }
        };

        // columnas de la tabla 
        tabla3.addColumn("Foto");
        tabla3.addColumn("Nombre");
        tabla3.addColumn("Edad");
        tabla3.addColumn("Raza");
        tabla3.addColumn("Castrado");

        // Crear la tabla con el modelo personalizado
        JTable tabla = new JTable(tabla3);
        tabla.setRowHeight(100); 
        Color color = new Color(29, 113, 115 );
        tabla.setBackground(color);
        tabla.setForeground(Color.WHITE);

        // Configurar el ancho de las columnas
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(0); 

        // Agregar datos 
        ImageIcon HULK = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/HULK.jpg");
        ImageIcon LUNA = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/prueba.jpg");
        ImageIcon CLARA = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/CLARA.jpg");
        ImageIcon ZEUS = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/LUNA.jpg");
        ImageIcon LILI = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/imagen3.jpg");
        Object[] fila1 = {HULK, "Hulk", "4 años", "Labrador", "Sí"};
        tabla3.addRow(fila1);
        Object[] fila2 = {LUNA, "Luna", " 5 años", "Pastor Alemán", "No"};
        tabla3.addRow(fila2);
        Object[] fila3 = {CLARA, "Clara", "2 años", "Zaguate", "No"};
        tabla3.addRow(fila3);
        Object[] fila4 = {ZEUS, "Zeus", " 1 años", "Zaguate", "Si"};
        tabla3.addRow(fila4);
        Object[] fila5 = {LILI, "Lili", " 5 meses", "Zaguate", "Si"};
        tabla3.addRow(fila5);

        //  mostrar la foto del perrito seleccionado
        JLabel fotoLabel = new JLabel();
        fotoLabel.setPreferredSize(new Dimension(450, 700)); // Tamaño fijo para la foto
        fotoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 

        //  acción para mostrar la foto del perrito al seleccionar su nombre en la tabla
        tabla.getSelectionModel().addListSelectionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada != -1) {
                ImageIcon fotoSelec = (ImageIcon) tabla.getValueAt(filaSeleccionada, 0);
                fotoLabel.setIcon(fotoSelec);
            }
        });

        // Crear botones
        JButton adoptar = new JButton("Adoptar");
        JButton cancelar = new JButton("Cancelar");
        adoptar.setBackground(color);
        adoptar.setForeground(Color.WHITE);
        cancelar.setBackground(color);
        cancelar.setForeground(Color.WHITE);
        // Crear panel para los botones
        JPanel Botones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Botones.add(adoptar);
        Botones.add(cancelar);

        // Agregar tabla, foto del perrito y panel de botones 
        JPanel Principal = new JPanel(new BorderLayout());
        Principal.add(new JScrollPane(tabla), BorderLayout.CENTER);
        Principal.add(fotoLabel, BorderLayout.EAST);
        add(Principal, BorderLayout.CENTER);
        add(Botones, BorderLayout.SOUTH);

        //  acción para cancelar
        cancelar.addActionListener(e -> dispose()); 

        // accion para adoptar
        adoptar.addActionListener(e -> {
            
            String fecha = JOptionPane.showInputDialog(this, "Ingrese la fecha para recoger a tu nuevo amigo (Dia-Mes-Año):");
            ImageIcon icono = new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/icono.jpg");
            if (fecha != null && !fecha.isEmpty()) {
               
JOptionPane.showMessageDialog(null, "No puedes comprar la felicidad pero puedes adoptar un perro y eso es casi lo mismo. \n"+"La fecha seleccionada para recoger al perrito es: " + fecha,"Solicitud Exitosa", JOptionPane.INFORMATION_MESSAGE, icono);
                
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar una fecha válida.", "VUELVA A INGRESAR LA FECHA", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

        public void mostrarVentana() {
            setVisible(true);
        }
    
        }

