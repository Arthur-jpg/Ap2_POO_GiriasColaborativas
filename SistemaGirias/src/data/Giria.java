package data;

public class Giria extends Conteudo implements Votavel, Editavel {
    private String termo;
    private Explicacao[] explicacoes;
    private Categoria[] categorias;
    private Regiao[] regioes;
    private Voto[] votos;
    private Edicao[] historicoEdicoes;

    public Giria(String id, Usuario autor, String termo, Explicacao[] explicacoes, Categoria[] categorias, Regiao[] regioes, Voto[] votos, Edicao[] historicoEdicoes) {
        super(id, autor);
        this.termo = termo;
        this.explicacoes = explicacoes;
        this.categorias = categorias;
        this.regioes = regioes;
        this.votos = votos;
        this.historicoEdicoes = historicoEdicoes;
    }

    public String getTermo() {
        return termo;
    }

    public Explicacao[] getExplicacoes() {
        return explicacoes;
    }

    public Categoria[] getCategorias() {
        return categorias;
    }

    public Regiao[] getRegioes() {
        return regioes;
    }

    public void adicionarExplicacao(Explicacao explicacao) {
        int tamanhoAtual = this.explicacoes.length;
        Explicacao[] novoArray = new Explicacao[tamanhoAtual + 1];
        
        // Copiar as explicações existentes
        System.arraycopy(this.explicacoes, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar a nova explicação
        novoArray[tamanhoAtual] = explicacao;
        
        // Atualizar o array de explicações
        this.explicacoes = novoArray;
    }

    public void adicionarCategoria(Categoria categoria) {
        int tamanhoAtual = this.categorias.length;
        Categoria[] novoArray = new Categoria[tamanhoAtual + 1];
        
        // Copiar as categorias existentes
        System.arraycopy(this.categorias, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar a nova categoria
        novoArray[tamanhoAtual] = categoria;
        
        // Atualizar o array de categorias
        this.categorias = novoArray;
    }

    public void adicionarRegiao(Regiao regiao) {
        int tamanhoAtual = this.regioes.length;
        Regiao[] novoArray = new Regiao[tamanhoAtual + 1];
        
        // Copiar as regiões existentes
        System.arraycopy(this.regioes, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar a nova região
        novoArray[tamanhoAtual] = regiao;
        
        // Atualizar o array de regiões
        this.regioes = novoArray;
    }

    public Explicacao getExplicacaoMaisVotada() {
        if (explicacoes.length == 0) {
            return null;
        }
        
        Explicacao maisVotada = explicacoes[0];
        int maiorNumVotos = explicacoes[0].getVotos();
        
        for (int i = 1; i < explicacoes.length; i++) {
            if (explicacoes[i].getVotos() > maiorNumVotos) {
                maisVotada = explicacoes[i];
                maiorNumVotos = explicacoes[i].getVotos();
            }
        }
        
        return maisVotada;
    }

    @Override
    public boolean editar(String novoTermo, Usuario editor) {
        if (!isAtivo()) {
            return false;
        }
        
        // Criar uma nova edição
        String id = "ed_" + System.currentTimeMillis(); // ID baseado no timestamp
        Edicao novaEdicao = new Edicao(id, novoTermo, editor, this);
        
        // Atualizar o termo
        this.termo = novoTermo;
        
        // Adicionar à lista de edições
        int tamanhoAtual = historicoEdicoes.length;
        Edicao[] novoArray = new Edicao[tamanhoAtual + 1];
        
        // Copiar as edições existentes
        System.arraycopy(historicoEdicoes, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar a nova edição
        novoArray[tamanhoAtual] = novaEdicao;
        
        // Atualizar o array de histórico
        historicoEdicoes = novoArray;
        
        return true;
    }

    @Override
    public Edicao[] getHistoricoEdicoes() {
        return historicoEdicoes;
    }

    @Override
    public String getConteudo() {
        return termo;
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
    public void removerVoto(boolean tipoDeVoto) {
        // Esta implementação é simplificada, mas normalmente você precisaria
        // identificar qual voto específico remover (por usuário ou ID)
        
        if (votos.length == 0) {
            return; // Não há votos para remover
        }
        
        // Criar um novo array com um elemento a menos
        Voto[] novoArray = new Voto[votos.length - 1];
        
        // Encontrar um voto do tipo especificado para remover (o primeiro)
        boolean encontrado = false;
        int j = 0;
        
        for (int i = 0; i < votos.length; i++) {
            if (!encontrado && votos[i].getTipoDeVoto() == tipoDeVoto) {
                encontrado = true;
                continue; // Pula este voto (efetivamente o remove)
            }
            
            // Se o índice j ultrapassar o tamanho do novo array, saímos do loop
            if (j >= novoArray.length) break;
            
            novoArray[j++] = votos[i];
        }
        
        // Se um voto foi removido, atualize o array
        if (encontrado) {
            votos = novoArray;
        }
    }

    @Override
    public void adicionarVoto(boolean tipoDeVoto) {
        // Gerar um ID para o voto
        String id = "voto_" + System.currentTimeMillis(); // ID baseado no timestamp
        
        // Criar o novo voto
        Usuario autorVoto = null; // Aqui deveria vir o usuário logado
        Voto novoVoto = new Voto(id, tipoDeVoto, autorVoto, this);
        
        // Adicionar à lista de votos
        int tamanhoAtual = this.votos.length;
        Voto[] novoArray = new Voto[tamanhoAtual + 1];
        
        // Copiar os votos existentes
        System.arraycopy(this.votos, 0, novoArray, 0, tamanhoAtual);
        
        // Adicionar o novo voto
        novoArray[tamanhoAtual] = novoVoto;
        
        // Atualizar o array de votos
        votos = novoArray;
    }
    
    @Override
    public String toString() {
        return termo;
    }
}
