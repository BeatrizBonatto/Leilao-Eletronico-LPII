package beatrizbonatto.com.repository;

import java.util.List;

import beatrizbonatto.com.model.InstFinanceira;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InstFinanceiraRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void registroInstFinanceira(InstFinanceira instFinanceira) {
        em.persist(instFinanceira);
    }

    public InstFinanceira consultaInstFinanceira(Long id) {
        return em.find(InstFinanceira.class, id);
    }

    @Transactional
    public List<InstFinanceira> listaDeInstFinanceiras() {
        return em.createQuery("SELECT if FROM InstFinanceira if", InstFinanceira.class).getResultList();
    }

    @Transactional
    public void atualizar(InstFinanceira instFinanceira) {
        em.persist(instFinanceira);
    }

    @Transactional
    public void remocao(Long id) {
        InstFinanceira instFinanceira = consultaInstFinanceira(id);
        if (instFinanceira != null) {
            em.remove(instFinanceira);
        }
    }
}
