public class ValorArrecadacaoPorPraca {
    private String nomePraca;
    private double totalArrecadado;

    public ValorArrecadacaoPorPraca(String nomePraca) {
        this.nomePraca = nomePraca;
        this.totalArrecadado = 0.0;
    }

    public void adicionarValor(double valor) {
        this.totalArrecadado += valor;
    }

    public String getNomePraca() {
        return nomePraca;
    }

    public double getTotalArrecadado() {
        return totalArrecadado;
    }
}
