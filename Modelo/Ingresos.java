package Modelo;

import javax.swing.ImageIcon;

public class Ingresos {
    private String nombre;
    private int edad;
    private String raza;
    private boolean castrado;
    private ImageIcon foto;

    public Ingresos(String nombre, int edad, String raza, boolean castrado, ImageIcon foto) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.castrado = castrado;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public ImageIcon getFoto() {
        return foto;
    }
}