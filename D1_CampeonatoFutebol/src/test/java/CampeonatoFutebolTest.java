import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CampeonatoFutebolTest {
    // Declarando o objeto Campeonato
    private Campeonato campeonato;

    // Metodo de configuração que é executado antes de cada teste
    @Before
    public void setUp() {
        campeonato = new Campeonato(); // Inicializa o objeto campeonato
    }

    // Testa o cadastro de times
    @Test
    public void testCadastrarTime() {
        campeonato.cadastrarTime("Time A", "Cidade A");
        campeonato.cadastrarTime("Time B", "Cidade B");

        // Verifica se os times foram cadastrados corretamente
        assertEquals(2, campeonato.getTimes().size());
        assertEquals("Time A", campeonato.getTimes().get(0).getNome());
        assertEquals("Time B", campeonato.getTimes().get(1).getNome());
    }

    // Testa o cadastro de jogadoras
    @Test
    public void testCadastrarJogadora() {
        campeonato.cadastrarTime("Time A", "Cidade A");
        campeonato.cadastrarJogadora("Jogadora 1", 25, "Atacante", 9, "Time A");

        // Verifica se a jogadora foi cadastrada corretamente
        Time time = campeonato.getTimes().get(0);
        assertEquals(1, time.getJogadoras().size());
        assertEquals("Jogadora 1", time.getJogadoras().get(0).getNome());
    }

    // Testa o registro de partidas
    @Test
    public void testRegistrarPartida() {
        campeonato.cadastrarTime("Time A", "Cidade A");
        campeonato.cadastrarTime("Time B", "Cidade B");
        campeonato.registrarPartida("Time A", "Time B", 2, 1);

        // Verifica os pontos após a partida
        Time timeA = campeonato.getTimes().get(0);
        Time timeB = campeonato.getTimes().get(1);
        assertEquals(3, timeA.getPontos());
        assertEquals(0, timeB.getPontos());
    }

    // Testa a visualização da tabela de classificação
    @Test
    public void testVisualizarTabela() {
        campeonato.cadastrarTime("Time A", "Cidade A");
        campeonato.cadastrarTime("Time B", "Cidade B");
        campeonato.registrarPartida("Time A", "Time B", 2, 1);

        // Verifica a ordem da tabela
        assertEquals("Time A", campeonato.getTimes().get(0).getNome());
        assertEquals("Time B", campeonato.getTimes().get(1).getNome());
    }

    // Testa o cadastro de jogadora em um time inexistente
    @Test
    public void testCadastrarJogadoraTimeInexistente() {
        campeonato.cadastrarJogadora("Jogadora 1", 25, "Atacante", 9, "Time Inexistente");

        // Verifica que nenhuma jogadora foi adicionada
        assertEquals(0, campeonato.getTimes().size());
    }
}