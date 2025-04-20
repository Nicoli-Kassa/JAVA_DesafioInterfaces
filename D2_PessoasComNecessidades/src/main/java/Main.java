import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SistemaPessoasComNecessidades sistemaPCN = new SistemaPessoasComNecessidades();

        // Criando e cadastrando pessoas
        Pessoa pessoa1 = new Pessoa("João", 30, "Deficiência Visual", "Moderado", "Rua A, 123");
        Pessoa pessoa2 = new Pessoa("Maria", 25, "Deficiência Auditiva", "Leve", "Rua B, 456");
        Pessoa pessoa3 = new Pessoa("Laura", 18, "Deficiência Auditiva", "Leve", "Rua C, 653");
        sistemaPCN.cadastrarPessoa(pessoa1);
        sistemaPCN.cadastrarPessoa(pessoa2);
        sistemaPCN.cadastrarPessoa(pessoa3);

        // Listando todas as pessoas cadastradas
        System.out.println("\n+--- Pessoas cadastradas ---+");
        for (Pessoa pessoa : sistemaPCN.getPessoas()) {
            System.out.println(pessoa);
        }

        // Cadastrando atendimentos
        sistemaPCN.cadastrarAtendimento("João", new Atendimento(LocalDate.of(2023, 10, 1), "Fisioterapia", "Dr. Silva"));
        sistemaPCN.cadastrarAtendimento("João", new Atendimento(LocalDate.of(2023, 10, 15), "Terapia Ocupacional", "Dra. Ana"));
        sistemaPCN.cadastrarAtendimento("Maria", new Atendimento(LocalDate.of(2023, 10, 5), "Psicologia", "Dr. Carlos"));

        // Listando atendimentos de uma pessoa específica
        System.out.println("\n+--- Atendimentos de Maria ---+");
        for (Atendimento atendimento : sistemaPCN.listarAtendimentos("Maria")) {
            System.out.println(atendimento);
        }

        // Listando pessoas por tipo de deficiência e grau
        System.out.println("\n+--- Pessoas com Deficiência Auditiva e grau Leve ---+");
        sistemaPCN.filtro("Deficiência Auditiva", "Leve").forEach(System.out::println);

        // Gerando relatório de atendimentos
        System.out.println("\n+--- Relatórios ---+\n");
        System.out.println(sistemaPCN.gerarRelatorio("João"));
        System.out.println(sistemaPCN.gerarRelatorio("Maria"));
        System.out.println(sistemaPCN.gerarRelatorio("Laura"));
    }
}