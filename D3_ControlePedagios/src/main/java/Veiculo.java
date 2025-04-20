public class Veiculo {
    private String placa;
    private String tipo;
    private int eixos;

    public Veiculo(String placa, String tipo, int eixos) {
        this.placa = placa;
        this.tipo = tipo;
        this.eixos = eixos;
    }

    // GETTERS
    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEixos() {
        return eixos;
    }

}
