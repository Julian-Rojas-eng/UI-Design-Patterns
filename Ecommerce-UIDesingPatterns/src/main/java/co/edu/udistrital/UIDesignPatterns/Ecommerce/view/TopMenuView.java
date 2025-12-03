package co.edu.udistrital.UIDesignPatterns.Ecommerce.view;


/**
 * Vista que muestra el menú principal de navegación.
 */
public class TopMenuView {

    /**
     * Muestra las opciones principales de navegación.
     */
    public void mostrarMenuPrincipal() {
        System.out.println("===============================================");
        System.out.println("              TIENDA ONLINE - MENU             ");
        System.out.println("===============================================");
        System.out.println("1. Ver productos por categoria");
        System.out.println("2. Ayuda");
        System.out.println("3. Salir");
        System.out.println("===============================================");
        System.out.print("Seleccione una opcion: ");
    }
}
