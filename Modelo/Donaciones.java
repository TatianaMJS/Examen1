package Modelo;

public class Donaciones {
    private String nombre;
    private double precio;

    public Donaciones(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
