package beatrizbonatto.com.model;

import java.time.LocalDateTime;

public class Leilao {
    private Long id;
    private LocalDateTime dataOcorrencia;
    private LocalDateTime dataVisitacao;
    private String local;

    public Leilao(Long id, LocalDateTime dataOcorrencia, LocalDateTime dataVisitacao, String local) {
        this.id = id;
        this.dataOcorrencia = dataOcorrencia;
        this.dataVisitacao = dataVisitacao;
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDateTime dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public LocalDateTime getDataVisitacao() {
        return dataVisitacao;
    }

    public void setDataVisitacao(LocalDateTime dataVisitacao) {
        this.dataVisitacao = dataVisitacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

}
