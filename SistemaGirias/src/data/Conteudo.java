package data;

import java.time.LocalDateTime;

abstract class Conteudo {
    private String id;
    private LocalDateTime dataCriacao;
    private Usuario autor;
    private boolean ativo;

    public Conteudo(String id, Usuario autor, boolean ativo) {
        this.id = id;
        this.autor = autor;
        this.ativo = ativo;
        // Define a data de criação como o momento atual
        this.dataCriacao = LocalDateTime.now(); 
    }
}
