package beatrizbonatto.com.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Double cpf;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Date dataDeNascimento;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Long celular;

    public Cliente() {
    }
    
<<<<<<< HEAD
    public Cliente(String cpf, String nome, Date dataDeNascimento, String email, Long celular) {
=======
    public Cliente(Double cpf, String nome, Date dataDeNascimento, String email, Long celular) {
>>>>>>> d286b3afe8c2f17b34c12526380083a0d00724c4
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCpf() {
        return cpf;
    }

    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }
    
}