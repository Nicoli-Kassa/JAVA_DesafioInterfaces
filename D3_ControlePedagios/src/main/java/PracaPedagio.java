public class PracaPedagio {
    private String localizacao;
    private double tarifaBase;

    public PracaPedagio(String localizacao, double tarifaBase) {
        this.localizacao = localizacao;
        this.tarifaBase = tarifaBase;
    }

    //GETTERS
    public String getLocalizacao() {
        return localizacao;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }
}