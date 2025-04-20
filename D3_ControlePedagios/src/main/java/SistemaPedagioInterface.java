import java.util.List;
public interface SistemaPedagioInterface {
    // Calcular Valor
    double calcularValor(Veiculo veiculo, PracaPedagio praca);

    // Registrar Passagem
    void registrarPassagem(Veiculo veiculo, PracaPedagio praca);

    // Emitir relatório
    List<RegistroPassagem> emitirRelatorio();

    // Valor arrecadados pro cda praça
    List<ValorArrecadacaoPorPraca> valorArrecadacaoPorPraca();

    // Registrar veiculo
    void registrarVeiculo(Veiculo veiculo);

    // Registrar praça
    void registrarPraca(PracaPedagio praca);

    // Listar veiculos
    List<Veiculo> listarVeiculos();

    // Listar praças de pedágios
    List<PracaPedagio> listarPracas();

}