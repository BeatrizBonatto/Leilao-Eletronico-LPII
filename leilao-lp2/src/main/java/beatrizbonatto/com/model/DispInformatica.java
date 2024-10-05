package beatrizbonatto.com.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.persistence.Entity;

@Entity
@Schema(description = "Dispositivo de Informatica a ser leiloado")
public class DispInformatica extends Produto {
    private TipoDispositivo tipoDispositivo;
    private String marca;
    private String modelo;
    private String complemento;

    public DispInformatica(Long id, String nome, String tipo, String descricao, Double precoInicial,
            TipoDispositivo tipoDispositivo, String marca, String modelo, String serie, String complemento) {
        super(id, nome, "Dispositivo de Informarica", descricao, precoInicial);
        this.tipoDispositivo = tipoDispositivo;
        this.marca = marca;
        this.modelo = modelo;
        this.complemento = complemento;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    

}
