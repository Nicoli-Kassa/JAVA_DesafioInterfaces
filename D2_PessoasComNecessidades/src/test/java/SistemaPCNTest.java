import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.*;

public class SistemaPCNTest {
    private SistemaPessoasComNecessidades sistema;

    @Before
    public void setUp() {
        sistema = new SistemaPessoasComNecessidades();
    }

    // Teste de cadastro de pessoas
    @Test
    public void testCadastrarPessoa() {
        Pessoa pessoa = new Pessoa("João", 30, "Deficiência Visual", "Moderado", "Rua A, 123");
        sistema.cadastrarPessoa(pessoa);

        // Verifica se a pessoa foi cadastrada corretamente
        assertEquals(1, sistema.getPessoas().size());
        assertEquals("João", sistema.getPessoas().get(0).getNome());
    }

    // Teste de cadastro de atendimentos
    @Test
    public void testCadastrarAtendimento() {
        Pessoa pessoa = new Pessoa("Maria", 25, "Deficiência Auditiva", "Leve", "Rua B, 456");
        sistema.cadastrarPessoa(pessoa);

        Atendimento atendimento = new Atendimento(LocalDate.of(2023, 10, 5), "Psicologia", "Dr. Carlos");
        sistema.cadastrarAtendimento("Maria", atendimento);

        // Verifica se o atendimento foi cadastrado corretamente
        List<Atendimento> atendimentos = sistema.listarAtendimentos("Maria");
        assertEquals(1, atendimentos.size());
        assertEquals("Psicologia", atendimentos.get(0).getTipo());
    }

    // Teste do filtro
    @Test
    public void testFiltro() {
        Pessoa pessoa1 = new Pessoa("João", 30, "Deficiência Visual", "Moderado", "Rua A, 123");
        Pessoa pessoa2 = new Pessoa("Maria", 25, "Deficiência Auditiva", "Leve", "Rua B, 456");
        sistema.cadastrarPessoa(pessoa1);
        sistema.cadastrarPessoa(pessoa2);

        // Filtra pessoas com deficiência auditiva e grau leve
        List<Pessoa> resultado = sistema.filtro("Deficiência Auditiva", "Leve");
        assertEquals(1, resultado.size());
        assertEquals("Maria", resultado.get(0).getNome());
    }

    // Teste para gerar o relatório
    @Test
    public void testGerarRelatorio() {
        Pessoa pessoa = new Pessoa("João", 30, "Deficiência Visual", "Moderado", "Rua A, 123");
        sistema.cadastrarPessoa(pessoa);
        sistema.cadastrarAtendimento("João", new Atendimento(LocalDate.of(2023, 10, 1), "Fisioterapia", "Dr. Silva"));

        String relatorio = sistema.gerarRelatorio("João");
        assertTrue(relatorio.contains("Relatório de Atendimentos para João"));
        assertTrue(relatorio.contains("Fisioterapia"));
    }

    // Teste para listar os atendimentos
    @Test
    public void testListarAtendimentos() {
        Pessoa pessoa = new Pessoa("Maria", 25, "Deficiência Auditiva", "Leve", "Rua B, 456");
        sistema.cadastrarPessoa(pessoa);
        sistema.cadastrarAtendimento("Maria", new Atendimento(LocalDate.of(2023, 10, 5), "Psicologia", "Dr. Carlos"));

        List<Atendimento> atendimentos = sistema.listarAtendimentos("Maria");
        assertEquals(1, atendimentos.size());
        assertEquals("Psicologia", atendimentos.get(0).getTipo());
    }

}
