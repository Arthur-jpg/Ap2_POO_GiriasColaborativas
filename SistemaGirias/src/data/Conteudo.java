package data;

import java.time.LocalDateTime;

abstract class Conteudo {
    private String id;
    private LocalDateTime dataCriacao;
    private Usuario autor;

    public Conteudo(String id, Usuario autor) {
        this.id = id;
        this.autor = autor;
        // Define a data de criação como o momento atual
        this.dataCriacao = LocalDateTime.now(); 
    }
}
