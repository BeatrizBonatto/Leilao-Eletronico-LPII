package beatrizbonatto.com.model;

import org.locationtech.jts.geom.impl.PackedCoordinateSequence.Double;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class InstFinanceira {
    @Id
    @GeneratedValue
    private Long id;
    private Long codigo;
    private String nome;
    private Double cnpj;
    
    public InstFinanceira() {
    }

    public InstFinanceira(Long id ,Long codigo, String nome, Double cnpj) {
        this.id = id;
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
