
import java.util.List;
public class Main {
    public static void main(String[] args) {
        SistemaPedagioInterface sistema = new SistemaPedagio();

        /* +----------+
           | VEÍCULOS |
           +----------+ */

        // Criando e registrando veículos
        System.out.println("\n+--- Veículos Registrados ---+");
        Veiculo carro = new Veiculo("ABC1D23","Carro", 4);
        Veiculo moto = new Veiculo("XYZ4E56","Moto", 2);
        Veiculo caminhao = new Veiculo("JKL7F89" ,"Caminhão", 6);
        sistema.registrarVeiculo(carro);
        sistema.registrarVeiculo(moto);
        sistema.registrarVeiculo(caminhao);

        // Listar veículos
        List<Veiculo> listaVeiculos = sistema.listarVeiculos();
        for (Veiculo v : listaVeiculos) {
            System.out.println("Placa: " + v.getPlaca() + ", Tipo: " + v.getTipo());
        }

        /* +--------+
           | Praças |
           +--------+ */

        // Criando e registrando praças e passagens
        System.out.println("\n+--- Praças de Pedágios Registradas ---+");
        PracaPedagio praca1 = new PracaPedagio("Praça 1", 10.0);
        PracaPedagio praca2 = new PracaPedagio("Praça 2", 15.0);
        sistema.registrarPraca(praca1);
        sistema.registrarPraca(praca2);
        sistema.registrarPassagem(carro, praca1);
        sistema.registrarPassagem(moto, praca1);
        sistema.registrarPassagem(caminhao, praca2);

        // Listar praças de pedágio
        List<PracaPedagio> listaPracas = sistema.listarPracas();
        for (PracaPedagio p : listaPracas) {
            System.out.println("Nome: " + p.getLocalizacao() + ", Tarifa Base: " + p.getTarifaBase());
        }


         /* +-----------+
            | Relatório |
            +-----------+ */

        System.out.println("\n+--- Relatório ---+");
        List<RegistroPassagem> relatorioVeiculo = sistema.emitirRelatorio();
        List<ValorArrecadacaoPorPraca> relatorioArrecadacao = sistema.valorArrecadacaoPorPraca();

        for (RegistroPassagem registro : relatorioVeiculo) {
            System.out.println("Veículo: " + registro.getVeiculo().getTipo() + ", Valor: " + registro.getValorCobrado());
        }
        for (ValorArrecadacaoPorPraca relatorio : relatorioArrecadacao) {
            System.out.println("Praça: " + relatorio.getNomePraca() + ", Total Arrecadado: " + relatorio.getTotalArrecadado());
        }
    }
}