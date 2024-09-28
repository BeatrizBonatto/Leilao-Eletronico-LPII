package beatrizbonatto.com.model;

public class Produto {
    private Long id;
    private String nome;
    private String tipo;
    private Double precoInicial;

    // Construtor
    public Produto(Long id, String nome, String tipo, Double precoInicial) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.precoInicial = precoInicial;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(Double precoInicial) {
        this.precoInicial = precoInicial;
    }
}
