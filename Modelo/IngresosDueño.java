package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IngresosDueño extends Ingresos {
    
    public IngresosDueño(String nombre, int edad, String raza, boolean castrado, ImageIcon foto) {
        super(nombre, edad, raza, castrado, foto);
    }

    public void verificar() {
        if (!isCastrado()) {
            JOptionPane.showMessageDialog(null, "Para ser ingresado al refugio, el perro debe estar castrado.");
        } else {

            ImageIcon icono =new ImageIcon("C:/Users/Lenovo/OneDrive/Documents/ProyectosGit/Examen1/fotos/icono5.jpg");
            JOptionPane.showMessageDialog(null, "Registro exitoso, por medidas de precaución del refugio debe de presentarse\n"+"la siguiente fecha para un chequeo veterinario general: 25/05/2024\n"+" Cada nuevo perro que entra en el refugio nos regala un pedacito de su corazón\n"+ "","BIENVENIDO AL REFUGIO", JOptionPane.INFORMATION_MESSAGE, icono);

        }
    }
}

