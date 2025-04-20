import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private String cidade;
    private List<Jogadora> jogadoras = new ArrayList<>();
    private int pontos = 0;

    public Time(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public void adicionarJogadora(Jogadora jogadora){
        jogadoras.add(jogadora);
    }

    public void calcularPontos(int vitorias, int empates) {
        this.pontos = vitorias * 3 + empates;
    }

    // GETTERS
    public String getNome() { return nome; }
    public int getPontos() { return pontos; }

    @Override
    public String toString(){
        return nome + " - " + cidade;
    }

    // Metodo para acessar a lista de jogadoras (para testes)
    public List<Jogadora> getJogadoras() {
        return jogadoras;
    }
}
