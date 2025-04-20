import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;
    private String tipoDeficiencia;
    private String grau;
    private String endereco;
    private List<Atendimento> atendimentos;

    public Pessoa(String nome, int idade, String tipoDeficiencia, String grau, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.tipoDeficiencia = tipoDeficiencia;
        this.grau = grau;
        this.endereco = endereco;
        this.atendimentos = new ArrayList<>();
    }

    // Adicionando atendimento a lista
    public void adicionarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public String getGrau() {
        return grau;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Idade: " + idade +
                " | Tipo Deficiencia: " + tipoDeficiencia +
                " | Grau: " + grau +
                " | Endereco: " + endereco;
    }
}
