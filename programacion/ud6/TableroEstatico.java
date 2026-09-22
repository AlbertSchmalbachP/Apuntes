package programacion.ud6;

public class TableroEstatico {
    private int numFilas;
    private int numColum;
    private String valorInicial;

    private String tablero[][];

    public TableroEstatico(int numFilas, int numColum, String valorInicial) {
        this.numFilas = numFilas;
        this.numColum = numColum;
        this.valorInicial = valorInicial;

        this.tablero = new String[numFilas][numColum];
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

    private void inicializarTablero(){
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColum; j++) {
                this.tablero[i][j] = valorInicial;
            }
        }
    }

    @Override
    public String toString() {
        String vistaTablero  = "";

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColum; j++) {
                vistaTablero += this.tablero[i][j] + " ";
            }
            vistaTablero += "\n";
        }
        return vistaTablero;
    }




    public static void main(String[] args) {
        
        TableroEstatico miTablero = new TableroEstatico(10, 20, "_");
        System.out.println(miTablero);
    }

    
}