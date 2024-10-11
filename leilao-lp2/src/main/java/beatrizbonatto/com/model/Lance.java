package beatrizbonatto.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Lance {
    @Id
    @GeneratedValue
    private int id;

    private Cliente cliente;


    private Produto produto;

    @JoinColumn(referencedColumnName = "leilao_id")
    private Leilao leilao;
}
