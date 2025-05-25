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
    private Giria[] girias;
    private Explicacao[] explicacoes;

    public Usuario(String id, String nome, String email, String senha, int reputacao, boolean admin) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.reputacao = reputacao;
        this.admin = admin;
        this.dataCadastro = LocalDateTime.now();
        
        this.votos = new Voto[0];
        this.girias = new Giria[0];
        this.explicacoes = new Explicacao[0];
    }
    
    public String getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public int getReputacao() {
        return reputacao;
    }
    
    public boolean isAdmin() {
        return admin;
    }
    
    public Giria[] getGirias() {
        return girias;
    }
    
    public Explicacao[] getExplicacoes() {
        return explicacoes;
    }
    
    public Voto[] getVotos() {
        return votos;
    }

    public Giria addGiria(String id, String termo, Explicacao[] explicacoes, Categoria[] categorias, Regiao[] regioes) {
        // Inicializa arrays vazios para os novos elementos
        Voto[] votos = new Voto[0];
        Edicao[] historicoEdicoes = new Edicao[0];
        
        // Cria a nova gíria
        Giria novaGiria = new Giria(
            id,
            this,
            termo,
            explicacoes != null ? explicacoes : new Explicacao[0],
            categorias != null ? categorias : new Categoria[0],
            regioes != null ? regioes : new Regiao[0],
            votos,
            historicoEdicoes
        );
        
        // Adiciona a gíria ao array de gírias do usuário
        int tamanhoAtual = this.girias.length;
        Giria[] novoArray = new Giria[tamanhoAtual + 1];
        
        // Copiar as gírias existentes
        System.arraycopy(this.girias, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar a nova gíria
        novoArray[tamanhoAtual] = novaGiria;
        
        // Atualizar o array de gírias
        this.girias = novoArray;
        
        return novaGiria;
    }

    public Explicacao addExplicacao(String id, String texto, String[] exemplos, Giria giria) {
        // Criar a nova explicação
        Explicacao novaExplicacao = new Explicacao(id, texto, exemplos, giria, this);
        
        // Adicionar a explicação à gíria correspondente
        giria.adicionarExplicacao(novaExplicacao);
        
        // Adicionar a explicação ao array de explicações do usuário
        int tamanhoAtual = this.explicacoes.length;
        Explicacao[] novoArray = new Explicacao[tamanhoAtual + 1];
        
        // Copiar as explicações existentes
        System.arraycopy(this.explicacoes, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar a nova explicação
        novoArray[tamanhoAtual] = novaExplicacao;
        
        // Atualizar o array de explicações
        this.explicacoes = novoArray;
        
        return novaExplicacao;
    }

    public void votar(Votavel votavel, boolean tipoDeVoto) {
        // Criar o voto e adicionar ao item votável
        String id = "voto_" + System.currentTimeMillis();
        Voto novoVoto = new Voto(id, tipoDeVoto, this, votavel);
        
        // Adicionar o voto ao array de votos do usuário
        int tamanhoAtual = this.votos.length;
        Voto[] novoArray = new Voto[tamanhoAtual + 1];
        
        // Copiar os votos existentes
        System.arraycopy(this.votos, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar o novo voto
        novoArray[tamanhoAtual] = novoVoto;
        
        // Atualizar o array de votos
        this.votos = novoArray;
        votavel.adicionarVoto(tipoDeVoto);
        calcularReputacao();
    }
    
    public int calcularReputacao() {
        // A reputação é baseada nos votos nas gírias e explicações do usuário
        int novaReputacao = 0;
        
        // Somar os votos das gírias criadas pelo usuário
        for (Giria giria : girias) {
            novaReputacao += giria.getVotos();
        }
        
        // Somar os votos das explicações criadas pelo usuário
        for (Explicacao explicacao : explicacoes) {
            novaReputacao += explicacao.getVotos();
        }
        
        // Atualizar a reputação do usuário
        this.reputacao = novaReputacao;
        
        return this.reputacao;
    }
    
    public boolean isElegivel(int nivelMinimo) {
        return this.reputacao >= nivelMinimo || this.admin;
    }
    
    @Override
    public String toString() {
        return nome + " (" + email + ")";
    }
}
