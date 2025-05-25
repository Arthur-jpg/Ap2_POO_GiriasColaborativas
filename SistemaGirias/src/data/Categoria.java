package data;

public class Categoria {
    private String id;
    private String nome;
    private String descricao;

    public Categoria(String id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public String getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
