package data;

public class Explicacao extends Conteudo implements Votavel, Editavel {
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

    public String getTexto() {
        return texto;
    }
    
    public String[] getExemplos() {
        return exemplos;
    }
    
    public Giria getGiria() {
        return giria;
    }
    
    public void adicionarExemplo(String exemplo) {
        int tamanhoAtual = this.exemplos.length;
        String[] novoArray = new String[tamanhoAtual + 1];
        
        // Copiar os exemplos existentes
        System.arraycopy(this.exemplos, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar o novo exemplo
        novoArray[tamanhoAtual] = exemplo;
        
        // Atualizar o array de exemplos
        this.exemplos = novoArray;
    }

    @Override
    public boolean editar(String novoTexto, Usuario editor) {
        if (!isAtivo()) {
            return false;
        }

        String id = "ed_" + System.currentTimeMillis(); // ID baseado no timestamp
        Edicao novaEdicao = new Edicao(id, novoTexto, editor, this);

        this.texto = novoTexto;

        int tamanhoAtual = historicoEdicoes.length;
        Edicao[] novoArray = new Edicao[tamanhoAtual + 1];

        System.arraycopy(historicoEdicoes, 0, novoArray, 0, tamanhoAtual);

        novoArray[tamanhoAtual] = novaEdicao;

        historicoEdicoes = novoArray;
        
        return true;
    }

    @Override
    public Edicao[] getHistoricoEdicoes() {
        return historicoEdicoes;
    }

    @Override
    public String getConteudo() {
        return texto;
    }

    @Override
    public int getVotos() {
        int total = 0;
        for (Voto voto : votos) {
            total += voto.getValor();
        }
        return total;
    }

    @Override
    public void adicionarVoto(boolean tipoDeVoto) {
        String id = "voto_" + System.currentTimeMillis(); // ID baseado no timestamp
        

        Usuario autorVoto = null; // Aqui deveria vir o usuário logado
        Voto novoVoto = new Voto(id, tipoDeVoto, autorVoto, this);

        int tamanhoAtual = votos.length;
        Voto[] novoArray = new Voto[tamanhoAtual + 1];

        System.arraycopy(votos, 0, novoArray, 0, tamanhoAtual);

        novoArray[tamanhoAtual] = novoVoto;

        votos = novoArray;
    }

    @Override
    public void removerVoto(boolean tipoDeVoto) {
        
        if (votos.length == 0) {
            return; // Não há votos para remover
        }

        Voto[] novoArray = new Voto[votos.length - 1];

        boolean encontrado = false;
        int j = 0;
        
        for (int i = 0; i < votos.length; i++) {
            if (!encontrado && votos[i].getTipoDeVoto() == tipoDeVoto) {
                encontrado = true;
                continue; // Pula este voto (efetivamente o remove)
            }

            if (j >= novoArray.length) break;
            
            novoArray[j++] = votos[i];
        }

        if (encontrado) {
            votos = novoArray;
        }
    }
    
    @Override
    public String toString() {
        return texto;
    }
}
