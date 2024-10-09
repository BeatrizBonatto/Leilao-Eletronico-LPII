package beatrizbonatto.com.repository;

import java.util.List;

import beatrizbonatto.com.model.DispInformatica;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DispInformaticaRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void registroDispInformatica(DispInformatica dispInformatica) {
        em.persist(dispInformatica);
    }

    public DispInformatica consultaDispInformatica(Long id) {
        return em.find(DispInformatica.class, id);
    }

    @Transactional
    public List<DispInformatica> listaDeDispInformaticas() {
        return em.createQuery("SELECT dp FROM DispInformatica dp", DispInformatica.class).getResultList();
    }

    @Transactional
    public void atualizar(DispInformatica dispInformatica) {
        em.persist(dispInformatica);
    }

    @Transactional
    public void remocao(Long id) {
        DispInformatica dispInformatica = consultaDispInformatica(id);
        if (dispInformatica != null) {
            em.remove(dispInformatica);
        }
    }
}
