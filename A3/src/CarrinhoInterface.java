import java.util.List;
import java.util.Scanner;

public class CarrinhoInterface {
    private Carrinho carrinho;
    private Scanner scanner;

    public CarrinhoInterface() {
        this.carrinho = new Carrinho();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("Menu do Carrinho de Compras:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Verificar produto no carrinho");
            System.out.println("3. Listar todos os produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    verificarProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void adicionarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        Produto produto = new Produto(nome, preco);
        carrinho.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void verificarProduto() {
        System.out.print("Digite o nome do produto para verificar: ");
        String nome = scanner.nextLine();
        Produto produto = new Produto(nome, 0); // Preço não é relevante para verificação
        if (carrinho.contemProduto(produto)) {
            System.out.println("O produto está no carrinho.");
        } else {
            System.out.println("O produto não está no carrinho.");
        }
    }

    private void listarProdutos() {
        List<Produto> produtos = carrinho.getProdutos();
        if (produtos.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.println("Produtos no carrinho:");
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
            }
        }
    }

    public static void main(String[] args) {
        CarrinhoInterface ci = new CarrinhoInterface();
        ci.exibirMenu();
    }
}