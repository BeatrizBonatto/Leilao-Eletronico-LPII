package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoRepository {
    @Inject
    EntityManager em;

    @Transactional
    public void addProduto(Produto produto) {
        em.persist(produto);
    }
}
