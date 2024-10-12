package beatrizbonatto.com.repository;

import java.util.List;

import beatrizbonatto.com.model.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteRepository {
    public static List<Cliente> listaDeClientes;
    
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void registroCliente(Cliente cliente) {
        em.persist(cliente);
    }

    public Cliente consultaCliente(Long id) {
        return em.find(Cliente.class, id);
    }

    @Transactional
    public List<Cliente> listaDeClientes() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Transactional
    public void atualizar(Cliente cliente) {
        em.persist(cliente);
    }

    @Transactional
    public void remocao(Long id) {
        Cliente cliente = consultaCliente(id);
        if (cliente != null) {
            em.remove(cliente);
        }
    }
}
