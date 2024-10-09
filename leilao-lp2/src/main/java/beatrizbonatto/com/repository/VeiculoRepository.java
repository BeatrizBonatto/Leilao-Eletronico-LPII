package beatrizbonatto.com.repository;

import java.util.List;

import beatrizbonatto.com.model.Veiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VeiculoRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void registroVeiculo(Veiculo veiculo) {
        em.persist(veiculo);
    }

    public Veiculo consultaVeiculo(Long id) {
        return em.find(Veiculo.class, id);
    }

    @Transactional
    public List<Veiculo> listaDeVeiculos() {
        return em.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
    }

    @Transactional
    public void atualizar(Veiculo veiculo) {
        em.persist(veiculo);
    }

    @Transactional
    public void remocao(Long id) {
        Veiculo veiculo = consultaVeiculo(id);
        if (veiculo != null) {
            em.remove(veiculo);
        }
    }
}
