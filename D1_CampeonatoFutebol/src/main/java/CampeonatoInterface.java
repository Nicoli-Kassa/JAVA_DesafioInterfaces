
public interface CampeonatoInterface {
    void cadastrarTime(String nome, String cidade);
    void cadastrarJogadora(String nomeJogadora, int idade, String posicao, int numeroCamisa, String nomeTime);
    void registrarPartida(String time1, String time2, int golsTime1, int golsTime2);
    void visualizarTabela();
}