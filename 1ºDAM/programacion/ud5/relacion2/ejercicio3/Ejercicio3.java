package programacion.ud5.relacion2.ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        Producto champu = new Producto(1, "Champú", "Producto que te ayuda a lavarte el pelo", 2.0, 10);
        System.out.println(champu);
        champu.setPrecio(3.0);
        System.out.println(champu);
        Supermercado mercadona = new Supermercado();
        mercadona.agregarProductos(champu);
        System.out.println(mercadona.mostrarInventario());
        mercadona.venderProductos(champu.getId(), 7);
        System.out.println(mercadona.mostrarInventario());
    }
}