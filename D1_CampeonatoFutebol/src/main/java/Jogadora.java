public class Jogadora{
    private String nome;
    private int idade;
    private String posicao;
    private int nCamisa;

    public Jogadora(String nome, int idade, String posicao, int nCamisa) {
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
        this.nCamisa = nCamisa;
    }

    // Getter
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return nome + " (" + idade + " anos) | Camisa: "+ nCamisa + " | Posição: " + posicao;
    }
}
