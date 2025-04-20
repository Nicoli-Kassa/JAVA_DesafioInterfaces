
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaPessoasComNecessidades implements SistemaInterface{
    private List<Pessoa> pessoas;

    public SistemaPessoasComNecessidades() {
        this.pessoas = new ArrayList<>();
    }

    // Adicionando pessoas a lista
    @Override
    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    // Adicionando atendimento
    @Override
    public void cadastrarAtendimento(String nomePessoa, Atendimento atendimento) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomePessoa)) {
                pessoa.adicionarAtendimento(atendimento);
                return;
            }
        }
        System.out.println("Pessoa não encontrada: " + nomePessoa);
    }

    // Listar atendimentos
    public List<Atendimento> listarAtendimentos(String nomePessoa) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomePessoa)) {
                return pessoa.getAtendimentos();
            }
        }
        return new ArrayList<>();
    }

    // Filtro
    @Override
    public List<Pessoa> filtro(String tipoDeficiencia, String grau) {
        return pessoas.stream()
                .filter(p -> p.getTipoDeficiencia().equalsIgnoreCase(tipoDeficiencia) && p.getGrau().equalsIgnoreCase(grau))
                .collect(Collectors.toList());
    }

    // Gerar relatório
    @Override
    public String gerarRelatorio(String nomePessoa) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomePessoa)) {
                StringBuilder relatorio = new StringBuilder("Relatório de Atendimentos para " + nomePessoa + ":\n");
                for (Atendimento atendimento : pessoa.getAtendimentos()) {
                    relatorio.append(atendimento.toString()).append("\n");
                }
                return relatorio.toString();
            }
        }
        return "Pessoa não encontrada.";
    }

    // GETTER
    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
