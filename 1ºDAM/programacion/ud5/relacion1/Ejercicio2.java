public class Ejercicio2 {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("Pepe", 29.00);
        System.out.println(cuenta1.saldo);
        cuenta1.depositar(200);
        System.out.println(cuenta1.saldo);
    }
}

class CuentaBancaria {
    String titular;
    double saldo;
    CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    void depositar(double cantidad) {
        saldo += cantidad;
    }
    void retirar(double cantidad) {
        if ((saldo - cantidad) > 0) {
            System.out.println("No tiene saldo para realizar esta operación");
        } else {
            saldo -= cantidad;
        }
    }
}