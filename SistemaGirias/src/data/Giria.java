package data;

public class Giria extends Conteudo  implements Votavel, Editavel {
    private String termo;
    private Explicacao[] explicacao;
    private Categoria[] categorias;
    private Regiao[] regioes;
    private Voto[] votos;
    private Edicao[] historicoEdicoes;

    public Giria(String id, Usuario autor, boolean ativo, String termo, Explicacao[] explicacao, Categoria[] categorias, Regiao[] regioes, Voto[] votos, Edicao[] historicoEdicoes) {
        super(id, autor, ativo);
        this.termo = termo;
        this.explicacao = explicacao;
        this.categorias = categorias;
        this.regioes = regioes;
        this.votos = votos;
        this.historicoEdicoes = historicoEdicoes;
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
