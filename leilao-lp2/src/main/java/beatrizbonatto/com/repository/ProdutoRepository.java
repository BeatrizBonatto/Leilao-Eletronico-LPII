package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> listar() {
        return produtos;
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public void remover(Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }
}
