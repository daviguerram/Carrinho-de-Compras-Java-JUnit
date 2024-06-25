import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;
    private int limiteEstoque;

    public Carrinho() {
        this.produtos = new ArrayList<>();
        this.limiteEstoque = 5; // Definindo o limite de estoque para 5
    }

    // Método para adicionar um produto ao carrinho
    public void adicionarProduto(Produto produto) {
        // Verifica se o estoque já está no limite
        if (produtos.size() >= limiteEstoque) {
            System.out.println("Estoque insuficiente. Não é possível adicionar mais produtos.");
            return;
        }

        // Adiciona o produto ao carrinho se o preço for maior que 0 e o produto não for
        // nulo
        if (produto != null && produto.getPreco() > 0) {
            this.produtos.add(produto);
        }
    }

    // Método para verificar se o carrinho contém um determinado produto com base no
    // nome
    public boolean contemProduto(Produto produto) {
        // Verifica se o produto fornecido não é nulo e se a lista de produtos contém um
        // produto com o mesmo nome
        return produto != null && produtos.stream().anyMatch(p -> p.getNome().equals(produto.getNome()));
    }

    // Método para obter a lista de produtos no carrinho
    public List<Produto> getProdutos() {
        return produtos;
    }
}
