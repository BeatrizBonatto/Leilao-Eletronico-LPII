package beatrizbonatto.com.repository;

import java.util.List;

import beatrizbonatto.com.model.Leilao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LeilaoRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void registroLeilao(Leilao leilao) {
        em.persist(leilao);
    }

    public Leilao consultaLeilao(Long id) {
        return em.find(Leilao.class, id);
    }

    @Transactional
    public List<Leilao> listaDeLeiloes() {
        return em.createQuery("SELECT l FROM Leilao l", Leilao.class).getResultList();
    }

    @Transactional
    public void atualizar(Leilao Leilao) {
        em.persist(Leilao);
    }

    @Transactional
    public void remocao(Long id) {
        Leilao Leilao = consultaLeilao(id);
        if (Leilao != null) {
            em.remove(Leilao);
        }
    }
}
