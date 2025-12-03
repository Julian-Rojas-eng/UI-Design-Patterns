package co.edu.udistrital.UIDesignPatterns.Ecommerce.model;

/**
 * Modelo de datos que representa un producto del catálogo.
 */
public class Product {

    private String nombre;
    private double precio;
    private String categoria;

    /**
     * Crea un producto con nombre, precio y categoría.
     * 
     */
    public Product(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }
}
