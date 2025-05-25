package data;

import java.time.LocalDateTime;

public class Voto {
    private String id;
    private boolean tipoDeVoto;
    private LocalDateTime dataPostagem;
    /*Um voto pertence a um único usuário */
    private Usuario usuario;
    /* Um voto pertence a um único conteúdo votável */
    private Votavel votavel;

    public Voto(String id, boolean tipoDeVoto, Usuario usuario, Votavel votavel) {
        this.id = id;
        this.tipoDeVoto = tipoDeVoto;
        this.usuario = usuario;
        this.votavel = votavel;
        /*A data de postagem é definida automaticamente como a data e hora atuais */
        this.dataPostagem = LocalDateTime.now();
    }

}
