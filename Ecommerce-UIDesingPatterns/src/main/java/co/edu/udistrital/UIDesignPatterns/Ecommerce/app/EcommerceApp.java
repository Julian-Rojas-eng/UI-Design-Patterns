package co.edu.udistrital.UIDesignPatterns.Ecommerce.app;

import co.edu.udistrital.UIDesignPatterns.Ecommerce.controller.NavigationController;

/**
 * Clase principal que inicia la aplicación de consola.
 */
public class EcommerceApp {

    public static void main(String[] args) {
        NavigationController controller = new NavigationController();
        controller.iniciar();
    }
}
