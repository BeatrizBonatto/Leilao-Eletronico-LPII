package beatrizbonatto.com.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.impl.PackedCoordinateSequence.Double;

import java.util.List;

@Entity
public class InstFinanceira {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long codigo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double cnpj;

    @ManyToMany
    List<Leilao> leilaos;
    
    public InstFinanceira() {
    }

    public InstFinanceira(Long codigo, String nome, Double cnpj) {
        this.codigo = codigo;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCnpj() {
        return cnpj;
    }

    public void setCnpj(Double cnpj) {
        this.cnpj = cnpj;
    }

}
