package co.edu.udistrital.UIDesignPatterns.Ecommerce.view;

import co.edu.udistrital.UIDesignPatterns.Ecommerce.model.Product;

import java.util.List;

/**
 * Vista encargada de mostrar la lista de productos con paginación.
 */
public class ProductListView {

    private static final int PRODUCTOS_POR_PAGINA = 10;

    /**
     * Muestra una página de productos de la categoría seleccionada.
     * @param productos Lista filtrada por categoría.
     * @param pagina Número de página (1-based).
     */
    public void mostrarPagina(List<Product> productos, int pagina) {
        int totalProductos = productos.size();
        int totalPaginas = (int) Math.ceil(totalProductos / (double) PRODUCTOS_POR_PAGINA);

        if (pagina < 1 || pagina > totalPaginas) {
            System.out.println("Pagina fuera de rango. Total paginas: " + totalPaginas);
            return;
        }

        int inicio = (pagina - 1) * PRODUCTOS_POR_PAGINA;
        int fin = Math.min(inicio + PRODUCTOS_POR_PAGINA, totalProductos);

        System.out.println("Mostrando pagina " + pagina + " de " + totalPaginas);
        System.out.println();

        for (int i = inicio; i < fin; i++) {
            Product p = productos.get(i);
            System.out.printf("%-3d %-25s $%,.0f%n",
                    (i + 1), p.getNombre(), p.getPrecio());
        }

        System.out.println();
        System.out.println("P = Pagina anterior | N = Pagina siguiente | X = Volver al menu");
        System.out.print("Opcion: ");
    }
}
