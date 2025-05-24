package data;

import java.time.LocalDateTime;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    private int reputacao;
    private boolean admin;
    private Voto[] votos;

    public Usuario(String id, String nome, String email, String senha, int reputacao, boolean admin) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.reputacao = reputacao;
        this.admin = admin;
        /*A data de cadastro é definida automaticamente como a data e hora atuais */
        this.dataCadastro = LocalDateTime.now();
    }

    public void addGiria(Voto g) {
        // Implementar lógica para adicionar gíria
    }
}
