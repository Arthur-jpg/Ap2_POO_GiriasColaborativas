package data;

import java.time.LocalDateTime;

public class Voto {
    private String id;
    private boolean tipoDeVoto;
    private LocalDateTime dataPostagem;
    private Usuario usuario;
    private Votavel votavel;

    public Voto(String id, boolean tipoDeVoto, Usuario usuario, Votavel votavel) {
        this.id = id;
        this.tipoDeVoto = tipoDeVoto;
        this.usuario = usuario;
        this.votavel = votavel;
        this.dataPostagem = LocalDateTime.now();
    }
    
    public String getId() {
        return id;
    }
    
    public boolean getTipoDeVoto() {
        return tipoDeVoto;
    }
    
    public LocalDateTime getDataPostagem() {
        return dataPostagem;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public Votavel getVotavel() {
        return votavel;
    }
    
    // Retorna o valor do voto (+1 ou -1)
    public int getValor() {
        return tipoDeVoto ? 1 : -1;
    }
}
