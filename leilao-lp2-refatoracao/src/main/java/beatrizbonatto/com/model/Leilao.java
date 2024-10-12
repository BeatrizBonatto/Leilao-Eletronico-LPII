package beatrizbonatto.com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Leilao {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    @Column(nullable = false)
    private LocalDateTime dataVisitacao;

    @Column(nullable = false)
    private LocalDateTime dataEvento;

    @Column(nullable = false)
    private String dominioLeilaoEletronico;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String status;

    @OneToMany
    private List<Produto> produtos = new ArrayList<>();

<<<<<<< HEAD
    //@ManyToMany
    //private InstFinanceira instFinanceira;
=======
    @ManyToMany
    private InstFinanceira instFinanceira;
>>>>>>> d286b3afe8c2f17b34c12526380083a0d00724c4

    public Leilao() {
    }

    public Leilao(Long id, LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataVisitacao,
            LocalDateTime dataEvento, String dominioLeilaoEletronico, String endereco, String cidade,
            String estado, String status, List<Produto> produtos, InstFinanceira instFinanceira) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataVisitacao = dataVisitacao;
        this.dataEvento = dataEvento;
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.status = status;
        this.produtos = produtos;
<<<<<<< HEAD
        //this.instFinanceira = instFinanceira;
=======
        this.instFinanceira = instFinanceira;
>>>>>>> d286b3afe8c2f17b34c12526380083a0d00724c4
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDateTime getDataVisitacao() {
        return dataVisitacao;
    }

    public void setDataVisitacao(LocalDateTime dataVisitacao) {
        this.dataVisitacao = dataVisitacao;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDominioLeilaoEletronico() {
        return dominioLeilaoEletronico;
    }

    public void setDominioLeilaoEletronico(String dominioLeilaoEletronico) {
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

<<<<<<< HEAD
    /*public InstFinanceira getInstFinanceira() {
=======
    public InstFinanceira getInstFinanceira() {
>>>>>>> d286b3afe8c2f17b34c12526380083a0d00724c4
        return instFinanceira;
    }

    public void setInstFinanceira(InstFinanceira instFinanceira) {
        this.instFinanceira = instFinanceira;
<<<<<<< HEAD
    }*/
=======
    }
>>>>>>> d286b3afe8c2f17b34c12526380083a0d00724c4
}
