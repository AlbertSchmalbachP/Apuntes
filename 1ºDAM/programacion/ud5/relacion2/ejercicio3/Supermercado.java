package programacion.ud5.relacion2.ejercicio3;

import java.util.ArrayList;

public class Supermercado {
    ArrayList<Producto> productos;
    Supermercado() {
        this.productos = new ArrayList<>();
    }

    // metodos
    public void agregarProductos(Producto producto) {
        productos.add(producto);
    }
    public void venderProductos(int id, int cantidad) {
        int stockActual;
        int nuevoStock;
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                stockActual = producto.getCantidadEnStock();
                nuevoStock = stockActual - cantidad;
                producto.setCantidadEnStock(nuevoStock);
            }
        }
    }
    public String mostrarInventario() {
        String mensaje = "Productos:\n";
        for (Producto producto : productos) {
            mensaje += producto.toString() + "\n";
        }
        return mensaje;
    }
}
