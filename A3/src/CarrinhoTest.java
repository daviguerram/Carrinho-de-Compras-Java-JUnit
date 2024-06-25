import static org.junit.Assert.*;
import org.junit.*;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    public void testAdicionarProdutoComSucesso() {
        Produto produto = new Produto("Produto Teste", 10.0);
        carrinho.adicionarProduto(produto);
        assertTrue(carrinho.contemProduto(produto));
    }

    @Test
    public void testAdicionarVariosProdutosAoCarrinho() {
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        Produto produto3 = new Produto("Produto 3", 30.0);

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);
        carrinho.adicionarProduto(produto3);

        assertTrue(carrinho.contemProduto(produto1));
        assertTrue(carrinho.contemProduto(produto2));
        assertTrue(carrinho.contemProduto(produto3));
    }

    @Test
    public void testAdicionarCincoProdutos() {
        // Adiciona cinco produtos ao carrinho
        for (int i = 1; i <= 5; i++) {
            Produto produto = new Produto("Produto " + i, 10.0 * i);
            carrinho.adicionarProduto(produto);
            assertTrue("Produto " + i + " não está no carrinho.", carrinho.contemProduto(produto));
        }

        // Tenta adicionar um sexto produto
        Produto sextoProduto = new Produto("Produto 6", 60.0);
        carrinho.adicionarProduto(sextoProduto);

        // Verifica se o sexto produto não foi adicionado ao carrinho
        assertFalse("O sexto produto foi adicionado ao carrinho, mas deveria ter sido limitado a 5 produtos.",
                carrinho.contemProduto(sextoProduto));

        // Verifica se o carrinho ainda contém apenas cinco produtos
        assertEquals("O número de produtos no carrinho não é igual a 5.", 5, carrinho.getProdutos().size());
    }
}
