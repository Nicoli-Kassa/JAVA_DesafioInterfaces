public class Partida {
    private Time time1;
    private Time time2;
    private int golsTime1;
    private int golsTime2;

    public Partida(Time time1, int golsTime1, Time time2, int golsTime2) {
        this.time1 = time1;
        this.golsTime1 = golsTime1;
        this.time2 = time2;
        this.golsTime2 = golsTime2;
    }

    public void registrarResultado() {
        if (golsTime1 > golsTime2) {
            time1.calcularPontos(1, 0);
            time2.calcularPontos(0, 0);
        } else if (golsTime1 < golsTime2) {
            time1.calcularPontos(0, 0);
            time2.calcularPontos(1, 0);
        } else {
            time1.calcularPontos(0, 1);
            time2.calcularPontos(0, 1);
        }
    }
}
