package programacion.ud4.pttojava;
import java.util.Scanner;
public class PT1 {
    public static void main(String[] args) {
        // declara las variables
        int encargosTotales;
        int stockMadera;
        double stockAcero;
        int encargoActual = 0;
        String articulo;
        int unidadesArticulo;
        int maderaGastada;
        double aceroGastado;
        int monedasGastadas;
        int maderaAcumulada = 0;
        double aceroAcumulado = 0;
        int gastoMonedasAcumulado = 0;
        int unidadesFlechaCompradas = 0;
        int unidadesEscudoCompradas = 0;
        int unidadesEspadaCompradas = 0;
        boolean stockSuperado = false;
        final int GASTOMADERAFLECHA = 1;
        final double GASTOACEROFLECHA = 0.05;
        final int GASTOMONEDASFLECHA = 2;
        final int GASTOMADERAESPADA = 1;
        final double GASTOACEROESPADA = 1.2;
        final int GASTOMONEDASESPADA = 25;
        final int GASTOMADERAESCUDO = 3;
        final double GASTOACEROESCUDO = 1.5;
        final int GASTOMONEDASESCUDO = 30;
        // crea un escaner
        Scanner scanner1 = new Scanner(System.in);
        // pregunta al usuario por los datos
        System.out.print("Número de encargos: ");
        encargosTotales = scanner1.nextInt();
        System.out.print("Stock de madera (varas): ");
        stockMadera = scanner1.nextInt();
        System.out.print("Stock de acero (kg): ");
        stockAcero = scanner1.nextDouble();
        // bucle para los encargos
        while ((encargosTotales - encargoActual != 0) && !stockSuperado) {
            encargoActual++;
            System.out.println("--- Encargo " + encargoActual + " ---");
            // pide el tipo de articulo al usuario
            System.out.print("Indique el artículo a comprar (flecha, espada, escudo): ");
            articulo = scanner1.next();
            // control de errores para el tipo de articulo
            while (!articulo.equalsIgnoreCase("flecha") && !articulo.equalsIgnoreCase("espada") && !articulo.equalsIgnoreCase("escudo")) {
                System.out.print("¡No se ha introducido un tipo válido! Indique el artículo a comprar (flecha, espada, escudo): ");
                articulo = scanner1.next();
            }
            // pide las unidades del articulo elegido
            System.out.print("Indique el número de unidades a comprar: ");
            unidadesArticulo = scanner1.nextInt();
            scanner1.nextLine(); // limpia el buffer
            // control de errores para las unidades negativas
            while (unidadesArticulo < 0) {
                System.out.print("¡No se pueden comprar unidades negativas! Indique el número de unidades a comprar: ");
                unidadesArticulo = scanner1.nextInt();
                scanner1.nextLine(); // limpia el buffer
            }
            // asigna un gasto dependiendo del articulo
            if (articulo.equalsIgnoreCase("flecha")) {
                maderaGastada = GASTOMADERAFLECHA * unidadesArticulo;
                aceroGastado = GASTOACEROFLECHA * unidadesArticulo;
                monedasGastadas = GASTOMONEDASFLECHA * unidadesArticulo;
                unidadesFlechaCompradas += unidadesArticulo;
            } else if (articulo.equalsIgnoreCase("espada")) {
                maderaGastada = GASTOMADERAESPADA * unidadesArticulo;
                aceroGastado = GASTOACEROESPADA * unidadesArticulo;
                monedasGastadas = GASTOMONEDASESPADA * unidadesArticulo;
                unidadesEspadaCompradas += unidadesArticulo;
            } else {
                maderaGastada = GASTOMADERAESCUDO * unidadesArticulo;
                aceroGastado = GASTOACEROESCUDO * unidadesArticulo;
                monedasGastadas = GASTOMONEDASESCUDO * unidadesArticulo;
                unidadesEscudoCompradas += unidadesArticulo;
            }
            // suma el stock y comprueba si es negativo, alertando al usuario si es así y devolviendo el stock gastado
            stockMadera -= maderaGastada;
            stockAcero -= aceroGastado;
            if (stockMadera < 0) {
                System.out.println("¡ALERTA! Has superado el stock de madera.");
                stockSuperado = true;
                encargoActual--;
                stockMadera += maderaGastada;
                stockAcero += aceroGastado;
            } else if (stockAcero < 0) {
                System.out.println("¡ALERTA! Has superado el stock de acero.");
                stockSuperado = true;
                encargoActual--;
                stockMadera += maderaGastada;
                stockAcero += aceroGastado;
            } else {
                // suma el resto de los gastos si pasa las comprobaciones
                maderaAcumulada += maderaGastada;
                aceroAcumulado += aceroGastado;
                gastoMonedasAcumulado += monedasGastadas;
                // imprimir resultados de la compra
                System.out.println("Artículo: " + articulo + " | Unidades: " + unidadesArticulo + " | Importe cobrado: " + monedasGastadas);
                System.out.println("Madera gastada: " + maderaGastada + " | Acumulada: " + maderaAcumulada);
                System.out.printf("Acero gastado: %.2f | Acumulado: %.2f\n", aceroGastado, aceroAcumulado);
            }
        }
        // cierra el escaner
        scanner1.close();
        // muestra el resumen final
        System.out.println("--- RESUMEN FINAL ---");
        System.out.println("Encargos registrados: " + encargoActual + " de " + encargosTotales);
        System.out.println("Unidades -> Flecha: " + unidadesFlechaCompradas + " | Escudo: " + unidadesEscudoCompradas + " | Espada: " + unidadesEspadaCompradas);
        System.out.printf("Consumo total -> Madera: %d | Acero: %.2f\n", maderaAcumulada, aceroAcumulado);
        System.out.printf("Stock restante -> Madera: %d | Acero: %.2f\n", stockMadera, stockAcero);
        System.out.println("Importe total: " + gastoMonedasAcumulado);
        // dependiendo del motivo del fin del programa, muestra un u otro mensaje
        if (!stockSuperado) {
            System.out.println("Registro completado con éxito.");
        } else {
            System.out.println("Registro interrumpido por superación de stock.");
        }
    }
}
