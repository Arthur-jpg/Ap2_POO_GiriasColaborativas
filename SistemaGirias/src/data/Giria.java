package data;

public class Giria extends Conteudo  implements Votavel, Editavel {
    private String termo;
    private Explicacao[] explicacao;
    private Categoria[] categorias;
    private Regiao[] regioes;
    private Voto[] votos;
    private Edicao[] historicoEdicoes;

    public Giria(String id, Usuario autor, String termo, Explicacao[] explicacao, Categoria[] categorias, Regiao[] regioes, Voto[] votos, Edicao[] historicoEdicoes) {
        super(id, autor);
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
    public void removerVoto(boolean tipoDeVoto) {

    }

    // ...existing code...
    @Override
    public void adicionarVoto(boolean tipoDeVoto) {
        // Exemplo simples (sem usar ArrayList) para mostrar a lógica de inserir em um array

        // 1) Criar o novo objeto Voto.
        //    Aqui, por exemplo, ficaria algo como:
        Usuario autorVoto = null; // ou alguma forma de obter o usuário que está votando
        Voto novoVoto = new Voto("idAleatorio", tipoDeVoto, autorVoto, this);

        // 2) Criar um novo array com espaço adicional.
        int tamanhoAtual = this.votos.length;
        Voto[] novoArray = new Voto[tamanhoAtual + 1];

        // 3) Copiar os votos existentes.
        System.arraycopy(this.votos, 0, novoArray, 0, tamanhoAtual);

        // 4) Inserir o novo voto na última posição.
        novoArray[tamanhoAtual] = novoVoto;

        // 5) Substituir o array antigo pelo novo.
        this.votos = novoArray;
    }
    // ...existing code...
}
