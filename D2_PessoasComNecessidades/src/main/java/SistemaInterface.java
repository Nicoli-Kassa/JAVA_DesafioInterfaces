import java.util.List;

public interface SistemaInterface {
    void cadastrarPessoa(Pessoa pessoa);
    void cadastrarAtendimento(String nomePessoa, Atendimento atendimento);
    List<Pessoa> filtro(String tipoDeficiencia, String grau);
    String gerarRelatorio(String nomePessoa);
}