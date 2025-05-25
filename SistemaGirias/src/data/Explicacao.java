package data;

public class Explicacao extends Conteudo implements Votavel, Editavel {
    private String id;
    private String texto;
    private String[] exemplos;
    private Giria giria;
    private Voto[] votos;
    private Edicao[] historicoEdicoes;

    public Explicacao(String id, String texto, String[] exemplos, Giria giria, Usuario autor) {
        super(id, autor);
        this.texto = texto;
        this.exemplos = exemplos;
        this.giria = giria;
        this.votos = new Voto[0]; 
        this.historicoEdicoes = new Edicao[0]; 
    }

    @Override
    public boolean editar(String novoConteudo, Usuario editor) {
        return false;
    }

    @Override
    public Edicao[] getHistoricoEdicoes() {
        return new Edicao[0];
    }

    @Override
    public String getConteudo() {
        return "";
    }

    @Override
    public int getVotos() {
        return 0;
    }

    @Override
    public void adicionarVoto(boolean tipoDeVoto) {

    }

    @Override
    public void removerVoto(boolean tipoDeVoto) {

    }
}
