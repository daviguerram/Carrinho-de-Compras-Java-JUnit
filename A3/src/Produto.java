public class Produto {
    private String nome;
    private double preco;

    // Construtor da classe Produto
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Método para obter o nome do produto
    public String getNome() {
        return nome;
    }

    // Método para obter o preço do produto
    public double getPreco() {
        return preco;
    }
}
