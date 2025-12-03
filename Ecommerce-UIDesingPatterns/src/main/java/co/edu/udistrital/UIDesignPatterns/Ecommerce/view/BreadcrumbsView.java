package co.edu.udistrital.UIDesignPatterns.Ecommerce.view;

/**
 * Componente que muestra la ruta de navegación (breadcrumbs).
 */
public class BreadcrumbsView {

    private String path;

    /**
     * Crea el breadcrumb con una ruta inicial.
     */
    public BreadcrumbsView(String initialPath) {
        this.path = initialPath;
    }

    /**
     * Actualiza la ruta actual.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Muestra la ruta de navegación en consola.
     */
    public void mostrar() {
        System.out.println();
        System.out.println("Ruta: " + path);
        System.out.println("-----------------------------------------------");
    }
}
