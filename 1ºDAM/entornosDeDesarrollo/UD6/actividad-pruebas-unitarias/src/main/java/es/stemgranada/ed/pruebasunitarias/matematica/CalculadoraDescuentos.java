package es.stemgranada.ed.pruebasunitarias.matematica;

public class CalculadoraDescuentos {

    public double calcularDescuento(double precio, int porcentaje) {

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Porcentaje inválido");
        }

        return precio - (precio * porcentaje / 100);
    }

    public double aplicarDescuentoPorCliente(double precio, String tipoCliente) {

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if (tipoCliente == null) {
            throw new IllegalArgumentException("Tipo de cliente inválido");
        }

        switch (tipoCliente.toLowerCase()) {
            case "vip":
                return precio * 0.7; // 30% descuento
            case "regular":
                return precio * 0.9; // 10% descuento
            case "nuevo":
                return precio * 0.95; // 5% descuento
            default:
                return precio;
        }
    }

    public boolean esDescuentoValido(int porcentaje) {
        return porcentaje >= 0 && porcentaje <= 100;
    }
}
