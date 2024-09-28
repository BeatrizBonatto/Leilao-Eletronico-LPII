package beatrizbonatto.com.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Leilao {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate data;
    private String local;
    private String status;
    
    public Leilao(Long id, LocalDate data, String local, String status) {
        this.id = id;
        this.data = data;
        this.local = local;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
