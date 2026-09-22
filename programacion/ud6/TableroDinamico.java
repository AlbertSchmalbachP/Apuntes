package programacion.ud6;

import java.util.ArrayList;

public class TableroDinamico {
    private int numFilas;
    private int numColum;
    private String valorInicial;

    private ArrayList<ArrayList<String>> tablero;

    public TableroDinamico(int numFilas, int numColum, String valorInicial) {
        this.numFilas = numFilas;
        this.numColum = numColum;
        this.valorInicial = valorInicial;

        this.tablero = new ArrayList<>();
        this.inicializarTablero();
    }

    // TODO Constructor de copia.

    public int getNumFilas() {
        return this.numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public int getNumColum() {
        return this.numColum;
    }

    public void setNumColum(int numColum) {
        this.numColum = numColum;
    }

    public String getValorInicial() {
        return this.valorInicial;
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = valorInicial;
    }

    private void inicializarTablero() {
        /*
         * for (int i = 0; i < numFilas; i++) {
         * for (int j = 0; j < numColum; j++) {
         * this.tablero[i][j] = valorInicial;
         * }
         * }
         */
        for (int i = 0; i < numFilas; i++) {
            ArrayList<String> fila = new ArrayList<>();
            for (int j = 0; j < numColum; j++) {
                fila.add(valorInicial);
            }
            tablero.add(fila);
        }
    }

    @Override
    public String toString() {
        String vistaTablero = "";

        /*
         * for (int i = 0; i < numFilas; i++) {
         * for (int j = 0; j < numColum; j++) {
         * vistaTablero += this.tablero.get(i).get(j) + " ";
         * }
         * vistaTablero += "\n";
         * }
         */

        for (ArrayList<String> fila : tablero) {
            for (String valor : fila) {
                vistaTablero += valor + " ";
            }
            vistaTablero += "\n";
        }
        return vistaTablero;
    }

    // public ArrayList<ArrayList<String>> copiarTablero
    // (ArrayList<ArrayList<String>> tablero){};
    // public void modificarPosicion (int i, int j, String nuevoValor){};
    // public void cambiarTamanioTablero (int nuevoTamaFilas, int nuevoTamaColum){}

    public static void main(String[] args) {

        TableroDinamico miTablero = new TableroDinamico(3, 3, "_");
        System.out.println(miTablero);
    }

}