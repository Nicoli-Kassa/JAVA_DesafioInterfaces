import java.util.List;
import java.util.ArrayList;

public class SistemaPedagio implements SistemaPedagioInterface{
    private List<RegistroPassagem> registros;
    private List<Veiculo> veiculos;
    private List<PracaPedagio> pracas;

    public SistemaPedagio() {
        this.registros = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.pracas = new ArrayList<>();
    }


    // Calcular valor
    @Override
    public double calcularValor(Veiculo veiculo, PracaPedagio praca) {
        double tarifaBase = praca.getTarifaBase();
        switch (veiculo.getTipo().toLowerCase()) {
            case "carro":
                return tarifaBase;
            case "moto":
                return tarifaBase * 0.5;
            case "caminhão":
                return tarifaBase * veiculo.getEixos();
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido");
        }
    }

    // Registrar Passagem
    @Override
    public void registrarPassagem(Veiculo veiculo, PracaPedagio praca) {
        double valorCobrado = calcularValor(veiculo, praca);
        RegistroPassagem registro = new RegistroPassagem(veiculo, praca, valorCobrado);
        registros.add(registro);
    }

    // Adicionar veiculo a lista
    @Override
    public void registrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    // Adicionar praça a lista
    @Override
    public void registrarPraca(PracaPedagio praca) {
        pracas.add(praca);
    }

    // Listar veiculos
    @Override
    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    // Listar praças
    @Override
    public List<PracaPedagio> listarPracas() {
        return pracas;
    }

    // Emitir relatório
    @Override
    public List<RegistroPassagem> emitirRelatorio() {
        return registros;
    }

    // Valor Arrecadado por praça para mostrar no relatório
    @Override
    public List<ValorArrecadacaoPorPraca> valorArrecadacaoPorPraca() {
        List<ValorArrecadacaoPorPraca> relatorios = new ArrayList<>();
        for (PracaPedagio praca : pracas) {
            ValorArrecadacaoPorPraca relatorio = new ValorArrecadacaoPorPraca(praca.getLocalizacao());
            for (RegistroPassagem registro : registros) {
                if (registro.getPraca().getLocalizacao().equals(praca.getLocalizacao())) {
                    relatorio.adicionarValor(registro.getValorCobrado());
                }
            }
            relatorios.add(relatorio);
        }
        return relatorios;
    }
}
