public class Ejercicio6 {
    public static void main(String[] args) {
        Reloj reloj1 = new Reloj(12, 38, 23);
        reloj1.sumarMinutos(54);
        reloj1.restarSegundos(28);
        System.out.println(reloj1);
    }
}
class Reloj {
    int hora;
    int minuto;
    int segundo;
    Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    void sumarMinutos(int minutos) {
        minuto += minutos;
        while (minuto >= 60) {
            minuto -= 60;
            hora++;
        }
    }
    void restarMinutos(int minutos) {
        minuto -= minutos;
        while (minuto < 0) {
            hora--;
            minuto = 0;
        }
    }
    void sumarSegundos(int segundos) {
        segundo += segundos;
        while (segundo >= 60) {
            segundo += 60;
            minuto++;
        }
    }
    void restarSegundos(int segundos) {
        segundo -= segundos;
        while (segundo < 0) {
            minuto--;
            segundo = 0;
        }
    }

    @Override
    public String toString() {
        return "Hora actual - " + hora + ":" + minuto + ":" + segundo;
    }
}