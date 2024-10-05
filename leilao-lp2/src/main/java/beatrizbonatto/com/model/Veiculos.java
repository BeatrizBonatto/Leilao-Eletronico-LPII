package beatrizbonatto.com.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.locationtech.jts.geom.impl.PackedCoordinateSequence.Double;

import jakarta.persistence.Entity;

@Entity
@Schema(description = "Veiculo a ser leiloado")
public class Veiculos extends Produto {
    private TipoVeiculo tipoVeiculo;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private Double km_rodados;
    private String placa;

    public Veiculos(Long id, String tipo, String descricao, java.lang.Double precoInicial, Leilao leilao,
            TipoVeiculo tipoVeiculo, String marca, String modelo, Integer ano, String cor, Double km_rodados, String placa) {
        super(id, "Veiculo", descricao, precoInicial, leilao);
        this.tipoVeiculo = tipoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.km_rodados = km_rodados;
        this.placa = placa;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }
    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
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
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public Double getKm_rodados() {
        return km_rodados;
    }
    public void setKm_rodados(Double km_rodados) {
        this.km_rodados = km_rodados;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
