package beatrizbonatto.com.repository;

import java.util.List;

import beatrizbonatto.com.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void registroProduto(Produto produto) {
        em.persist(produto);
    }

    public Produto consultaProduto(Long id) {
        return em.find(Produto.class, id);
    }

    @Transactional
    public List<Produto> listaDeProdutos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    @Transactional
    public void atualizar(Produto produto) {
        em.persist(produto);
    }

    @Transactional
    public void remocao(Long id) {
        Produto produto = consultaProduto(id);
        if (produto != null) {
            em.remove(produto);
        }
    }
}
