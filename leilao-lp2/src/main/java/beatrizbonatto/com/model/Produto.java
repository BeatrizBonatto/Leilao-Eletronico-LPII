package beatrizbonatto.com.model;

public class Produto {
    private Long id;
    private String nome;
    private String tipo;
    private double precoInicial;

    // Construtor
    public Produto(Long id, String nome, String tipo, double precoInicial) {
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

    public double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }
}
