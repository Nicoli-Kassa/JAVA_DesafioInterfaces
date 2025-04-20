import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class ControlePedagioTest {
    private SistemaPedagioInterface sistema;
    private Veiculo carro;
    private Veiculo moto;
    private Veiculo caminhao;
    private PracaPedagio praca1;
    private PracaPedagio praca2;

    @Before
    public void setUp() {
        sistema = new SistemaPedagio();
        carro = new Veiculo("ABC1D23", "Carro", 4);
        moto = new Veiculo("XYZ4E56", "Moto", 2);
        caminhao = new Veiculo("JKL7F89", "Caminhão", 6);
        praca1 = new PracaPedagio("Praça 1", 10.0);
        praca2 = new PracaPedagio("Praça 2", 15.0);

        sistema.registrarVeiculo(carro);
        sistema.registrarVeiculo(moto);
        sistema.registrarVeiculo(caminhao);
        sistema.registrarPraca(praca1);
        sistema.registrarPraca(praca2);
    }

    // Teste do calculo do pedágio do carro
    @Test
    public void testCalcularValorCarro() {
        double valor = sistema.calcularValor(carro, praca1);
        assertEquals(10.0, valor, 0.01);
    }

    // Teste do calculo do pedágio da moto
    @Test
    public void testCalcularValorMoto() {
        double valor = sistema.calcularValor(moto, praca1);
        assertEquals(5.0, valor, 0.01);
    }


    // Teste do calculo do pedágio do caminhão
    @Test
    public void testCalcularValorCaminhao() {
        double valor = sistema.calcularValor(caminhao, praca2);
        assertEquals(90.0, valor, 0.01); // 15.0 * 6 eixos
    }

    // Teste para registrar passagem
    @Test
    public void testRegistrarPassagem() {
        sistema.registrarPassagem(carro, praca1);
        List<RegistroPassagem> relatorio = sistema.emitirRelatorio();
        assertEquals(1, relatorio.size());
        assertEquals(carro, relatorio.get(0).getVeiculo());
        assertEquals(praca1, relatorio.get(0).getPraca());
        assertEquals(10.0, relatorio.get(0).getValorCobrado(), 0.01);
    }

    // Teste do calculo do valor arrecadado por cada praço
    @Test
    public void testValorArrecadacaoPorPraca() {
        sistema.registrarPassagem(carro, praca1);
        sistema.registrarPassagem(moto, praca1);
        sistema.registrarPassagem(caminhao, praca2);

        List<ValorArrecadacaoPorPraca> valorArrecadacaoPorPraca = sistema.valorArrecadacaoPorPraca();
        assertEquals(2, valorArrecadacaoPorPraca.size());

        assertEquals("Praça 1", valorArrecadacaoPorPraca.get(0).getNomePraca());
        assertEquals(15.0, valorArrecadacaoPorPraca.get(0).getTotalArrecadado(), 0.01);

        assertEquals("Praça 2", valorArrecadacaoPorPraca.get(1).getNomePraca());
        assertEquals(90.0, valorArrecadacaoPorPraca.get(1).getTotalArrecadado(), 0.01);
    }
}