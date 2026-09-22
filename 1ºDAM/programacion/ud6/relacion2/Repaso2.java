package Tema6.Repaso.Repaso2;

import java.util.ArrayList;
import java.util.Arrays;

public class Repaso2 {
    public static double calcularRendimientoTotal(ArrayList<MiembroBanda> todos) {
        double rendimientoTotal = 0;

        for (MiembroBanda miembro : todos) {
            rendimientoTotal += miembro.calcularRendimiento();
        }

        return rendimientoTotal;
    }

    public static int calcularMiembrosDisponibles(ArrayList<MiembroBanda> todos) {
        int miembrosDisponibles = 0;

        for (MiembroBanda miembro : todos) {
            if (miembro.estaDisponible()) {
                miembrosDisponibles++;
            }
        }

        return miembrosDisponibles;
    }

    public static void mostrarRendimientoCadaGuitarrista(ArrayList<MiembroBanda> guitarristas) {
        for (MiembroBanda guitarrista : guitarristas) {
            System.out.println("El rendimiento del guitarrista " + guitarrista.getNombreArtistico() + " es de: "
                    + String.format("%.2f", guitarrista.calcularRendimiento()));
        }
    }

    public static void mostrarRendimientoCadaPianista(ArrayList<MiembroBanda> pianistas) {
        for (MiembroBanda pianista : pianistas) {
            System.out.println("El rendimiento del pianista " + pianista.getNombreArtistico() + " es de: "
                    + String.format("%.2f", pianista.calcularRendimiento()));
        }
    }

    public static void main(String[] args) {
        Guitarrista guitarrista1 = new Guitarrista("La Guitarra Loca", "Murcia", 2, 5, "Guitarra Eléctrica", 6, 3, 5, 4,
                8, 9, 11, 350);
        Guitarrista guitarrista2 = new Guitarrista("Melena Colosal", "Cáceres", 1, 3, "Bajo", 3, 4, 1, 2,
                6, 3, 7, 175.90);
        Guitarrista guitarrista3 = new Guitarrista("De Güaild Prollect", "Barcelona", 9, 69, "Ukelele", 10, 1, 13, 2,
                11, 20, 1, 75.90);
        Pianista pianista1 = new Pianista("Dedos Mágicos", "Albacete", 5, 10, "Piano", 10, 23, 19, 1, 7, 11, 600);
        Pianista pianista2 = new Pianista("Manos Rápidas", "Huelva", 2, 5, "Fortepiano", 9, 7, 8, 2, 3, 13, 575.80);
        MiembroBanda referencia1 = pianista1;
        Tocable referencia2 = guitarrista2;
        ArrayList<MiembroBanda> miembros = new ArrayList<>(
                Arrays.asList(guitarrista1, guitarrista2, pianista1, pianista2));
        ResponsableMusical responsableMusical = new ResponsableMusical("El Caudillo Musical", "La Coruña", 40, 1936,
                "No c", 5, 100, 69, miembros);
        ArrayList<MiembroBanda> todos = new ArrayList<>(
                Arrays.asList(guitarrista1, guitarrista2, guitarrista3, pianista1, pianista2, responsableMusical));
        ArrayList<MiembroBanda> pianistas = new ArrayList<>(Arrays.asList(referencia1, pianista2));
        ArrayList<MiembroBanda> guitarristas = new ArrayList<>(Arrays.asList(guitarrista1, guitarrista2, guitarrista3));

        guitarrista1.registrarEnsayo();
        guitarrista2.registrarEnsayo();
        pianista1.registrarEnsayo();
        pianista2.registrarEnsayo();

        guitarrista1.consumirActuacion();
        pianista1.consumirActuacion();

        guitarrista2.asignarInstrumento("Guitarra española", 100);
        pianista2.asignarInstrumento("Piano de cola", 200);
        pianista2.asignarInstrumento("Xilófono", 5);

        pianista2.retirarInstrumento("Xilófono", 5);

        responsableMusical.sumarPartiturasRevisadas();
        guitarrista1.sumarPartiturasRevisadas();
        guitarrista2.sumarPartiturasRevisadas();

        responsableMusical.sumarErroresDetectados(4);
        guitarrista2.sumarErroresDetectados(6);

        guitarrista1.prepararSolo();
        guitarrista2.prepararSolo();

        guitarrista1.corregirError();
        guitarrista2.corregirError();

        pianista1.prepararAcompanamiento();
        pianista2.prepararAcompanamiento();

        pianista1.aumentarPrecision(7);
        pianista2.aumentarPrecision(8);

        responsableMusical.asignarMiembro(guitarrista3);

        responsableMusical.quitarMiembro("Melena Colosal");

        guitarrista1.sumarPuntosBase(10);
        guitarrista2.sumarPuntosBase(21);
        guitarrista3.sumarPuntosBase(69);
        pianista1.sumarPuntosBase(33);
        pianista2.sumarPuntosBase(40);
        responsableMusical.sumarPuntosBase(39);

        System.out.println("El rendimiento del responsable musical es de: "
                + String.format("%.2f", responsableMusical.calcularRendimiento()));
        mostrarRendimientoCadaGuitarrista(guitarristas);
        mostrarRendimientoCadaPianista(pianistas);
        System.out.println("El responsable musical tiene a cargo: " + responsableMusical.getNumeroIntegrantesACargo()
                + " integrantes.");
        System.out.println(
                "El rendimiento total del equipo es: " + String.format("%.2f", calcularRendimientoTotal(miembros)));
        System.out
                .println("El rendimiento total de todos es: " + String.format("%.2f", calcularRendimientoTotal(todos)));
        System.out.println("EL número total de miembros disponibles es: " + calcularMiembrosDisponibles(todos));
    }
}