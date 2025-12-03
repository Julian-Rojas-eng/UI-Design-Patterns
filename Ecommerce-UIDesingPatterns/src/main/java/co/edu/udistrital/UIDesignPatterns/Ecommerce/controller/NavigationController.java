package co.edu.udistrital.UIDesignPatterns.Ecommerce.controller;

import co.edu.udistrital.UIDesignPatterns.Ecommerce.model.Product;
import co.edu.udistrital.UIDesignPatterns.Ecommerce.model.ProductRepository;
import co.edu.udistrital.UIDesignPatterns.Ecommerce.view.BreadcrumbsView;
import co.edu.udistrital.UIDesignPatterns.Ecommerce.view.ProductListView;
import co.edu.udistrital.UIDesignPatterns.Ecommerce.view.TopMenuView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Controlador que maneja el flujo de navegación del usuario,
 * incluyendo menú principal, selección de categoría y paginación.
 */
public class NavigationController {

    private TopMenuView topMenuView;
    private BreadcrumbsView breadcrumbsView;
    private ProductListView productListView;
    private ProductRepository repository;
    private Scanner scanner;

    /**
     * Inicializa el controlador con las vistas y el repositorio de productos.
     */
    public NavigationController() {
        this.topMenuView = new TopMenuView();
        this.breadcrumbsView = new BreadcrumbsView("Inicio");
        this.productListView = new ProductListView();
        this.repository = new ProductRepository();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Punto de entrada del flujo de navegación.
     * Muestra el menú principal y procesa las opciones del usuario.
     */
    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            topMenuView.mostrarMenuPrincipal();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    navegarPorCategorias();
                    break;
                case "2":
                    mostrarAyuda();
                    break;
                case "3":
                    System.out.println("Saliendo de la tienda. Gracias por su visita");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    /**
     * Permite elegir una categoría y luego navegar por sus productos.
     */
    private void navegarPorCategorias() {
        System.out.println();
        System.out.println("Categorias disponibles:");
        System.out.println("1. Electronica");
        System.out.println("2. Hogar");
        System.out.print("Seleccione una categoria: ");

        String opcion = scanner.nextLine();
        String categoriaSeleccionada;

        switch (opcion) {
            case "1":
                categoriaSeleccionada = "Electronica";
                break;
            case "2":
                categoriaSeleccionada = "Hogar";
                break;
            default:
                System.out.println("Categoria no valida.");
                return;
        }

        breadcrumbsView.setPath("Inicio > " + categoriaSeleccionada);
        breadcrumbsView.mostrar();

        List<Product> productosCategoria = repository.obtenerTodos().stream()
                .filter(p -> p.getCategoria().equals(categoriaSeleccionada))
                .collect(Collectors.toList());

        if (productosCategoria.isEmpty()) {
            System.out.println("No hay productos en esta categoria.");
            return;
        }

        navegarConPaginacion(productosCategoria, categoriaSeleccionada);
    }

    /**
     * Controla la paginación de los productos de una categoría.
     */
    private void navegarConPaginacion(List<Product> productos, String categoria) {
        int paginaActual = 1;
        boolean salir = false;

        while (!salir) {
            breadcrumbsView.mostrar();
            productListView.mostrarPagina(productos, paginaActual);

            String opcion = scanner.nextLine().trim().toUpperCase();

            switch (opcion) {
                case "P":
                    paginaActual--;
                    if (paginaActual < 1) {
                        paginaActual = 1;
                        System.out.println("Ya esta en la primera pagina.");
                    }
                    break;
                case "N":
                    int totalPaginas = (int) Math.ceil(productos.size() / 10.0);
                    paginaActual++;
                    if (paginaActual > totalPaginas) {
                        paginaActual = totalPaginas;
                        System.out.println("Ya esta en la última pagina.");
                    }
                    break;
                case "X":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Use P, N o X.");
            }
        }
    }

    /**
     * Muestra un mensaje sencillo de ayuda.
     */
    private void mostrarAyuda() {
        System.out.println();
        System.out.println("AYUDA");
        System.out.println("En esta tienda puede navegar por categorias,");
        System.out.println("ver la lista de productos con paginacion y volver al menu principal.");
        System.out.println();
    }
}

