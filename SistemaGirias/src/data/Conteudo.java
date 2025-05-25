package data;

import java.time.LocalDateTime;

abstract class Conteudo {
    private String id;
    private LocalDateTime dataCriacao;
    private Usuario autor;
    private boolean ativo;

    public Conteudo(String id, Usuario autor) {
        this.id = id;
        this.autor = autor;
        this.dataCriacao = LocalDateTime.now();
        this.ativo = true;
    }
    
    public String getId() {
        return id;
    }
    
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
      public Usuario getAutor() {
        return autor;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void desativar() {
        this.ativo = false;
    }
    
    public void reativar() {
        this.ativo = true;
    }
    
    public abstract String getConteudo();
}
