import java.util.List;
import java.util.*;

public class Campeonato implements CampeonatoInterface{
    private List<Time> times;
    private List<Partida> partidas;

    public Campeonato() {
        this.times = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }
    @Override
    public void cadastrarTime(String nome, String cidade) {
        Time time = new Time(nome, cidade);
        times.add(time);
        System.out.println("\nTime " + nome + " de " + cidade + " cadastrado com sucesso!");
    }

    @Override
    public void cadastrarJogadora(String nomeJogadora, int idade, String posicao, int nCamisa, String nomeTime) {
        // Busca o time na lista de time
        Time time = buscarTime(nomeTime);
        if (time != null) {
            Jogadora jogadora = new Jogadora(nomeJogadora, idade, posicao, nCamisa);
            time.adicionarJogadora(jogadora);
            System.out.println("\nJogadora " + nomeJogadora + " adicionada ao time " + nomeTime);
        } else {
            System.out.println("\nTime " + nomeTime + " não encontrado!");
        }
    }

    @Override
    public void registrarPartida(String time1, String time2, int golsTime1, int golsTime2) {
        // Busca os times na lista de times
        Time t1 = buscarTime(time1);
        Time t2 = buscarTime(time2);
        if (t1 != null && t2 != null) {
            Partida partida = new Partida(t1, golsTime1, t2, golsTime2);
            partida.registrarResultado();
            partidas.add(partida);
            System.out.println("\nPartida entre " + time1 + " e " + time2 + " registrada!");
        } else {
            System.out.println("\nUm dos times não foi encontrado.");
        }
    }

    @Override
    public void visualizarTabela() {
        System.out.println("\nTabela de Classificação:");
        times.sort((t1, t2) -> Integer.compare(t2.getPontos(), t1.getPontos()));
        for (Time time : times) {
            System.out.println(time.getNome() + " - " + time.getPontos() + " pontos");
        }
    }

    private Time buscarTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equals(nome)) {
                return time;
            }
        }
        return null;
    }

    // Metodo para acessar a lista de times (para testes)
    public List<Time> getTimes() {
        return times;
    }
}
