package programacion.ud5.relacion2.ejercicio3;

public class FakerProductos {
    private static final String[] productos = {
            "Leche Entera", "Pan de Molde", "Arroz Brillante", "Pasta Espagueti", "Aceite de Oliva",
            "Detergente Líquido", "Champú Anticaspa", "Papel Higiénico", "Manzana Roja", "Plátano Canario",
            "Pechuga de Pollo", "Atún en Conserva", "Yogur Natural", "Cerveza Alhambra", "Refresco Cola",
            "Galletas María", "Café Molido", "Azúcar Blanco", "Sal Marina", "Huevos L",
            "Queso Manchego", "Jamón Serrano", "Tomate Frito", "Garbanzos", "Lentejas Pardinas"
    };

    private static final String[] categorias = {
            "Lácteos", "Panadería", "Limpieza", "Higiene", "Frutería", 
            "Carnicería", "Bebidas", "Despensa", "Conservas", "Snacks"
    };

    public static int entero(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static double precio(double min, double max) {
        // Genera un precio con dos decimales
        return Math.round((Math.random() * (max - min) + min) * 100.0) / 100.0;
    }

    public static String nombreProducto() {
        return productos[entero(0, productos.length - 1)];
    }

    public static String descripcion() {
        String cat = categorias[entero(0, categorias.length - 1)];
        return "Producto de alta calidad de la sección " + cat;
    }
}
