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



    public void addGiria(String id,String termo,Explicacao[] explicacoes,Categoria[] categorias,Regiao[] regioes) {
        Voto[] votos = new Voto[0];
        Edicao[] historicoEdicoes = new Edicao[0];
        
        Giria novaGiria = new Giria(
            id,
            this,
            termo,
            explicacoes,
            categorias,
            regioes,
            votos,
            historicoEdicoes
        );

    }

    public void addExplicacao(String id, String texto, String[] exemplos, Giria giria, Usuario autor) {
        Explicacao novaExplicacao = new Explicacao(id, texto, exemplos, giria, autor);
    }

    public void votar(Votavel votavel, boolean tipoDeVoto) {
        votavel.adicionarVoto(tipoDeVoto);
    }



}
