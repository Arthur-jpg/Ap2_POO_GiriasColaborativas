package data;

import java.time.LocalDateTime;

public class Edicao {
    private String id;
    private LocalDateTime dataEdicao;
    private String conteudoAnterior;
    private String conteudoNovo;
    private Usuario editor;
    private Editavel editavel;

    public Edicao(String id, String conteudoNovo, Usuario editor, Editavel editavel) {
        this.id = id;
        this.conteudoNovo = conteudoNovo;
        this.editor = editor;
        this.editavel = editavel;
        this.dataEdicao = LocalDateTime.now();
        this.conteudoAnterior = editavel.getConteudo();
    }
    
    public String getId() {
        return id;
    }
    
    public LocalDateTime getDataEdicao() {
        return dataEdicao;
    }
    
    public String getConteudoAnterior() {
        return conteudoAnterior;
    }
    
    public String getConteudoNovo() {
        return conteudoNovo;
    }
    
    public Usuario getEditor() {
        return editor;
    }
    
    public Editavel getEditavel() {
        return editavel;
    }
}
