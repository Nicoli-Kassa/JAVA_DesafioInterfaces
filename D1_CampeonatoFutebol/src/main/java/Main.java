public class Main {
    public static void main(String[] args){
        /* +-----------+
           | DESAFIO 1 |
           +-----------+ */

        Campeonato campeonato = new Campeonato();

        // Cadastrando times
        System.out.println("\n+--- Cadastrando Times ---+");
        campeonato.cadastrarTime("Palmeiras Feminino", "São Paulo");
        campeonato.cadastrarTime("Internacional Feminino", "Porto Alegre");

        // Cadastrando jogadoras
        System.out.println("\n+--- Cadastrando Jogadoras ---+");
        campeonato.cadastrarJogadora("Bia Zaneratto", 30, "Atacante", 10, "Palmeiras Feminino");
        campeonato.cadastrarJogadora("Duda Sampaio", 23, "Meio-campo", 8, "Internacional Feminino");

        // Registrando partidas
        System.out.println("\n+--- Registrando partidas ---+");
        campeonato.registrarPartida("Palmeiras Feminino", "Internacional Feminino", 3, 0);
        campeonato.registrarPartida("Internacional Feminino", "Palmeiras Feminino", 2, 2);

        // Visualizar tabela de classificação
        campeonato.visualizarTabela();
    }
}
