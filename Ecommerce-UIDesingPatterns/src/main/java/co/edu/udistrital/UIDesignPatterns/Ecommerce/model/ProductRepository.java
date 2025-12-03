package co.edu.udistrital.UIDesignPatterns.Ecommerce.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio que genera una lista de productos de ejemplo.
 */
public class ProductRepository {

    /**
     * Genera una lista de productos de distintas categorías.
     */
    public List<Product> obtenerTodos() {
        List<Product> productos = new ArrayList<>();

        // Simular varias categorías
        for (int i = 1; i <= 200; i++) {
            productos.add(new Product("Celular " + i, 500_000 + i * 1000, "Electronica"));
        }
        for (int i = 1; i <= 150; i++) {
            productos.add(new Product("Televisor " + i, 1_200_000 + i * 2000, "Electronica"));
        }
        for (int i = 1; i <= 150; i++) {
            productos.add(new Product("Sofa " + i, 900_000 + i * 1500, "Hogar"));
        }

        return productos;
    }
}

